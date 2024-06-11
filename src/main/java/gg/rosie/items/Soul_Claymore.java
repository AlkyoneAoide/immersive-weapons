package gg.rosie.items;

import gg.rosie.DamageHelper;
import net.minecraft.block.BlockState;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
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
        playBreakSound(stack.getDamage() / stack.getMaxDamage(), attacker);
        return result;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        boolean result = super.postMine(stack, world, state, pos, miner);
        playBreakSound(stack.getDamage() / stack.getMaxDamage(), miner);
        return result;
    }

    private void playBreakSound(int damagePercent, LivingEntity player) {
        if(damagePercent == 25 || damagePercent == 50 || damagePercent == 75)
            if(!player.getWorld().isClient)
                player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS, 1, 1);
    }
}
