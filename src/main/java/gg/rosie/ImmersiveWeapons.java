package gg.rosie;

import gg.rosie.materials.Copper_Material;
import gg.rosie.items.Copper_Battleaxe;
import gg.rosie.materials.Nether_Star_Material;
import gg.rosie.items.Leaching_Scythe;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ImmersiveWeapons implements ModInitializer {
	// Creating new items
	// Registering the items when the game is loaded
	public static final ToolItem COPPER_BATTLEAXE = Registry.register(Registries.ITEM,
			new Identifier("immersive-weapons", "copper_battleaxe"),
			new Copper_Battleaxe(Copper_Material.INSTANCE, 2, -3.2f, new FabricItemSettings().maxCount(1)));

	public static final ToolItem LEACHING_SCYTHE = Registry.register(Registries.ITEM,
			new Identifier("immersive-weapons", "leaching_scythe"),
			new Leaching_Scythe(Nether_Star_Material.INSTANCE, 0, -1.0f, new FabricItemSettings().maxCount(1)));


	// Create immersiveWeapons inventory tab
	private static final ItemGroup WEAPON_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(COPPER_BATTLEAXE))
			.displayName(Text.translatable("itemGroup.immersive-weapons.weapons"))
			.entries((context, entries) -> {
				entries.add(COPPER_BATTLEAXE);
				entries.add(LEACHING_SCYTHE);
			})
			.build();

	@Override
	public void onInitialize() {
		// Register item group when the game is loaded
		Registry.register(Registries.ITEM_GROUP, new Identifier("immersive-weapons", "weapons"), WEAPON_GROUP);
	}
}
