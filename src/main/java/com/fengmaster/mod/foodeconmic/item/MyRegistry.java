package com.fengmaster.mod.foodeconmic.item;

import com.fengmaster.mod.foodeconmic.Foodeconmic;
import com.fengmaster.mod.foodeconmic.block.FoodGodStatueBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class MyRegistry {
    public static final List<Item> items = new ArrayList<Item>();
    public static final List<Block> blocks=new ArrayList<>();

    public static final FoodCoin foodCoin=new FoodCoin();
    public static final FoodGodStatueBlock foodGodStatueBlock=new FoodGodStatueBlock();

    public static final FoodGodStatueItem foodGodStatueItem=new FoodGodStatueItem(foodGodStatueBlock);




    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        Foodeconmic.logger.info("注册物品 数量:"+items.size());
        event.getRegistry().registerAll(items.toArray(new Item[0]));
    }


    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        Foodeconmic.logger.info("注册方块 数量:"+blocks.size());
        event.getRegistry().registerAll(blocks.toArray(new Block[0]));
    }


    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
        for(Item item : MyRegistry.items){
            if(item instanceof IHasModel){
                ((IHasModel)item).registerModel();
            }
        }
    }
}
