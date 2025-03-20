import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingAppTest {

    @Test
    void testGetTotalCost() {
        ShoppingApp app = new ShoppingApp();
        app.addToTotalCost(10);
        app.addToTotalCost(20);
        assertEquals(30, app.getTotalCost());
    }

    @Test
    void testAddToTotalCost() {
        ShoppingApp app = new ShoppingApp();
        app.addToTotalCost(10);
        assertEquals(10, app.getTotalCost());
    }
}