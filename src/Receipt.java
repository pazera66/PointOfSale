import entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


class Receipt {

    private BigDecimal totalSum = new BigDecimal("0");
    private List<Product> productsList = new ArrayList<>();

     void addItemToReceipt(Product product){
        productsList.add(product);
    }

     BigDecimal calculateTotalSum(){
        for (Product product : productsList){
            totalSum = totalSum.add(product.getProductPrice());
        }
        return totalSum;
    }

    List<Product> getProductsList(){
        return productsList;
    }

    BigDecimal getTotalSum(){
        return totalSum;
    }

}
