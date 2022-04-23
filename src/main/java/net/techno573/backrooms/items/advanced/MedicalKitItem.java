package net.techno573.backrooms.items.advanced;


import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MedicalKitItem extends Item {

    public MedicalKitItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(user.canHaveStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH))) {

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH,1,0));
            user.playSound(SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, SoundCategory.PLAYERS,1,1);

            if(hand == Hand.MAIN_HAND) {
                user.getStackInHand(Hand.MAIN_HAND).decrement(1);
            }

            if(hand == Hand.OFF_HAND) {
                user.getStackInHand(Hand.OFF_HAND).decrement(1);
            }
        }

        return super.use(world, user, hand);
    }
}
