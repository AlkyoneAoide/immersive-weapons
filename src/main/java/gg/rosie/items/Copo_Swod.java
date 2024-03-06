package gg.rosie.items;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class Copo_Material implements ToolMaterial {
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

	public static final Copo_Material INSTANCE = new Copo_Material();
}

public class Copo_Swod extends SwordItem {
	public Copo_Swod(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(material, attackDamage, attackSpeed, settings);
	}
}
