package gg.rosie;

import gg.rosie.registry.ImmersiveWeaponsBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class ImmersiveWeaponsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ImmersiveWeaponsBlocks.getBlock("soul_glass"),
				RenderLayer.getTranslucent());
	}
}
