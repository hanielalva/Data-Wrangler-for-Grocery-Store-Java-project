import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Instances of this interface can be used to load grocery items from an XML file.
 *
 * @author Haniel Alva & Sreyas Srivastava
 */
public interface IGroceryItemLoader {
   
    /**
     * This method loads the list of grocery items from an XML file.
     * @param filepathToXML path to the XML file relative to the executable
     * @return an ArrayList of grocery item objects
     * @throws FileNotFoundException if the XML file is not found
     */
    ArrayList<IGroceryItem> loadGroceryItems(String filepathToXML) throws FileNotFoundException;
    
}