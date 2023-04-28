package com.gildedrose;

public class ConjuredItem extends Item implements GRItem {

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (super.quality > 0) {
            super.quality -= 2;
        }
        super.sellIn -= 1;
        if (super.sellIn < 0) {
            if (super.quality > 0) {
                super.quality -= 1;
            }
        }
    }
}
