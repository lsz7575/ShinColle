package com.lulan.shincolle.ai;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

import com.lulan.shincolle.entity.BasicEntityAirplane;
import com.lulan.shincolle.utility.BlockHelper;
import com.lulan.shincolle.utility.LogHelper;

/**AIRCRAFT ATTACK AI
 * entity必須實作attackEntityWithAmmo, attackEntityWithHeavyAmmo 兩個方法
 */
public class EntityAIShipAircraftAttack extends EntityAIBase {
	
	private Random rand = new Random();
    private BasicEntityAirplane host;  	//entity with AI
    private Entity target;  //entity of target
    private int atkDelay = 0;		//attack delay (attack when time <= 0)
    private int maxDelay = 0;	    //attack max delay (calc from attack speed)  
    private float attackRange = 4F;	//attack range
    private float rangeSq;			//attack range square
    private double[] randPos = new double[3];		//random position
    
    //直線前進用餐數
    private double distSq, distX, distY, distZ, motX, motY, motZ;	//跟目標的直線距離(的平方)    
    private double distRanSqrt, distRanX, distRanY, distRanZ, ranX, ranY, ranZ;	//隨機找的目的地
    
    public EntityAIShipAircraftAttack(BasicEntityAirplane host) {
        if (!(host instanceof BasicEntityAirplane)) {
            throw new IllegalArgumentException("AircraftAttack AI requires BasicEntityAirplane");
        }
        else {
            this.host = host;
            this.setMutexBits(3);
        }
    }

    //check ai start condition
    @Override
	public boolean shouldExecute() {
    	Entity target = this.host.getEntityTarget();
    	
    	//no ammo, go home
    	if(!this.host.canFindTarget) return false;

        if (this.host.ticksExisted > 20 && target != null && target.isEntityAlive() && 
        	((this.host.useAmmoLight && this.host.numAmmoLight > 0) || 
        	(this.host.useAmmoHeavy && this.host.numAmmoHeavy > 0))) {   
        	this.target = target;

            return true;
        }
        return false;
    }
    
    //init AI parameter, call once every target
    @Override
    public void startExecuting() {
    	this.maxDelay = (int)(80F / (this.host.atkSpeed)) + 10;
        this.attackRange = 7.5F;
        this.rangeSq = this.attackRange * this.attackRange;
        distSq = distX = distY = distZ = motX = motY = motZ = 0D;
        //AI移動設定
        randPos[0] = target.posX;
        randPos[1] = target.posX;
        randPos[2] = target.posX;
    }

    //判定是否繼續AI： 有target就繼續, 或者已經移動完畢就繼續
    @Override
	public boolean continueExecuting() {
    	//no ammo, go home
    	if(!this.host.canFindTarget) return false;
    	
    	//跑should exec, 若false則檢查是否還在移動中, 若無法移動則結束
        return this.shouldExecute()  || (target != null && target.isEntityAlive() && !this.host.getShipNavigate().noPath());
    }

    //重置AI方法
    @Override
	public void resetTask() {
        this.target = null;
        //keep moving, do not stop in air
        randPos = BlockHelper.findRandomPosition(this.host, this.host, 4D, 2D, 2);
        this.host.getShipNavigate().tryMoveToXYZ(randPos[0], randPos[1], randPos[2], 1D);
    }

    //進行AI
    @Override
	public void updateTask() {
    	boolean onSight = false;	//判定直射是否無障礙物
    	
    	if(this.target != null) {
            onSight = this.host.getEntitySenses().canSee(this.target);
//            LogHelper.info("DEBUG : rand pos: "+this.target);
            
            //目標距離計算
            this.distX = this.target.posX - this.host.posX;
    		this.distY = this.target.posY+2D - this.host.posY;
    		this.distZ = this.target.posZ - this.host.posZ;	
    		this.distSq = distX*distX + distY*distY + distZ*distZ;

        	if(this.host.ticksExisted % 16 == 0) {
	        	randPos = BlockHelper.findRandomPosition(this.host, this.target, 3D, 3D, 1);
//	        	LogHelper.info("DEBUG : rand pos: "+this.host+" "+randPos[0]+" "+randPos[1]+" "+randPos[2]);
	        	//目標在射程外, 則100%速度前進
	        	if(this.distSq > this.rangeSq) {
		        	this.host.getShipNavigate().tryMoveToXYZ(randPos[0], randPos[1], randPos[2], 1D);
	        	}
	        	//目標在射程內, 則緩速移動
	        	else {
		        	this.host.getShipNavigate().tryMoveToXYZ(randPos[0], randPos[1], randPos[2], 0.4D);
	        	}
        	}
	        
	        //delay time decr
	        this.atkDelay--;
	        
	        onSight = this.host.getEntitySenses().canSee(this.target);

	        //若attack delay倒數完了且瞄準時間夠久, 則開始攻擊
	        if(this.atkDelay <= 0 && onSight) {
	        	//由於艦載機只會輕 or 重其中一種攻擊, 因此AI這邊共用cooldown
	        	if(this.distSq < this.rangeSq && this.host.numAmmoLight > 0 && this.host.useAmmoLight) {
		            //attack method
		            this.host.attackEntityWithAmmo(this.target);
		            this.atkDelay = this.maxDelay;
	        	}
	        	
	        	if(this.distSq < this.rangeSq && this.host.numAmmoHeavy > 0 && this.host.useAmmoHeavy) {
		            //attack method
		            this.host.attackEntityWithHeavyAmmo(this.target);
		            this.atkDelay = this.maxDelay;
	        	}	
	        }
    	}//end attack target != null
    }
}
