package com.lanf0rt.superFoods;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class Meat extends ItemFood {

    Meat(String name, String textureName, int i, float f, boolean k) {
        super(i, f, k);
        this.setUnlocalizedName(name).setTextureName("sfs:" + textureName).setCreativeTab(SuperFoods.superFoodsTab);
    }

    @Override
    public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
//        if(this.getUnlocalizedName().substring(5).equals("Cat"))
//            par3EntityPlayer.inventory.dropAllItems();
//        else if(this.getUnlocalizedName().substring(5).equals("Dog"))
//            par3EntityPlayer.respawnPlayer();
        Random r = new Random();

        if(r.nextFloat() < 0.5f) {
        par3EntityPlayer.inventory.dropAllItems();
        }else {
            par3EntityPlayer.respawnPlayer();
        }

    }



}