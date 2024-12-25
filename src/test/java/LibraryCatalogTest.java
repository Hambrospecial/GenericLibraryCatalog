import com.hambrospecial.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryCatalogTest {
    private Catalog<LibraryItem<?>> catalog;
    private Book book;
    private DVD dvd;
    private Magazine magazine;

    @BeforeEach
    void setUp() {
        catalog = new Catalog<>();
        book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "BK-0001",
                180, "978-0743273565", "Fiction");
        dvd = new DVD("Inception", "Christopher Nolan", "VD-0001",
                148.0, "PG-13", Arrays.asList("English", "Spanish"), true);
        magazine = new Magazine("National Geographic", "Various", "MG-0001",
                "2024-01-01", "January 2024", "Science", true);
    }

    @Test
    void testAddItem() {
        catalog.addItem(book);
        assertEquals(book, catalog.findItemById("BK-0001"));

        catalog.addItem(dvd);
        assertEquals(dvd, catalog.findItemById("VD-0001"));

        catalog.addItem(magazine);
        assertEquals(magazine, catalog.findItemById("MG-0001"));
    }

    @Test
    void testRemoveItem() {
        catalog.addItem(book);
        assertTrue(catalog.removeItem("BK-0001"));
        assertNull(catalog.findItemById("BK-0001"));
    }


    @Test
    void testGetAllItems() {
        catalog.addItem(book);
        catalog.addItem(dvd);
        catalog.addItem(magazine);

        List<LibraryItem<?>> items = catalog.getAllItems();
        assertEquals(3, items.size());
        assertTrue(items.contains(book));
        assertTrue(items.contains(dvd));
        assertTrue(items.contains(magazine));
    }

    @Test
    void testEmptyCatalog() {
        assertTrue(catalog.getAllItems().isEmpty());
    }
}
