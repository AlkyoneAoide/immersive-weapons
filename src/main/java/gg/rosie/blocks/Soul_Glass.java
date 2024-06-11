package gg.rosie.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.GlassBlock;

public class Soul_Glass extends GlassBlock {
	public Soul_Glass(Settings settings) {
		super(settings);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
}
