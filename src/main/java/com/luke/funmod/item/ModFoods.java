package com.luke.funmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    // lambdas are cool and they can fill in for suppliers
    public static final FoodProperties DONUT = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();
    public static final FoodProperties PLUM = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 200), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100), 0.1f).build();
}
