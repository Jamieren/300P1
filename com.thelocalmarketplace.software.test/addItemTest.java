//Author: Zhenhui Ren(UCID:30139966)
//Date: Nov 4th,2023
//This class is testing when adding item via barcode scanner

import org.junit.Before;
import org.junit.Test;

import com.jjjwelectronics.Numeral;
import com.jjjwelectronics.scale.ElectronicScale;
import com.jjjwelectronics.scanner.Barcode;
import com.thelocalmarketplace.hardware.BarcodedProduct;
import com.thelocalmarketplace.hardware.external.ProductDatabases;
import com.thelocalmarketplace.software.addItem;

import org.junit.Assert;

public class addItemTest {

    private addItem itemAdder;
    private ElectronicScale electronicScale;
    private Barcode existingBarcode;
    private Barcode nonExistingBarcode;
    private BarcodedProduct testProduct;

    @Before
    public void setUp() {
        // Initialize your electronic scale here, ensuring that it's in a testable state if possible
        electronicScale = new ElectronicScale();

        // Properly initialize Barcodes here
  //something wrong here
        nonExistingBarcode = new Barcode(new Numeral[] {});

        // Create test products and populate the database
        testProduct = new BarcodedProduct(existingBarcode, "Test Product", 100, 500.0);
        ProductDatabases.BARCODED_PRODUCT_DATABASE.put(existingBarcode, testProduct);
        ProductDatabases.INVENTORY.put(testProduct, 0);

        itemAdder = new addItem(electronicScale);
    }

    @Test
    public void testAddItemWithCorrectWeight() {
        // Simulate the correct weight on the scale
        // This needs to be set in a way that the ElectronicScale class will use it
        itemAdder.addItemViaBarcodeScanner(existingBarcode);
        Assert.assertEquals("Inventory should be incremented", 1, (int) ProductDatabases.INVENTORY.get(testProduct));
    }

    @Test
    public void testAddItemWithWeightDiscrepancy() {
        // Simulate a weight discrepancy on the scale
        // This needs to be set in a way that the ElectronicScale class will use it
        itemAdder.addItemViaBarcodeScanner(existingBarcode);
        Assert.assertEquals("Inventory should not be incremented due to weight discrepancy", 0, (int) ProductDatabases.INVENTORY.get(testProduct));
    }

    
}
