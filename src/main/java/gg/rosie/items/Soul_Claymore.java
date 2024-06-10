package gg.rosie.items;

import gg.rosie.DamageHelper;
import net.minecraft.block.BlockState;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class Soul_Claymore extends SwordItem {

    private static final Random RANDOM = new Random();
    public Soul_Claymore(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        //DamageHelper.ItemCrits.add("immersive-weapons:soul_claymore", (source, amount, attacker, target) -> {});
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.postHit(stack, target, attacker);
        playBreakSound(stack.getDamage() / stack.getMaxDamage());
        return result;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        boolean result = super.postMine(stack, world, state, pos, miner);
        playBreakSound(stack.getDamage() / stack.getMaxDamage());
        return result;
    }

    private void playBreakSound(int damagePercent) {
        //sound code here
    }
}
