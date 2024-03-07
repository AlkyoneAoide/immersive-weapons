package gg.rosie.materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class Copper_Material implements ToolMaterial {
	@Override
	public int getDurability() {
		return 175;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 5.0f;
	}

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
		return Ingredient.ofItems(Items.COPPER_INGOT);
	}

	public static final Copper_Material INSTANCE = new Copper_Material();
}
