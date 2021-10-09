package com.fengmaster.mod.foodeconmic.item;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

import static com.fengmaster.mod.foodeconmic.Foodeconmic.MOD_ID;

public class FoodGodStatueItem extends ItemBlock {
    public FoodGodStatueItem(Block block) {
        super(block);
        MyRegistry.items.add(this);
        this.setRegistryName(MOD_ID, "food_god_statue_item");
        this.setCreativeTab(CreativeTabs.FOOD);
    }
}
