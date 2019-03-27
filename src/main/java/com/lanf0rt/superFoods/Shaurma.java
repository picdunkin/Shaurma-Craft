package com.lanf0rt.superFoods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.Random;

public class Shaurma extends ItemFood  implements SuperFood{

	 private int tier = 1;
	 private double poisonChance = 0;

	 public Shaurma(String name,String textureName, int tier,int i, float f, boolean k){
		    super(i,f,k);
		    this.setUnlocalizedName(name).setTextureName("sfs:"+textureName).setCreativeTab(SuperFoods.superFoodsTab);

		    this.tier = tier;
		    this.poisonChance = 0.02 /((this.tier > 0) ? tier : Double.MIN_VALUE);
	 }

	 public EnumAction getItemUseAction(ItemStack par1ItemStack)
	    {
	        return EnumAction.eat;
	    }
	 @Override
	 public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		 super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
//		  par3EntityPlayer.getFoodStats().addStats(1,1F);
//		  par2World.playSoundAtEntity(par3EntityPlayer, "random.burp", 0.5F, par2World.rand.nextFloat() * 0.1F + 0.9F);
//		  par1ItemStack.stackSize--;
		  Random r = new Random();

		  if(r.nextFloat() < poisonChance) {
			  par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.poison.id, 3600/11, 0));
			  par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 3600/11, 0));
		  }else{
			  par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 360, 1));
			  par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 360, 1));
		  }
		  //par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(Item.glassBottle));
	}
}
