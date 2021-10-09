package com.fengmaster.mod.foodeconmic.block;

import cn.hutool.core.util.ObjectUtil;
import com.fengmaster.mod.foodeconmic.Foodeconmic;
import com.fengmaster.mod.foodeconmic.config.FoodEconomicConfig;
import com.fengmaster.mod.foodeconmic.item.MyRegistry;
import com.udojava.evalex.Expression;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.property.Properties;

/**
 * 食物女神像,拿着食物对其右键可以换取食物币,食物币多少取决于食物的饱食度
 */
public class FoodGodStatueBlock extends Block {

    public FoodGodStatueBlock() {
        super(Material.IRON);
        this.setRegistryName("food_god_statue_block");
        this.setLightLevel(15);
        this.setHardness(2);
        this.setResistance(20);
        MyRegistry.blocks.add(this);
        this.setCreativeTab(CreativeTabs.FOOD);

    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
         super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
        Foodeconmic.logger.info("方块被右击");
        Foodeconmic.logger.info(playerIn.getHeldItemMainhand());

        if (!ObjectUtil.isEmpty(playerIn.getHeldItemMainhand())&&
                !ObjectUtil.isEmpty(playerIn.getHeldItemMainhand().getItem())&&
                playerIn.getHeldItemMainhand().getItem() instanceof ItemFood){
            //食物右键雕像,将食物转换成为食物币
            ItemFood food = (ItemFood) playerIn.getHeldItemMainhand().getItem();
            int healAmount = food.getHealAmount(null);
            float saturation = food.getSaturationModifier(null);
            Expression expression = new Expression(FoodEconomicConfig.foodRate).with("hunger_count", healAmount + "")
                    .with("saturation_count", saturation + "")
                    .with("cur_hunger", playerIn.getFoodStats().getFoodLevel() + "")
                    .with("cur_saturation", playerIn.getFoodStats().getSaturationLevel() + "");

            playerIn.setHeldItem(hand,new ItemStack(MyRegistry.foodCoin,expression.eval().intValue() * playerIn.getHeldItemMainhand().getCount()));
            return true;
        }

        return false;

    }


}
