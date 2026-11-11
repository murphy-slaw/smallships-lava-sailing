package net.funkpla.smallships_lava_sailing.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.talhanation.smallships.world.entity.ship.ModBoatTypes;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Boat.class)
public class BoatMixin {

  /** Treat lava as water for nether wood ships. */
  @WrapOperation(
      method = "checkInWater",
      at =
          @At(
              value = "INVOKE",
              target =
                  "Lnet/minecraft/world/entity/vehicle/Boat;canBoatInFluid(Lnet/minecraft/world/level/material/FluidState;)Z"))
  private boolean isWaterOrLava(Boat instance, FluidState fluidState, Operation<Boolean> original) {
    Boat boat = (Boat) (Object) this;
    if (ModBoatTypes.isNetherWood(boat.getVariant())) {
      return instance.canBoatInFluid(fluidState) || fluidState.is(FluidTags.LAVA);
    }
    return original.call(instance, fluidState);
  }
}
