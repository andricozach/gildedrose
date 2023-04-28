package com.gildedrose;

import com.oneeyedmen.okeydoke.junit.ApprovalsRule;
import org.junit.Rule;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ApprovalTest {
    @Rule
    public final ApprovalsRule approver = ApprovalsRule.fileSystemRule("src/test/resources/approval");

    @Test
    public void preservesBehaviour() {
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);

        GRItem[] items = new GRItem[] {
                new Brie("Aged Brie", 2, 0),
                new NormalItem("Elixir of the Mongoose", 5, 7),
                new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80),
                new BackstagePass("Backstage passes to a TAFKAL80ETC concert", 5, 49) };

        GildedRose app = new GildedRose(items);

        out.println("Day 1 ======================");
        for (GRItem item : items) {
            out.println("item = " + item);
        }

        out.println("Day 2 ======================");
        app.updateQuality();
        for (GRItem item : items) {
            out.println("item = " + item);
        }

        out.println("Day 3 ======================");
        app.updateQuality();
        for (GRItem item : items) {
            out.println("item = " + item);
        }

        approver.assertApproved(writer.toString());
    }
}
