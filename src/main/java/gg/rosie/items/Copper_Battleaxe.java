package gg.rosie.items;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import java.util.Random;

import gg.rosie.invoker.LivingEntityInvoker;

public class Copper_Battleaxe extends AxeItem {
	private static final Random RANDOM = new Random();

	public Copper_Battleaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(material, attackDamage, attackSpeed, settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		if (((LivingEntityInvoker) target).isCritical()) {
			System.out.println("target crit");
			// if (attacker.getWorld().isRaining()) {
			// if (RANDOM.nextInt(10) < 2) {
			World world = target.getWorld();
			int x = target.getBlockX();
			int y = target.getBlockY();
			int z = target.getBlockZ();
			LightningEntity bolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
			bolt.setPos(x, y, z);
			world.spawnEntity(bolt);
			// }
			// }
		} else {
			System.out.println("target not crit");
		}

		if (((LivingEntityInvoker) attacker).isCritical()) {
			System.out.println("attacker crit");
		} else {
			System.out.println("attacker not crit");
		}

		return super.postHit(stack, target, attacker);
	}
}
