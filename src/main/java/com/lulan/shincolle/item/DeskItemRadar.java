package com.lulan.shincolle.item;

import com.lulan.shincolle.ShinColle;
import com.lulan.shincolle.reference.ID;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DeskItemRadar extends BasicItem {
	
	public DeskItemRadar() {
		super();
		this.setUnlocalizedName("DeskItemRadar");
		this.maxStackSize = 1;
	}
	
	//right click to sign the paper
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(player != null) {  //開啟方塊GUI 參數:玩家, mod instance, gui ID, world, 自訂參數1,2,3
			FMLNetworkHandler.openGui(player, ShinColle.instance, ID.G.ADMIRALDESK_ITEM, world, 1, 0, 0);
		}
		return itemstack;
	}


}

