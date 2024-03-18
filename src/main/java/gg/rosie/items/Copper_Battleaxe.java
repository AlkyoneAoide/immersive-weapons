package gg.rosie.items;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

import gg.rosie.CustomItemCrits;

public class Copper_Battleaxe extends AxeItem {
	private static final Random RANDOM = new Random();

	private boolean isSelected = false;

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

	private void updateSelectionStatus(boolean flag) {
		if (isSelected == flag) {
			return;
		}

		if (flag) {
			// DamageHelper.Immunity.add(id, minecraft:lightning_bolt);
		} else {
			// DamageHelper.Immunity.remove(id, minecraft:lightning_bolt);
		}

		isSelected = flag;
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient) {
			if (entity instanceof PlayerEntity) {
				PlayerEntity player = (PlayerEntity) entity;

				for (ItemStack handItem : player.getHandItems()) {
					if (handItem.equals(stack)) {
						updateSelectionStatus(true);
						return;
					}
				}

				updateSelectionStatus(false);
			}
		}
	}
}
