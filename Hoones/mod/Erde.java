package Hoones.mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class Erde extends Block {

	public Erde(int id, Material mat) {
		super(id, mat);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void registerIcons(IconRegister reg){
		this.blockIcon = reg.registerIcon("Better Minecraft:Erde");
	}

}