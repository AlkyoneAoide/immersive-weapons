package gg.rosie.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

import gg.rosie.CustomItemCrits;

import java.util.Random;

public class Leaching_Scythe extends HoeItem {

    private static final Random RANDOM = new Random();
    public Leaching_Scythe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        CustomItemCrits.add("immersive-weapons:leaching_scythe", (source, amount) -> {
            if (source.getAttacker().getWorld().isNight()) {
                if (RANDOM.nextInt(10) < 6) {
                    LivingEntity user = (LivingEntity) source.getAttacker();

                    user.setHealth((user.getHealth() + amount/4));
                }
            }
        });
    }
}
