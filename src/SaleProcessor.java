import DAO.ProductDAOImpl;
import device.LCDDisplay;
import device.Printer;
import entity.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SaleProcessor {


    private Receipt receipt;
    private BarcodeScanner barcodeScanner;
    private Product decodedProduct;
    private String barcode;
    private LCDDisplay lcdDisplay;
    private Printer printer;

    ProductDAOImpl productDAO = new ProductDAOImpl();

    public SaleProcessor() throws IOException {

        initializeComponents();

        do {
            barcode = barcodeScanner.scanBarcode();
            if(!checkIfProperBarcode(barcode)) {
                continue;
            }

            decodedProduct = decodeBarcode(barcode);

            if(decodedProduct!=null){
                receipt.addItemToReceipt(decodedProduct);
                printProductInfoOnLCD(decodedProduct);
            } else {
                if (decodedProduct==null&&!barcode.equals("exit")) {
                    printErrorProductNotInDatabase();
                }
            }

        } while (!barcode.equals("exit"));

        printReceipt();


    }

    private boolean checkIfProperBarcode(String barcode) {
        if(barcode.equals("")){
            lcdDisplay.print("\nInvalid bar-code\n");
            return false;
        }
        return true;
    }

    private void initializeComponents(){
        createMockBarcodeScanner();
        createReceipt();
        barcode = "";
        lcdDisplay = new LCDDisplay();
        printer = new Printer();
    }

    private void printProductInfoOnLCD(Product decodedProduct) {
        List<Product> productAsList = new ArrayList<>();
        productAsList.add(decodedProduct);
        lcdDisplay.print(productAsList);
    }

    private void printErrorProductNotInDatabase() {
        lcdDisplay.print("\nProduct not found\n");
    }

    private void printReceipt() {
        receipt.calculateTotalSum();
        lcdDisplay.print("\n\nTotal sum: " + receipt.getTotalSum().toString() + "zl\n\n");
        printer.print("\n\nBelow is receipt printed on printer\n\n");
        printer.print(receipt.getProductsList());
        printer.print("\n\nTotal sum: " + receipt.getTotalSum().toString() + "zl\n\n");
    }

    private Product decodeBarcode(String barcode) {
        if(productDAO.findByBarcode(barcode)==null){
            return null;
        }

        return productDAO.findByBarcode(barcode);
    }

    private void createMockBarcodeScanner() {
        barcodeScanner = new BarcodeScanner();
    }

    private void createReceipt() {
        receipt = new Receipt();
    }

}
