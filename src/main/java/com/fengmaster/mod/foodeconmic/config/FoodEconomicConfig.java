package com.fengmaster.mod.foodeconmic.config;

import com.fengmaster.mod.foodeconmic.Foodeconmic;
import net.minecraftforge.common.config.Config;

@Config(modid = Foodeconmic.MOD_ID,name = Foodeconmic.MOD_ID+"_config",type = Config.Type.INSTANCE)
public  class FoodEconomicConfig {

    @Config.Comment({"食物币汇率,即用食物能换取食物币的多少,采用EvalEx的表达式 相关链接:https://github.com/uklimaschewski/EvalEx",
                    "支持的变量有:",
                    "hunger_count:恢复饥饿值",
                    "saturation_count:恢复饱腹度",
                    "cur_hunger:当前饥饿值",
                    "cur_saturation:当前饱腹度"})
    public static String foodRate="hunger_count + saturation_count";


}
