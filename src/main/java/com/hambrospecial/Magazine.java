package com.hambrospecial;

public class Magazine extends LibraryItem<String> {
    private final String issueNumber;
    private final String category;
    private final boolean isMonthly;

    public Magazine(String title, String author, String itemID, String publicationDate,
                    String issueNumber, String category, boolean isMonthly) {
        super(title, author, itemID, publicationDate);
        this.issueNumber = issueNumber;
        this.category = category;
        this.isMonthly = isMonthly;
    }

    @Override
    public String getItemType() { return "Magazine"; }

    @Override
    public String getSpecificDetails() {
        return String.format("Publication Date: %s, Issue: %s, Category: %s, %s",
                getAdditionalInfo(), issueNumber, category, isMonthly ? "Monthly" : "Non-monthly");
    }
}
