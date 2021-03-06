package com.lulan.shincolle.entity.battleship;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.lulan.shincolle.ai.EntityAIShipCarrierAttack;
import com.lulan.shincolle.ai.EntityAIShipRangeAttack;
import com.lulan.shincolle.entity.BasicEntityShipLarge;
import com.lulan.shincolle.entity.ExtendShipProps;
import com.lulan.shincolle.handler.ConfigHandler;
import com.lulan.shincolle.network.S2CSpawnParticle;
import com.lulan.shincolle.proxy.CommonProxy;
import com.lulan.shincolle.reference.ID;
import com.lulan.shincolle.reference.Reference;
import com.lulan.shincolle.utility.CalcHelper;

import cpw.mods.fml.common.network.NetworkRegistry.TargetPoint;

public class EntityBattleshipRe extends BasicEntityShipLarge {
	
	public EntityBattleshipRe(World world) {
		super(world);
		this.setSize(0.6F, 1.8F);
		this.setStateMinor(ID.M.ShipType, ID.ShipType.BATTLESHIP);
		this.setStateMinor(ID.M.ShipClass, ID.Ship.BattleshipRE);
		this.setStateMinor(ID.M.DamageType, ID.ShipDmgType.AVIATION);
		this.ModelPos = new float[] {-6F, 10F, 0F, 40F};
		ExtProps = (ExtendShipProps) getExtendedProperties(ExtendShipProps.SHIP_EXTPROP_NAME);	
		this.initTypeModify();
		
		this.launchHeight = this.height * 0.8F;
	}
	
	@Override
	public float getEyeHeight() {
		return 1.7375F;
	}
	
	//equip type: 1:cannon+misc 2:cannon+airplane+misc 3:airplane+misc
	@Override
	public int getEquipType() {
		return 2;
	}
	
	@Override
	public void setAIList() {
		super.setAIList();
		//use range attack
		this.tasks.addTask(11, new EntityAIShipCarrierAttack(this));		   //0100
		this.tasks.addTask(12, new EntityAIShipRangeAttack(this));			   //0011
	}

	//增加艦載機數量計算
	@Override
	public void calcShipAttributes() {
		EffectEquip[ID.EF_DHIT] = EffectEquip[ID.EF_DHIT] + 0.2F;
		EffectEquip[ID.EF_THIT] = EffectEquip[ID.EF_THIT] + 0.2F;
		
		this.maxAircraftLight += 6;
		this.maxAircraftHeavy += 4;
		
		super.calcShipAttributes();	
	}
	
	@Override
	//range attack method, cost light ammo, attack delay = 20 / attack speed, damage = 100% atk 
	public boolean attackEntityWithAmmo(Entity target) {
		//get attack value
		float atk = CalcHelper.calcDamageByEquipEffect(this, target, StateFinal[ID.ATK], 0);
		//set knockback value (testing)
		float kbValue = 0.05F;
		
		//update entity look at vector (for particle spawn)
        //此方法比getLook還正確 (client sync問題)
        float distX = (float) (target.posX - this.posX);
        float distY = (float) (target.posY - this.posY);
        float distZ = (float) (target.posZ - this.posZ);
        float distSqrt = MathHelper.sqrt_float(distX*distX + distY*distY + distZ*distZ);
        distX = distX / distSqrt;
        distY = distY / distSqrt;
        distZ = distZ / distSqrt;
     
        //set attackTime
        TargetPoint point = new TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 64D);
//		CommonProxy.channel.sendToAllAround(new S2CSpawnParticle(this, 0, true), point);
        //spawn laser particle
//		CommonProxy.channel.sendToAllAround(new S2CSpawnParticle(14, worldObj.provider.dimensionId, posX, posY + 1.5D, posZ, target.posX, target.posY+target.height/2F, target.posZ), point);
		CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(this, 14, posX, posY + 1.5D, posZ, target.posX, target.posY+target.height/2F, target.posZ, true), point);
	
		//play sound: (sound name, volume, pitch) 
        playSound(Reference.MOD_ID+":ship-laser", 0.2F, 1F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        //play entity attack sound
        if(this.rand.nextInt(10) > 7) {
        	this.playSound(Reference.MOD_ID+":ship-hitsmall", 1F, 1F / (this.getRNG().nextFloat() * 0.3F + 1F));
        }
        
        //experience++
  		addShipExp(2);
  		
  		//grudge--
  		decrGrudgeNum(1);
        
        //light ammo -1
        if(!decrAmmoNum(0)) {		//not enough ammo
        	atk = atk * 0.125F;	//reduce damage to 12.5%
        }

        //calc miss chance, if not miss, calc cri/multi hit
        float missChance = 0.2F + 0.15F * (distSqrt / StateFinal[ID.HIT]) - 0.001F * StateMinor[ID.M.ShipLevel];
        missChance -= EffectEquip[ID.EF_MISS];		//equip miss reduce
        if(missChance > 0.35F) missChance = 0.35F;	//max miss chance
        
        if(this.rand.nextFloat() < missChance) {
        	atk = 0;	//still attack, but no damage
        	//spawn miss particle
        	CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(this, 10, false), point);
        }
        else {
        	//roll cri -> roll double hit -> roll triple hit (triple hit more rare)
        	//calc critical
        	if(this.rand.nextFloat() < EffectEquip[ID.EF_CRI]) {
        		atk *= 1.5F;
        		//spawn critical particle
        		CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(this, 11, false), point);
        	}
        	else {
        		//calc double hit
            	if(this.rand.nextFloat() < EffectEquip[ID.EF_DHIT]) {
            		atk *= 2F;
            		//spawn double hit particle
            		CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(this, 12, false), point);
            	}
            	else {
            		//calc double hit
                	if(this.rand.nextFloat() < EffectEquip[ID.EF_THIT]) {
                		atk *= 3F;
                		//spawn triple hit particle
                		CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(this, 13, false), point);
                	}
            	}
        	}
        }
        
        //vs player = 25% dmg
  		if(target instanceof EntityPlayer) {
  			atk *= 0.25F;
  			
  			//check friendly fire
    		if(!ConfigHandler.friendlyFire) {
    			atk = 0F;
    		}
    		else if(atk > 59F) {
    			atk = 59F;	//same with TNT
    		}
  		}

	    //將atk跟attacker傳給目標的attackEntityFrom方法, 在目標class中計算傷害
	    //並且回傳是否成功傷害到目標
	    boolean isTargetHurt = target.attackEntityFrom(DamageSource.causeMobDamage(this).setMagicDamage(), atk);

	    //if attack success
	    if(isTargetHurt) {
	    	//calc kb effect
	        if(kbValue > 0) {
	            target.addVelocity(-MathHelper.sin(rotationYaw * (float)Math.PI / 180.0F) * kbValue, 
	                   0.1D, MathHelper.cos(rotationYaw * (float)Math.PI / 180.0F) * kbValue);
	            motionX *= 0.6D;
	            motionZ *= 0.6D;
	        }
	        
        	//display hit particle on target
	        TargetPoint point1 = new TargetPoint(this.dimension, target.posX, target.posY, target.posZ, 64D);
			CommonProxy.channelP.sendToAllAround(new S2CSpawnParticle(target, 9, false), point1);
        }

	    return isTargetHurt;
	}
	
	@Override
	public int getKaitaiType() {
		return 1;
	}
	
	@Override
	public double getMountedYOffset() {
		if(this.isSitting()) {
  			return (double)this.height * 0.0F;
  		}
  		else {
  			return (double)this.height * 0.4F;
  		}
	}
	
	
}
