package dgrfps.pfmc.mixin;

import dgrfps.pfmc.items.ItemRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnimalEntity.class)
public abstract class PoopMixin extends PassiveEntity {

    int poop_ticks = random.nextInt(20 * 60 * 5) + (20 * 60);

    protected PoopMixin(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "tickMovement()V", at = @At("TAIL"))
    void shitty(CallbackInfo ci)
    {
        this.poop_ticks--;
        if(this.poop_ticks <= 0)
        {
            this.poop_ticks = random.nextInt(20 * 60 * 5) + (20 * 60);
            this.dropStack(ItemRegistry.POOP.getDefaultStack());
            this.getWorld().addParticle(ParticleTypes.CRIT, this.getPos().x, this.getPos().y, this.getPos().z, 0, -.1, 0);
        }
    }


}