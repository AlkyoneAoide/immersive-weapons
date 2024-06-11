package gg.rosie.registry;

import gg.rosie.blocks.Soul_Glass;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ImmersiveWeaponsBlocks {
	private static final String MOD_ID = "immersive-weapons";

	private static LinkedHashMap<String, Block> blocks = new LinkedHashMap<>();

	// .strength() is hardness, resistance (or just hardness if only one arg)
	// hardnesses: https://minecraft.wiki/w/Breaking#Blocks_by_hardness
	// resistances: https://minecraft.wiki/w/Explosion#Blast_resistance
	// for example soul glass at 0.3, 6 has the breaking time of glass but the
	// blast resistance of cobblestone
	// also, don't think blocks and their corresponding items *have* to have the
	// same id but it is good practice
	public static void register() {
		blocks.put("soul_glass", Registry.register(Registries.BLOCK,
				new Identifier(MOD_ID, "soul_glass"),
				new Soul_Glass(FabricBlockSettings.copy(Blocks.GLASS).strength(0.3f, 6f).nonOpaque())));
	}

	public static ArrayList<Block> getBlocks() {
		ArrayList<Block> blockList = new ArrayList<>();
		blocks.forEach((key, value) -> blockList.add(value));
		return blockList;
	}

	public static Block getBlock(String block_id) {
		if (blocks.containsKey(block_id))
			return blocks.get(block_id);
		return null;
	}
}
