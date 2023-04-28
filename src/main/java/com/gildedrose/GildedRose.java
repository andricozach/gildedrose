package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {

            boolean isAgedBrie = false, isBackStagePass = false, isSulfuras = false;

            switch (item.name) {
                case "Aged Brie":
                    isAgedBrie = true;
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    isBackStagePass = true;
                    break;
                case "Sulfuras, Hand of Ragnaros":
                    isSulfuras = true;
                    break;
            }

            if (!isAgedBrie && !isBackStagePass) {
                if (item.quality > 0) {
                    if (!isSulfuras) {
                        item.quality -= 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality += 1;

                    if (isBackStagePass) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) item.quality += 1;
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!isSulfuras) {
                item.sellIn -= 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie) {
                    if (!isBackStagePass) {
                        if (item.quality > 0) {
                            if (!isSulfuras) {
                                item.quality -= 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality += 1;
                    }
                }
            }
        }
    }
}