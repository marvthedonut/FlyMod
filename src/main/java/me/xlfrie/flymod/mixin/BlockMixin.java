package me.xlfrie.flymod.mixin;

import me.xlfrie.flymod.modules.XRay;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Inject(at=@At("HEAD"), method = "shouldRenderFace", cancellable = true)
    private static void shouldRenderFace(BlockState pState, BlockGetter pLevel, BlockPos pOffset, Direction pFace, BlockPos pPos, CallbackInfoReturnable<Boolean> cir){
        if (XRay.xraying && pState.getBlock().getName().getString().toLowerCase().endsWith("ore")) cir.setReturnValue(true);
    }
}
