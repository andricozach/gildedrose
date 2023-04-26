package com.gildedrose;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ItemTest {

    @Test
    public void testToString() {
        String result = new Item("Test Item", 5, 0).toString();

        assertThat(result, is("Test Item, 5, 0"));
    }
}
