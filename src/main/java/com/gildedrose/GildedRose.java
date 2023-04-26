package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
            decreaseSellIn(item);
            if (item.sellIn < 0) {
                updateExpiredItem(item);
            }
        }
    }

    private void updateItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                increaseQuality(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                increaseQuality(item);
                if (item.sellIn < 11) {
                    increaseQuality(item);
                }
                if (item.sellIn < 6) {
                    increaseQuality(item);
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                decreaseQuality(item);
                if (item.sellIn < 0) {
                    decreaseQuality(item);
                }
                break;
        }
    }

    private void updateExpiredItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else {
            decreaseQuality(item);
        }
    }

    private void decreaseSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality--;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}