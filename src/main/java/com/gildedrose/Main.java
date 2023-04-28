package com.gildedrose;

public class Main {
    public static void main(String[] args) {
        System.out.println("Example of running Gilded Rose");

        GRItem[] items = new GRItem[] {
                new Brie("Aged Brie", 2, 0),
                new NormalItem("Elixir of the Mongoose", 5, 7),
                new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80),
                new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49) };

        GildedRose app = new GildedRose(items);

        System.out.println("Day 1 ======================");
        for (GRItem item : items) {
            System.out.println("item = " + item);
        }

        System.out.println("Day 2 ======================");
        app.updateQuality();
        for (GRItem item : items) {
            System.out.println("item = " + item);
        }

        System.out.println("Day 3 ======================");
        app.updateQuality();
        for (GRItem item : items) {
            System.out.println("item = " + item);
        }
    }
}
