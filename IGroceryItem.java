/**
 * This interface defines getter methods for each grocery item's data fields
 * and is implemented by a class that represents a grocery item and its associated
 * data.
 *
 * @author Haniel Alva & Sreyas Srivastava
 */
public interface IGroceryItem {

    /**
     * Returns the name of the grocery item
     * @return name of the grocery item
     */
    String getName();

    /**
     * Returns the category to which the grocery item belongs
     * @return category to which the grocery item belongs
     */
    String getCategory();

    /**
     * Returns the price of the grocery item
     *
     * @return price of the grocery item
     */
    double getPrice();
    
    /**
     * Returns the amount/number of pieces available of the grocery item
     *
     * @return amount/number of pieces available of the grocery item
     */
    int getAmountAvailable();

}