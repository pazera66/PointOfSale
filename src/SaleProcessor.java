import java.math.BigDecimal;


public class SaleProcessor {

    private Database database;
    private BarcodeScanner barcodeScanner;
    private Receipt receipt;
    private LCDdisplay lcdDisplay = new LCDdisplay();
    private TransferData productData = new TransferData();

    private String[] sampleItemNameList = {"Mleko", "Chleb", "Jajka", "Sok", "Maslo"};
    private BigDecimal[] sampleItemPriceList = {new BigDecimal("2.39"), new BigDecimal("4.85"), new BigDecimal("10.11"),
            new BigDecimal("6.50"), new BigDecimal("4.99")};


    public SaleProcessor(){
        createSampleDatabase();
        createMockBarcodeScanner();
        createReceipt();

        //Proof of concept
        processProduct(0, 1);
        processProduct(1, 8);
        processProduct(2, 10);
        processProduct(3, 2);
        processProduct(4, 1);

        getExitInput();
        showReceiptOnLCD(receipt);
        printReceipt();


    }

    private void getExitInput() {
        //TODO
    }

    private void showReceiptOnLCD(Receipt receipt) {
        lcdDisplay.displayData(receipt);
    }

    private void printReceipt() {
        new Printer(receipt);

    }

    private void processProduct(int scannedProductNumber, int quantity) {
        int barcode = requestBarcode(scannedProductNumber);
        if(barcode<0){
            showWrongBarcode();
            return;
        }

        productData = database.decodeBarcode(barcode);


        if(!checkIfProductExistsInDB(productData)){
            showProductNotInDB();
            return;
        }

        receipt.addItemToReceipt(productData.getProductName(), quantity, productData.getProductPrice());

    }

    private boolean checkIfProductExistsInDB(TransferData productData) {
        if(productData.getProductName().equals("Product not found")){
            return false;
        }

        return true;
    }

    private void showProductNotInDB() {
        //TODO
        lcdDisplay.displayData("Product not found");
    }

    private void showWrongBarcode() {
        //TODO
        lcdDisplay.displayData("Invalid bar-code");
    }

    private void createMockBarcodeScanner() {
        barcodeScanner = new BarcodeScanner();
    }

    private void createReceipt() {
        receipt = new Receipt();
    }

    private int requestBarcode(int exampleBarcodeNumberToBeScanned) {
        return barcodeScanner.scanBarcode(exampleBarcodeNumberToBeScanned);
    }


    private void createSampleDatabase() {
        database = new Database();
        for(int i = 0; i < sampleItemNameList.length; i++){
            database.addItemToDatabase(i, sampleItemNameList[i], sampleItemPriceList[i]);
        }



    }


}
