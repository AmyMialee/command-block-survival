package amymialee.commandblocksurvival.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "isCreativeLevelTwoOp", at = @At("HEAD"), cancellable = true)
    private void isCreativeLevelTwoOp(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(this.getPermissionLevel() >= 2);
    }

    /*
    @Inject(method = "isCreativeLevelTwoOp", at = @At("HEAD"), cancellable = true)
    private void isCreativeLevelTwoOp(CallbackInfoReturnable<Boolean> cir) {
        if (CommandBlockSurvival.config.requireCreative && CommandBlockSurvival.config.requireOp) {
            cir.setReturnValue(this.abilities.creativeMode && this.getPermissionLevel() >= 2);
        } else if (CommandBlockSurvival.config.requireCreative) {
            cir.setReturnValue(this.abilities.creativeMode);
        } else if (CommandBlockSurvival.config.requireOp) {
            cir.setReturnValue(this.getPermissionLevel() >= 2);
        } else {
            cir.setReturnValue(true);
        }
    }
     */
}
