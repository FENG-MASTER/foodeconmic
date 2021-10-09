package com.fengmaster.mod.foodeconmic.item;

import com.fengmaster.mod.foodeconmic.Foodeconmic;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import static com.fengmaster.mod.foodeconmic.Foodeconmic.MOD_ID;


/**
 * 食物交易币,
 */
public class FoodCoin extends Item implements IHasModel {


    public FoodCoin() {
        super();
        MyRegistry.items.add(this);
        this.setRegistryName(MOD_ID, "food_coin");
        this.setCreativeTab(CreativeTabs.FOOD);
//        this.setUnlocalizedName("food_coin");

    }

    @Override
    public void registerModel() {
        Foodeconmic.INSTANCE.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
