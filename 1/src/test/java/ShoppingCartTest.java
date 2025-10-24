import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ShoppingCartTest {

    private ShoppingCart cart;


    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }


    @Test
    public void testEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), "An empty cart should have a total cost of 0.");
    }


    @Test
    public void testSingleItem() {
        cart.addItem(10.0, 2);
        assertEquals(20.0, cart.getTotalCost(), "The total cost for a single item should be correctly calculated.");
    }


    @Test
    public void testMultipleItems() {
        cart.addItem(15.5, 1);
        cart.addItem(5.0, 5);
        cart.addItem(100.0, 3);
        assertEquals(340.5, cart.getTotalCost(), "The total cost for multiple items should be the sum of each item's total.");
    }


    @Test
    public void testItemWithZeroPrice() {
        cart.addItem(25.0, 2);
        cart.addItem(0.0, 5);
        assertEquals(50.0, cart.getTotalCost(), "Items with a price of zero should not increase the total cost.");
    }


    @Test
    public void testItemWithZeroQuantity() {
        cart.addItem(30.0, 1);
        cart.addItem(50.0, 0);
        assertEquals(30.0, cart.getTotalCost(), "Items with a quantity of zero should not increase the total cost.");
    }


    @Test
    public void testFloatingPointValues() {
        cart.addItem(0.1, 1);
        cart.addItem(0.2, 1);
        assertEquals(0.3, cart.getTotalCost(), 0.0001, "The calculation should handle floating-point numbers accurately.");
    }


    @Test
    public void testNegativePriceThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem(-10.0, 2);
        }, "Adding an item with a negative price should throw an IllegalArgumentException.");
    }


    @Test
    public void testNegativeQuantityThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem(10.0, -2);
        }, "Adding an item with a negative quantity should throw an IllegalArgumentException.");
    }
}
