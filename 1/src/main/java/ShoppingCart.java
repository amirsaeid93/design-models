import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart that holds items and calculates the total cost.
 * The logic is separated from the UI to allow for easy unit testing.
 */
public class ShoppingCart {

    // A private inner class to represent an item with its price and quantity
    private static class Item {
        private final double price;
        private final int quantity;

        public Item(double price, int quantity) {
            if (price < 0 || quantity < 0) {
                throw new IllegalArgumentException("Price and quantity must not be negative.");
            }
            this.price = price;
            this.quantity = quantity;
        }

        public double getItemTotal() {
            return price * quantity;
        }
    }

    private final List<Item> items = new ArrayList<>();

    /**
     * Adds an item to the cart.
     * @param price The price of the item.
     * @param quantity The quantity of the item.
     */
    public void addItem(double price, int quantity) {
        items.add(new Item(price, quantity));
    }

    /**
     * Calculates the total cost of all items in the cart.
     * @return The total cost.
     */
    public double getTotalCost() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getItemTotal();
        }
        return total;
    }
}
