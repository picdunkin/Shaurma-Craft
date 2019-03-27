package com.lanf0rt.superFoods;

public interface SuperFood  {
    boolean enchantable = true;
    int tier = 1;
    double poisonChance = 0.02 /((tier > 0) ? tier : Double.MIN_VALUE);
}
