package com.hambrospecial;

public class Book extends LibraryItem<Integer> {
    private final String isbn;
    private final String genre;

    public Book(String title, String author, String itemID, Integer pageCount, String isbn, String genre) {
        super(title, author, itemID, pageCount);
        this.isbn = isbn;
        this.genre = genre;
    }

    @Override
    public String getItemType() { return "Book"; }

    @Override
    public String getSpecificDetails() {
        return String.format("Pages: %d, ISBN: %s, Genre: %s",
                getAdditionalInfo(), isbn, genre);
    }
}