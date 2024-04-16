package com.luke.funmod.item;

import com.luke.funmod.funmod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    SAPPHIRE("sapphire", 26, new int[]{5, 7, 5, 4}, 25,
            SoundEvents.ARMOR_EQUIP_IRON, 1f, 0f, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
    EMERALD("emerald", 26, new int[]{5, 7, 5, 4}, 25,
    SoundEvents.ARMOR_EQUIP_IRON, 1f, 0f, () -> Ingredient.of(Items.EMERALD));


    // intellij is cool, you can declare these and then you can click on them
    // and auto fill out the parameters very convenient
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchanmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchanmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchanmentValue = enchanmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    // pType is the armor type (helmet, boots, etc)
    // the ordinal will return the index of that type of armor which is found in BASE_DURABILITY
    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchanmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return funmod.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
