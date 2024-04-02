package gg.rosie.items;

import gg.rosie.DamageHelper;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import java.util.Random;

public class Soul_Claymore extends SwordItem {

    private static final Random RANDOM = new Random();
    public Soul_Claymore(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        //DamageHelper.ItemCrits.add("immersive-weapons:soul_claymore", (source, amount, attacker, target) -> {});
    }
}
