package gg.rosie;

import gg.rosie.blocks.Soul_Vitric;
import gg.rosie.items.Soul_Claymore;
import gg.rosie.materials.Copper_Material;
import gg.rosie.items.Copper_Battleaxe;
import gg.rosie.materials.Nether_Star_Material;
import gg.rosie.items.Leaching_Scythe;

import gg.rosie.materials.Soul_Glass_Material;
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
	public static final String NAMESPACE = "immersive-weapons";

	// Creating new items
	// Registering the items when the game is loaded
	public static final ToolItem COPPER_BATTLEAXE = Registry.register(Registries.ITEM,
			new Identifier(NAMESPACE, "copper_battleaxe"),
			new Copper_Battleaxe(Copper_Material.INSTANCE, 2, -3.2f, new FabricItemSettings().maxCount(1)));

	public static final ToolItem LEACHING_SCYTHE = Registry.register(Registries.ITEM,
			new Identifier(NAMESPACE, "leaching_scythe"),
			new Leaching_Scythe(Nether_Star_Material.INSTANCE, 0, -1.0f, new FabricItemSettings().maxCount(1)));

	public static final ToolItem SOUL_CLAYMORE = Registry.register(Registries.ITEM,
			new Identifier(NAMESPACE, "soul_claymore"),
			new Soul_Claymore(Soul_Glass_Material.INSTANCE, 0, -1.0f, new FabricItemSettings().maxCount(1)));

	// Creating and registering new blocks + their corresponding items
	public static final Block SOUL_VITRIC = Registry.register(Registries.BLOCK,
			new Identifier(NAMESPACE, "soul_vitric"),
			new Soul_Vitric(FabricBlockSettings.copyOf(Blocks.GLASS).strength(3.0f).nonOpaque())); // change strength to match glass??? or be similar...

	public static final BlockItem SOUL_VITRIC_ITEM = Registry.register(Registries.ITEM,
			new Identifier(NAMESPACE, "soul_vitric"),
			new BlockItem(SOUL_VITRIC, new FabricItemSettings()));


	// Create immersiveWeapons inventory tab
	private static final ItemGroup WEAPON_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(COPPER_BATTLEAXE))
			.displayName(Text.translatable("itemGroup.immersive-weapons.weapons"))
			.entries((context, entries) -> {
				entries.add(COPPER_BATTLEAXE);
				entries.add(LEACHING_SCYTHE);
				entries.add(SOUL_CLAYMORE);

				entries.add(SOUL_VITRIC_ITEM);
			})
			.build();

	@Override
	public void onInitialize() {
		// Register item group when the game is loaded
		Registry.register(Registries.ITEM_GROUP, new Identifier("immersive-weapons", "weapons"), WEAPON_GROUP);
	}
}
