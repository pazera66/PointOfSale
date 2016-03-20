import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by pazer on 20.03.2016.
 */
public class Database {

    private static Database instance = null;


    //TODO czy da sie zrobic liste czy cos zeby float byl prymitywem a nie obiektem
    private Map<Integer, String> productNameList;
    private Map<String, BigDecimal> productPriceList;

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
        if(productNameList.get(name)!=null){
            return true;
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
