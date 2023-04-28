package com.gildedrose;


class GildedRose {
    GRItem[] items;

    public GildedRose(GRItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (GRItem item : items) {
            item.update();
        }
    }
}