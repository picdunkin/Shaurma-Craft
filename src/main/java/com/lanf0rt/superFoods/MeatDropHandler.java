package com.lanf0rt.superFoods;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MeatDropHandler {

    @SubscribeEvent
    public void addDropItem(LivingDropsEvent event) {
        if(event.entityLiving instanceof EntityWolf){
        event.drops.add(new EntityItem(
                event.entityLiving.worldObj,
                event.entityLiving.posX,
                event.entityLiving.posY,
                event.entityLiving.posZ,
                new ItemStack(SuperFoods.dogMeat, 1)
        ));
        }
        else if(event.entityLiving instanceof EntityOcelot)
            event.drops.add(new EntityItem(
                    event.entityLiving.worldObj,
                    event.entityLiving.posX,
                    event.entityLiving.posY,
                    event.entityLiving.posZ,
                    new ItemStack(SuperFoods.catMeat)
            ));
    }
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new MeatDropHandler());
    }

}
