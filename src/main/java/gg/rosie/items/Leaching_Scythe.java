package gg.rosie.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

import gg.rosie.CustomItemCrits;

public class Leaching_Scythe extends HoeItem {
    public Leaching_Scythe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        //CustomItemCrits.add("immersive-weapons:copper_battleaxe", (source, amount) -> {});
    }
}
