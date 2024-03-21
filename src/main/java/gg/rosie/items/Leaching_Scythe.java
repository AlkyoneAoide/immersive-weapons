package gg.rosie.items;

import gg.rosie.DamageHelper;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

import java.util.Random;

public class Leaching_Scythe extends HoeItem {

    private static final Random RANDOM = new Random();
    public Leaching_Scythe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        DamageHelper.ItemCrits.add("immersive-weapons:leaching_scythe", (source, amount, attacker, target) -> {
            if (attacker == null) {
                return;
            }

            if (attacker.getWorld().isNight()) {
                if (RANDOM.nextInt(10) < 6) {
                    LivingEntity attackerAsLivingEntity = (LivingEntity) attacker;
                    attackerAsLivingEntity.setHealth((attackerAsLivingEntity.getHealth() + amount/4));
                }
            }
        });
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.postHit(stack, target, attacker);

        if (attacker.getWorld().isNight() &&
                !target.isAlive() &&
                PlayerEntity.class.isAssignableFrom(target.getClass()) &&
                RANDOM.nextDouble() < attacker.getWorld().getMoonSize()){
            DamageHelper.PlayerHealth.setPlayerHealth(target, DamageHelper.PlayerHealth.getPlayerHealthModifier(target) - 2);
            DamageHelper.PlayerHealth.setPlayerHealth(attacker, DamageHelper.PlayerHealth.getPlayerHealthModifier(attacker) + 2);
        }

        return result;
    }
}
