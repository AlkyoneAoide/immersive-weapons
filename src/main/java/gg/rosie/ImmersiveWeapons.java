package gg.rosie;

import gg.rosie.blocks.Soul_Vitric;
import gg.rosie.items.Soul_Claymore;
import gg.rosie.materials.Copper_Material;
import gg.rosie.items.Copper_Battleaxe;
import gg.rosie.materials.Nether_Star_Material;
import gg.rosie.items.Leaching_Scythe;

import gg.rosie.materials.Soul_Glass_Material;
import gg.rosie.registry.ImmersiveWeaponsBlocks;
import gg.rosie.registry.ImmersiveWeaponsItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ImmersiveWeapons implements ModInitializer {
	public static final String MOD_ID = "immersive-weapons";

	// Create immersiveWeapons inventory tab
	private static final ItemGroup WEAPON_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ImmersiveWeaponsItems.getItem("copper_battleaxe")))
			.displayName(Text.translatable("itemGroup.immersive-weapons.weapons"))
			.entries((context, entries) -> {
				ImmersiveWeaponsItems.getItems().forEach(item -> entries.add(item));
			})
			.build();

	@Override
	public void onInitialize() {
		// Register item group when the game is loaded
		Registry.register(Registries.ITEM_GROUP, new Identifier("immersive-weapons", "weapons"), WEAPON_GROUP);
	}
}
