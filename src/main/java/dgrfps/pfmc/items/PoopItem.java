package dgrfps.pfmc.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class PoopItem extends Item {
    public PoopItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (this.isFood()) {
            user.playSound(SoundEvents.ENTITY_VILLAGER_NO, 1f, 1f);

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 3 * 20));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 3 * 20, 2));

            return user.eatFood(world, stack);
        }
        return stack;
    }
}
