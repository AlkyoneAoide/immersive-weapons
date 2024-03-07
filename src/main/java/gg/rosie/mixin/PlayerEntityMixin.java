package gg.rosie.mixin;

import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	@ModifyVariable(method = "attack(Lnet/minecraft/entity/Entity;)V", at = @At("STORE"), ordinal = 2)
	public boolean attack(boolean value) {
		System.out.println("Crit prevented(?)");
		return false;
	}
}
