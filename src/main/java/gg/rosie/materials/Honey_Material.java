package gg.rosie.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class Honey_Material implements ToolMaterial {
    @Override
    public int getDurability() {
        return 75;
    }

    @Override
    public float getMiningSpeedMultiplier() { return 3.0f; }

    @Override
    public float getAttackDamage() {
        return 5.0f;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.HONEYCOMB);
    }

    public static final Honey_Material INSTANCE = new Honey_Material();
}
