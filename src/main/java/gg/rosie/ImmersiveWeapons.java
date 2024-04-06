package gg.rosie;

import gg.rosie.registry.ImmersiveWeaponsItems;
import gg.rosie.registry.ImmersiveWeaponsBlocks;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class ImmersiveWeapons implements ModInitializer {
	public static final String MOD_ID = "immersive-weapons";

	// Create immersiveWeapons inventory tab
	private static final ItemGroup WEAPON_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(Objects.requireNonNull(ImmersiveWeaponsItems.getItem("copper_battleaxe"))))
			.displayName(Text.translatable("itemGroup.immersive-weapons.weapons"))
			.entries((context, entries) -> ImmersiveWeaponsItems.getItems().forEach(entries::add))
			.build();

	@Override
	public void onInitialize() {
		// Register blocks and then items (some items depend on blocks)
		ImmersiveWeaponsBlocks.register();
		ImmersiveWeaponsItems.register();

		// Register item group when the game is loaded
		Registry.register(Registries.ITEM_GROUP, new Identifier("immersive-weapons", "weapons"), WEAPON_GROUP);
	}
}
