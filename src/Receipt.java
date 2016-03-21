import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Receipt {

    private BigDecimal totalSum = new BigDecimal("0");
    private List<String> productNameList= new ArrayList<>();
    private List<Integer> productQuantityList= new ArrayList<>();
    private List<BigDecimal> productUnitPriceList= new ArrayList<>();
    private List<BigDecimal> productSubtotal= new ArrayList<>();

    public Receipt(){

    }

    public void addItemToReceipt(String productName, int quantity, BigDecimal productUnitPrice){
        productNameList.add(productName);
        productQuantityList.add(quantity);
        productUnitPriceList.add(productUnitPrice);
        productSubtotal.add(productUnitPrice.multiply(BigDecimal.valueOf(quantity)));
        totalSum = totalSum.add(productUnitPrice.multiply(BigDecimal.valueOf(quantity)));

    }

}
