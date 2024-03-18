package gg.rosie.items;

import java.util.Random;

import gg.rosie.DamageHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class Copper_Battleaxe extends AxeItem {
	private static final Random RANDOM = new Random();

	private boolean isSelected = false;

	public Copper_Battleaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(material, attackDamage, attackSpeed, settings);
		DamageHelper.ItemCrits.add("immersive-weapons:copper_battleaxe", (source, amount) -> {
			if (source.getAttacker() == null || source.getSource() == null) {
				return;
			}

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

	private void updateSelectionStatus(boolean flag, int holdingEntityId) {
		if (isSelected == flag) {
			return;
		}

		if (flag) {
			DamageHelper.Immunity.add(holdingEntityId, "minecraft:lightning_bolt");
		} else {
			DamageHelper.Immunity.remove(holdingEntityId, "minecraft:lightning_bolt");
		}

		isSelected = flag;
	}

	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
		if (!world.isClient) {
			if (entity instanceof PlayerEntity player) {

                for (ItemStack handItem : player.getHandItems()) {
					if (handItem.equals(stack)) {
						updateSelectionStatus(true, entity.getId());
						return;
					}
				}

				updateSelectionStatus(false, entity.getId());
			}
		}
	}
}
