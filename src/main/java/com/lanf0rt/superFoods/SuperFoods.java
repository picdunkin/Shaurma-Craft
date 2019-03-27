package com.lanf0rt.superFoods;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "sfs", name = "Super Food", version = "1.1")
public class SuperFoods {

	public static Shaurma eliteShaurma;
	public static Shaurma shaurma;
	public static Item salad;
	public static Item lavash;
	public static Meat catMeat;
	public static Meat dogMeat;

	public static CookingDevice cookingDevice;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new MeatDropHandler());

		//Item/block init and register, config handle
		eliteShaurma = new Shaurma("EliteShaurma","eliteshaurma",2,20, 1.0F, false);
		shaurma = new Shaurma("Shaurma","shaurma",1,7, 1.0F, false);// 20 = max, x * 2

        catMeat = new Meat("CatMeat", "catmeat",7, 1.0F, true);
        dogMeat = new Meat("DogMeat", "dogmeat",12, 1.0F, false);

		salad = new ItemFood(5, 1.0F, false).setUnlocalizedName("Salad").setTextureName("sfs:salad").setCreativeTab(superFoodsTab);
		lavash = new ItemFood(2, 1.0F, false).setUnlocalizedName("Lavash").setTextureName("sfs:lavash").setCreativeTab(superFoodsTab);


		cookingDevice = new CookingDevice();

		GameRegistry.registerItem(eliteShaurma, eliteShaurma.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(shaurma, shaurma.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(salad, salad.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(lavash, lavash.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(catMeat, catMeat.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(dogMeat, dogMeat.getUnlocalizedName().substring(5));

	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		//proxy, timeentity, entyty, gui, packet reg


		GameRegistry.addRecipe(new ItemStack(salad, 16), "   ","T T"," T ", 'T' ,Items.reeds);

		GameRegistry.addRecipe(new ItemStack(lavash, 6), "   ","B B","B B", 'B', Items.bread);

		GameRegistry.addRecipe(new ItemStack(shaurma), " S "," M "," L ", 'M' ,Items.rotten_flesh, 'L', lavash, 'S', salad);
		GameRegistry.addRecipe(new ItemStack(shaurma), " S "," M "," L ", 'M' ,catMeat, 'L', lavash, 'S', salad);
		GameRegistry.addRecipe(new ItemStack(shaurma), " S "," M "," L ", 'M' ,dogMeat, 'L', lavash, 'S', salad);

		GameRegistry.addRecipe(new ItemStack(eliteShaurma, 16), "   ", "WSW"," B ", 'B' ,Items.dye, 'W', lavash, 'S', shaurma);
		//GameRegistry.addSmelting(eliteShaurma, new ItemStack(Blocks.diamond_block, 2), 1.0F);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		//proxy, timeentity, entyty, gui, packet reg

	}

	public static CreativeTabs superFoodsTab = new CreativeTabs("tabSuperFoods") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(eliteShaurma).getItem();
		}
	};
}