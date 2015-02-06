package com.lulan.shincolle.ai;

import com.lulan.shincolle.entity.BasicEntityShip;
import com.lulan.shincolle.utility.LogHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.pathfinding.PathEntity;

/**SIT AI FOR SHIP
 * 可以在液體中坐下
 */
public class EntityAIShipSit extends EntityAIBase
{
    private BasicEntityShip theEntity;
    private EntityLivingBase theOwner;

    public EntityAIShipSit(BasicEntityShip entity, EntityLivingBase owner) {
        this.theEntity = entity;
        this.theOwner = owner;
        this.setMutexBits(5);
    }

    public boolean shouldExecute() {
        //必須是主人 & 主人沒有AI target & 該生物為坐下狀態
        return this.theOwner == null ? true : 
        	(this.theOwner.getAITarget() != null ? false : this.theEntity.isSitting());
    }

    public void startExecuting() {
    	this.theEntity.setSitting(true);
    	this.theEntity.setJumping(false);
    }
    
    public void updateTask() {
    	this.theEntity.getNavigator().clearPathEntity();    
        this.theEntity.setPathToEntity((PathEntity)null);
        this.theEntity.setTarget((Entity)null);
        this.theEntity.setAttackTarget((EntityLivingBase)null);
    }

    public void resetTask() {
        this.theEntity.setSitting(false);
    }

}
