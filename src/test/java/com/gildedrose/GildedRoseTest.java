package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseTest {
    @Test
    public void testInit() {

        GRItem[] items = new GRItem[]{
                new NormalItem("lkjhgfdeswa", 5, 7),
        };

        GildedRose app = new GildedRose(items);

        assertThat(app.items.length, is(1));
        assertThat(app.items, is(items));
    }

    @Test
    public void testQualityDecrement() {
    // when
    // !Ages Brie && !Backstage && Quality > 0 && !Sulfuras

        GRItem[] items = new GRItem[] {
                new NormalItem("Elixir of the Mongoose", 5, 7)
        };

        GildedRose app = new GildedRose(items);

        GRItem[] appItems = app.items;

        app.updateQuality();
        NormalItem firstItem = (NormalItem) appItems[0];

        assertThat(firstItem.quality, is(6));
    }
}