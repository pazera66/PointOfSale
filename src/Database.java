import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class Database {

    private static Database instance = null;


    private Map<Integer, String> productNameList = new HashMap<>();
    private Map<String, BigDecimal> productPriceList = new HashMap<>();

    protected Database(){
    }

    //TODO zapytać koksa o implementacje singletona

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
                    }
        return instance;
    }

    public String addItemToDatabase(int barcode, String name, BigDecimal price){
        if(checkIfItemAlreadyExistsInDB(name)){
            return "This product already exists in the database";
        }

        productNameList.put(barcode, name);
        productPriceList.put(name, price);
        return "Product has been added to database";
    }

    private boolean checkIfItemAlreadyExistsInDB(String name) {
        if(productNameList!=null){
            if(productNameList.get(name)!=null){
                return true;
            }
        }
        return false;
    }

    public TransferData decodeBarcode(int barcode){

        TransferData transferData = new TransferData();
        if(productNameList.get(barcode)==null){

            transferData.setProductName("Product not found");
            return transferData;
        }

        transferData.setProductName(productNameList.get(barcode));
        transferData.setProductPrice(productPriceList.get(productNameList.get(barcode)));
        return transferData;

    }




}
