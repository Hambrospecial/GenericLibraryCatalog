package com.hambrospecial;

import java.util.ArrayList;
import java.util.List;

public class Catalog<T extends LibraryItem<?>> {
    private final List<T> items;

    public Catalog() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (findItemById(item.getItemID()) != null) {
            throw new IllegalArgumentException("Item with ID " + item.getItemID() + " already exists");
        }
        items.add(item);
    }

    public boolean removeItem(String itemID) throws IllegalArgumentException {
        T item = findItemById(itemID);
        if (item == null) {
            throw new IllegalArgumentException("Item with ID " + itemID + " not found");
        }
        return items.remove(item);
    }

    public T findItemById(String itemID) {
        return items.stream()
                .filter(item -> item.getItemID().equals(itemID))
                .findFirst()
                .orElse(null);
    }

    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }
}
