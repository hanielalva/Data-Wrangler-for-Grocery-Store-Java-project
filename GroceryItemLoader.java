import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is used to process the grocery item information from the XML file into a usable format for
 * the project group
 *
 * @author Haniel Alva
 */
public class GroceryItemLoader implements IGroceryItemLoader{

    //Initializing the array list to be returned
    private final ArrayList<IGroceryItem> groceryList;

    public GroceryItemLoader() {
        this.groceryList = new ArrayList<IGroceryItem>();
    }

    /**
     * This method loads the list of grocery items from an XML file.
     *
     * @param filepathToXML path to the XML file relative to the executable
     * @return an ArrayList of grocery item objects
     * @throws FileNotFoundException if the XML file is not found
     */
    @Override
    public ArrayList<IGroceryItem> loadGroceryItems(String filepathToXML) throws FileNotFoundException {

            Scanner scnr = new Scanner(new File(filepathToXML));

            //loop that iterates through file
            while (scnr.hasNext()) {

                if (scnr.nextLine().strip().equals("<item>")) {

                    String name = scnr.nextLine().strip()
                            .replaceAll("<name>", "").replaceAll("</name>", "");
                    String category = scnr.nextLine().strip().replaceAll("<category>", "")
                            .replaceAll("</category>", "");
                    double price = Double.parseDouble(scnr.nextLine().strip()
                            .replaceAll("<price>", "").replaceAll("</price>", ""));
                    int amountAvailable = Integer.parseInt(scnr.nextLine().strip()
                            .replaceAll("<amt>", "").replaceAll("</amt>", ""));

                    GroceryItem groceryItem = new GroceryItem(name, category, price, amountAvailable);
                    this.groceryList.add(groceryItem);
                }
            }
        return this.groceryList;
    }


}
