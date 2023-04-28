package com.gildedrose;

public class Brie extends Item implements GRItem {

    public Brie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (super.quality < 50) {
            super.quality += 1;
        }
        super.sellIn -= 1;
        if (super.sellIn < 0) {
            if (super.quality < 50) {
                super.quality += 1;
            }
        }
    }
}

