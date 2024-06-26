package gg.rosie.mixin.beacon;

// YOINKED FROM BeamBeGone by RamGemes, THANK YOU

import com.llamalad7.mixinextras.sugar.Local;
import gg.rosie.registry.ImmersiveWeaponsBlocks;
import net.minecraft.block.entity.BeaconBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BeaconBlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import gg.rosie.interfaces.IBeaconBlockEntity;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(BeaconBlockEntityRenderer.class)
public class BeaconBlockEntityRenderMixin {
    @ModifyConstant(method = "render(Lnet/minecraft/block/entity/BeaconBlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V", constant = @Constant(intValue = 1024))
    private int removeDefaultMaxHeightBeamIfTintedGlassBlocked(int constant, @Local(argsOnly = true) BeaconBlockEntity beacon, @Local BeaconBlockEntity.BeamSegment segment) {
        if(beacon.getWorld() == null) return constant;
        if(beacon.getWorld().getBlockState(beacon.getPos().withY(((IBeaconBlockEntity)beacon).beamBeGone$getBlockedY())).getBlock().equals(ImmersiveWeaponsBlocks.getBlock("soul_glass"))) return segment.getHeight();
        return constant;
    }

    @Inject(method = "render(Lnet/minecraft/block/entity/BeaconBlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V", at = @At("HEAD"), cancellable = true)
    private void cancelIfTintedGlassDirectlyAboveBeacon(BeaconBlockEntity beaconBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j, CallbackInfo ci) {
        if(beaconBlockEntity.getWorld() == null) return;
        if(beaconBlockEntity.getWorld().getBlockState(beaconBlockEntity.getPos().up()).getBlock().equals(ImmersiveWeaponsBlocks.getBlock("soul_glass"))) ci.cancel();
    }
}