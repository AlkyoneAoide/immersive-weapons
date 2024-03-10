package gg.rosie.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import net.minecraft.entity.damage.DamageSource;

@Mixin(Entity.class)
public abstract class EntityMixin implements gg.rosie.interfaces.IEntityMixin {

    @Inject(method = "isInvulnerableTo", at = @At("HEAD"), cancellable = true)
    private void isInvulnerableTo(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        System.out.println("lightning!!!!!");
        if(source.getAttacker() instanceof LightningEntity)
            cir.setReturnValue(true);
    }
}
