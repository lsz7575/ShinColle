package com.lulan.shincolle.entity;

import net.minecraft.entity.Entity;

/**SHIP ATTACK BASE
 * include attacker states getter/setter
 */
public interface IShipAttackBase extends IShipNavigator, IShipEmotion, IShipOwner, IShipAttributes {
	
	/** Get attack target */
	public Entity getEntityTarget();
	public void setEntityTarget(Entity target);
	
	/** Get revenge target for next attack target */
	public Entity getEntityRevengeTarget();
	public void setEntityRevengeTarget(Entity target);
	public int getEntityRevengeTime();
	public void setEntityRevengeTime();

	/**Get attack attributes */
	public float getAttackDamage();			//attack damage
	public float getAttackSpeed();			//attack speed
	public float getAttackRange();			//attack range
	
	public int getDamageType();				//damage type, ref: ID.ShipDmgType
	
	public boolean getAttackType(int par1);	//check available attack type: light, heavy, air, etc.
	
	public float getDefValue();				//defence value (%)
	
	public int getAmmoLight();				//get ammo info
	public int getAmmoHeavy();	
	public void setAmmoLight(int num);
	public void setAmmoHeavy(int num);
	public boolean hasAmmoLight();
	public boolean hasAmmoHeavy();
	
	public int getLevel();					//get ship level
	

}
