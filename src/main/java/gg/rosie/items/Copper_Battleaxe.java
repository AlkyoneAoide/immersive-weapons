package gg.rosie.items;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

import gg.rosie.CustomItemCrits;

public class Copper_Battleaxe extends AxeItem {
	private static final Random RANDOM = new Random();

	public Copper_Battleaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(material, attackDamage, attackSpeed, settings);
		CustomItemCrits.add("immersive-weapons:copper_battleaxe", (source, amount) -> {
			if (source.getAttacker().getWorld().isRaining()) {
				if (RANDOM.nextInt(10) < 4) {
					Entity target = source.getSource();
					World targetWorld = target.getWorld();

					int x = target.getBlockX();
					int y = target.getBlockY();
					int z = target.getBlockZ();

					LightningEntity bolt = new LightningEntity(EntityType.LIGHTNING_BOLT, targetWorld);
					bolt.setPos(x, y, z);
					targetWorld.spawnEntity(bolt);
				}
			}
		});
	}
}
