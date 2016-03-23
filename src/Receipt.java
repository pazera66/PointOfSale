import entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Receipt {

    private BigDecimal totalSum = new BigDecimal("0");
    private List<Product> productsList = new ArrayList<>();

    public void addItemToReceipt(Product product){
        productsList.add(product);
    }

    public BigDecimal calculateTotalSum(){
        for (Product product : productsList){
            totalSum = totalSum.add(product.getProductPrice());
        }
        return totalSum;
    }

    public List<Product> getProductsList(){
        return productsList;
    }

    public BigDecimal getTotalSum(){
        return totalSum;
    }

}
