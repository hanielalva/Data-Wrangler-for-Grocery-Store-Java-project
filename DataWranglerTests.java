import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests whether the functioinality of the various methods and code in GroceryItemLoader.java and GroceryItem.java
 * works as expected
 *
 * @author Haniel Alva
 */
public class DataWranglerTests {

    protected RedBlackTree rbt = null;

    @BeforeEach
    public void createRBT() {
        rbt = new RedBlackTree();
    }

    /**
     * tests if the array list created for the grocery list is of the correct size
     *
     * @throws FileNotFoundException if the XML file is not found
     */
    @Test
    public void test1() throws FileNotFoundException {
        GroceryItemLoader loader = new GroceryItemLoader();
        ArrayList<IGroceryItem> list = new ArrayList<>();
        list = loader.loadGroceryItems("groceryItems.xml");
        assert(list.size() == 20);
    }

    /**
     * tests to see if the string getter methods work as intended
     *
     * @throws FileNotFoundException if the XML file is not found
     */
    @Test
    public void test2() throws FileNotFoundException {
        GroceryItemLoader loader = new GroceryItemLoader();
        List<IGroceryItem> list = new ArrayList<>();
        list = loader.loadGroceryItems("groceryItems.xml");
        assertEquals(list.get(0).getName(), "Spinach");
        assertEquals(list.get(1).getCategory(), "Produce");
    }


    /**
     * tests to see if the double and int getter methods work as intended
     *
     * @throws FileNotFoundException if the XML file is not found
     */
    @Test
    public void test3() throws FileNotFoundException {
        GroceryItemLoader loader = new GroceryItemLoader();
        List<IGroceryItem> list = new ArrayList<>();
        list = loader.loadGroceryItems("groceryItems.xml");
        assertEquals(list.get(2).getPrice(), 1.20);
        assertEquals(list.get(19).getAmountAvailable(), 6);    }

    /**
     * tests to see if FileNotFoundException was thrown when incorrect path was given
     *
     * @throws FileNotFoundException if the XML file is not found
     */
    @Test
    public void test4() throws FileNotFoundException {
        GroceryItemLoader loader = new GroceryItemLoader();
        try{
            loader.loadGroceryItems("Error.xml");
            assert(false);
        }catch(FileNotFoundException f){
            assert(true);
        }catch(Exception e){
            assert(false);
        }

    }

    /**
     * tests if the entire grocery list has been added to the array list as expected
     *
     * @throws FileNotFoundException
     */
    @Test
    public void test5() throws FileNotFoundException {
        GroceryItemLoader loader = new GroceryItemLoader();
        List<IGroceryItem> list = new ArrayList<>();
        list = loader.loadGroceryItems("groceryItems.xml");
        String testStr = "";
        String checkStr = "SpinachProduce3.975OnionsProduce2.995AppleProduce1.24BananasProduce4.992TurkeyDeli5." +
                "491BaconDeli3.724SalamiDeli5.495SausagesDeli3.4910CheetosSnacks4.198DoritosSnacks4.52PringlesSna" +
                "cks2.1910GoldfishSnacks5.456Honey MustardIngredients3.497Chili PowderIngredients3.984CheeseIngred" +
                "ients2.155SaltIngredients1.52GatoradeDrinks1.755Mountain DewDrinks1.253Red BullDrinks2.799Monst" +
                "erDrinks3.156";
        for (int i = 0; i < list.size();i++) {
            testStr += list.get(i).getName();
            testStr += list.get(i).getCategory();
            testStr += list.get(i).getPrice();
            testStr += list.get(i).getAmountAvailable();
        }
        assertEquals(testStr, checkStr);
    }

    /**
     * tests if the array list loaded from the main branche's grocery xml file works correctly and is of the right size
     *
     * @throws FileNotFoundException if the XML file is not found
     */
    @Test
    public void test6Integration() throws FileNotFoundException {
        GroceryItemLoader loader = new GroceryItemLoader();
        List<IGroceryItem> list = new ArrayList<>();
        list = loader.loadGroceryItems("groceryItems.xml");
        assert(list.size() == 20);
    }

    /**
     * tests if all the getter methods for Bacon work with the xml file in the main branch
     *
     * @throws FileNotFoundException if the XML file is not found
     */
    @Test
    public void test7Integration() throws FileNotFoundException {
        GroceryItemLoader loader = new GroceryItemLoader();
        List<IGroceryItem> list = new ArrayList<>();
        list = loader.loadGroceryItems("groceryItems.xml");
        assertEquals(list.get(5).getName(), "Bacon");
        assertEquals(list.get(5).getCategory(), "Deli");
        assertEquals(list.get(5).getPrice(), 3.72);
        assertEquals(list.get(5).getAmountAvailable(), 4);
    }

    /**
     * tests if the AlgorithmEngineer's insert method works as expected
     *
     * @throws FileNotFoundException if the XML file is not found
     */
    @Test
    public void test8CodeReviewOfAlgorithmEngineer() throws FileNotFoundException {
        rbt.insert(new GroceryItem("Meat", "Produce", 5.00, 100));
        rbt.insert(new GroceryItem("Red Bull", "Drinks", 2.30, 2));
        rbt.insert(new GroceryItem("Banana", "Produce", 2.00, 24));
        rbt.insert(new GroceryItem("Apple", "Deli", 1.50, 5));
        rbt.insert(new GroceryItem("Tortillas", "Ingredients", 0.90, 8));
        rbt.insert(new GroceryItem("Goldfish", "Produce", 10.0, 11));
        rbt.insert(new GroceryItem("Chips", "Snacks", 7.80, 19));
        assertEquals(rbt.toLevelOrderString(), "[ Red Bull, Apple, Chips, Tortillas, Banana, Meat, Goldfish ]");
    }

    /**
     * tests if the AlgorithmEngineer's increment and decrement functionality works as expected
     *
     * @throws FileNotFoundException if the XML file is not found
     */
    @Test
    public void test9CodeReviewOfAlgorithmEngineer() throws FileNotFoundException {
        GroceryItem testItem = new GroceryItem("Meat", "Produce", 5.00, 100);
        rbt.insert(testItem);
        assertEquals(testItem.getAmountAvailable(), 100);
        rbt.insert(testItem);
        assertEquals(testItem.getAmountAvailable(), 101);
        rbt.remove(testItem);
        assertEquals(testItem.getAmountAvailable(), 100);
    }

}

