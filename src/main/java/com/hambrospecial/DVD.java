package com.hambrospecial;

import java.util.ArrayList;
import java.util.List;

public class DVD extends LibraryItem<Double> {
    private final String rating;
    private final List<String> languages;
    private final boolean hasSubtitles;

    public DVD(String title, String author, String itemID, Double duration,
               String rating, List<String> languages, boolean hasSubtitles) {
        super(title, author, itemID, duration);
        this.rating = rating;
        this.languages = new ArrayList<>(languages);
        this.hasSubtitles = hasSubtitles;
    }

    @Override
    public String getItemType() { return "DVD"; }

    @Override
    public String getSpecificDetails() {
        return String.format("Duration: %.1f mins, Rating: %s, Languages: %s, Subtitles: %s",
                getAdditionalInfo(), rating, String.join(", ", languages), hasSubtitles ? "Yes" : "No");
    }
}
