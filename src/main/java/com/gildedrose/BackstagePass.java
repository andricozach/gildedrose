package com.gildedrose;

public class BackstagePass extends Item implements GRItem {

    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (super.quality < 50) {
            super.quality += 1;
            if (super.sellIn < 11) {
                if (super.quality < 50) super.quality += 1;
            }
            if (super.sellIn < 6) {
                if (super.quality < 50) {
                    super.quality = super.quality + 1;
                }
            }
        }
        super.sellIn -= 1;
        if (super.sellIn < 0) {
            super.quality = 0;
        }
    }
}
