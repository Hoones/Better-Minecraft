package Hoones.mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import Hoones.mod.proxy.Proxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.*;

@Mod(modid = "Better Minecraft", name = "Better Minecraft", version = "0.0.1")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class bassis {
	
	@Instance("mod")
	public static bassis instance;
	
	@SidedProxy(clientSide="Hoones.mod.proxy.ClientProxy", serverSide="Hoones.mod.proxy.Proxy")
	public static Proxy proxy;
	
	public static Block Erde;
	public int ErdeBlockID = 1046;
	
	public static Item Stein;
	public int SteinItemID = 1043;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		
	}

	@Init
	public void init(FMLInitializationEvent event) {
		
		Erde = new Erde(ErdeBlockID, Material.ground).setCreativeTab(CreativeTabs.tabDecorations).setStepSound(Block.soundGravelFootstep);
		Stein = new Stein(SteinItemID).setCreativeTab(CreativeTabs.tabDecorations);
		Block.commandBlock.setCreativeTab(CreativeTabs.tabDecorations);
		
		
		Craft();
		registerItems();
		registerBlock();
		updateLanguage();
		
	}

	@PostInit
	public static void postInit(FMLPostInitializationEvent event) {
	}
	private void Craft(){
		
		//Erde
		
		GameRegistry.addShapelessRecipe(new ItemStack(Erde, 1), new ItemStack (Block.dirt), new ItemStack (Item.dyePowder,0 ,3));
		
		//Stein
		
		GameRegistry.addShapelessRecipe(new ItemStack(Stein, 1), new ItemStack (Block.cobblestone), new ItemStack (Block.cobblestone), new ItemStack (Block.cobblestone), new ItemStack (Block.cobblestone));
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestone, 4), new ItemStack(Stein));
		//MouseStein
		
		GameRegistry.addShapelessRecipe(new ItemStack(Block.cobblestoneMossy), new ItemStack(Block.cobblestone, 1), new ItemStack(Item.seeds), new ItemStack(Item.seeds), new ItemStack(Item.seeds), new ItemStack(Item.seeds));
		
		//Mouse Wand
		
		GameRegistry.addRecipe(new ItemStack(Block.cobblestoneWall, 1, 1),
		                                                       "###",
		                                                       "XXX",
		                                                       "XXX",
		                                      'X', Block.cobblestone, '#' ,Item.seeds);
		
		//Mouse Wand Upgrade
		
		GameRegistry.addShapelessRecipe(new ItemStack (Block.cobblestoneWall, 1, 1), new ItemStack(Block.cobblestoneWall), new ItemStack(Item.seeds), new ItemStack(Item.seeds), new ItemStack(Item.seeds), new ItemStack(Item.seeds));
	}
	private void registerBlock(){
		GameRegistry.registerBlock(Erde, "Dirt");
    }
    private void updateLanguage(){
    	LanguageRegistry.addName(Erde, "Better Dirt");
    	LanguageRegistry.addName(Stein, "Store Stone");
    }
    private void registerItems(){
    	GameRegistry.registerItem(Stein, "Stein");

		
	
		
	}
}