package gg.rosie.registry;

import gg.rosie.items.Copper_Battleaxe;
import gg.rosie.items.Leaching_Scythe;
import gg.rosie.items.Soul_Claymore;
import gg.rosie.materials.Copper_Material;
import gg.rosie.materials.Nether_Star_Material;
import gg.rosie.materials.Soul_Glass_Material;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ImmersiveWeaponsItems {
	private static final String MOD_ID = "immersive-weapons";

	private static LinkedHashMap<String, Item> items = new LinkedHashMap<>();

	public static void register() {
		// Blocks, then items (represents the same order that's in the creative menu tab
		// Block items:
		items.put("soul_vitric", Registry.register(Registries.ITEM,
				new Identifier(MOD_ID, "soul_vitric"),
				new BlockItem(ImmersiveWeaponsBlocks.getBlock("soul_vitric"), new FabricItemSettings())));

		// Items:
		items.put("copper_battleaxe", Registry.register(Registries.ITEM,
				new Identifier(MOD_ID, "copper_battleaxe"),
				new Copper_Battleaxe(Copper_Material.INSTANCE, 2, -3.2f, new FabricItemSettings().maxCount(1))));

		items.put("leaching_scythe", Registry.register(Registries.ITEM,
				new Identifier(MOD_ID, "leaching_scythe"),
				new Leaching_Scythe(Nether_Star_Material.INSTANCE, 0, -1.0f, new FabricItemSettings().maxCount(1))));

		items.put("soul_claymore", Registry.register(Registries.ITEM,
				new Identifier(MOD_ID, "soul_claymore"),
				new Soul_Claymore(Soul_Glass_Material.INSTANCE, 0, -1.0f, new FabricItemSettings().maxCount(1))));
	}

	public static ArrayList<Item> getItems() {
		ArrayList<Item> itemList = new ArrayList<>();
		items.forEach((key, value) -> itemList.add(value));
		return itemList;
	}

	public static Item getItem(String block_id) {
		if (items.containsKey(block_id))
			return items.get(block_id);
		return null;
	}
}
