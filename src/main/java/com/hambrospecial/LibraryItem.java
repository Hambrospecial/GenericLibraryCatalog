package com.hambrospecial;

public abstract class LibraryItem<T> {
    private final String title;
    private final String author;
    private final String itemID;
    private final T additionalInfo;

    public LibraryItem(String title, String author, String itemID, T additionalInfo) {
        this.title = title;
        this.author = author;
        this.itemID = itemID;
        this.additionalInfo = additionalInfo;
    }

    public String getItemID() { return itemID; }
    public T getAdditionalInfo() { return additionalInfo; }

    // Abstract methods that each type must implement
    public abstract String getItemType();
    public abstract String getSpecificDetails();

    @Override
    public String toString() {
        return String.format("Type: %s, ID: %s, Title: %s, Author: %s, %s",
                getItemType(), itemID, title, author, getSpecificDetails());
    }
}
