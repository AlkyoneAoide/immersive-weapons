package gg.rosie.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntityMixin {
	PlayerEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@ModifyVariable(method = "attack", at = @At(value = "STORE", ordinal = 1), ordinal = 2)
	private boolean attack(boolean bl3) {
		bl3 = bl3 && !this.isSprinting();

		// boolean bl = this.isCritical();
		// if (bl) {
		// bl3 = true;
		// }/* else if (bl3) {
		// this.setCritical(true);
		// }*/
		this.setCritical(bl3);

		return bl3;
	}
}
