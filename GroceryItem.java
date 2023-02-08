/**
 * Java class for each grocery object in the Grocery Store
 *
 * @author Haniel Alva
 */
public class GroceryItem implements IGroceryItem, Comparable{

    private String name;
    private String category;
    private double price;
    private int amountAvailable;

    public GroceryItem(String name, String category, double price, int amountAvailable){
        this.name = name;
        this.category = category;
        this.amountAvailable = amountAvailable;
        this.price = price;
    }

    public GroceryItem(){
        this.name = "";
        this.category = "";
        this.amountAvailable = 0;
        this.price = 0;
    }

    /**
     * Returns the name of the grocery item
     *
     * @return name of the grocery item
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the category to which the grocery item belongs
     *
     * @return category to which the grocery item belongs
     */
    @Override
    public String getCategory() {
        return this.category;
    }

    /**
     * Returns the price of the grocery item
     *
     * @return price of the grocery item
     */
    @Override
    public double getPrice() {
        return this.price;
    }

    /**
     * Returns the amount/number of pieces available of the grocery item
     *
     * @return amount/number of pieces available of the grocery item
     */
    @Override
    public int getAmountAvailable() {
        return this.amountAvailable;
    }

    /**
     * Compares prices between two grocery items, determining which item costs more or whether they are the same price
     *
     * @return -1 if grocery item input in the parameter is greater, 1 if it is lesser and 0 if they are equal
     */
    @Override
    public int compareTo(Object o) {
        GroceryItem inputItem = (GroceryItem) o;
        if (this.getPrice() < inputItem.getPrice()) {
            return -1;
        } else if (this.getPrice() > inputItem.getPrice()) {
            return 1;
        } else {
            return 0;}
    }

    public void incrementAmount() { this.amountAvailable++; }

    public void decrementAmount() { this.amountAvailable--; }

    @Override
    public String toString() { return name + ": $" + price + " - " + category + " (" + amountAvailable + ")";}

}
