package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    private Map<String, ItemUpdater> updaters = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        updaters.put("Aged Brie", new AgedBrieUpdater());
        updaters.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        updaters.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = updaters.getOrDefault(item.name, new DefaultItemUpdater());
            updater.update(item);
        }
    }
}
