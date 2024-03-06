package gg.rosie;

import gg.rosie.materials.Copo_Material;
import gg.rosie.items.Copo_Swod;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImmersiveWeapons implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("immersive-weapons");

	// Creating a new item
	// Registering the item when the game is loaded
	public static final ToolItem COPO_SWOD = Registry.register(Registries.ITEM,
			new Identifier("immersive-weapons", "copo_swod"),
			new Copo_Swod(Copo_Material.INSTANCE, 0, -2.4f, new FabricItemSettings().maxCount(1)));

	// Create immersiveWeapons inventory tab
	private static final ItemGroup WEAPON_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(COPO_SWOD))
			.displayName(Text.translatable("itemGroup.immersive-weapons.weapons"))
			.entries((context, entries) -> {
				entries.add(COPO_SWOD);
			})
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		// Register item group when the game is loaded
		Registry.register(Registries.ITEM_GROUP, new Identifier("immersive-weapons", "weapons"), WEAPON_GROUP);
	}
}
