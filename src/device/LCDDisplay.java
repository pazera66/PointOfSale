package device;

import entity.Product;
import java.util.List;

public class LCDDisplay implements OutputDevice {

    @Override
    public void print(List<Product> products) {
        System.out.print(" \n");
        for (Product product : products)
            System.out.print(product.getProductName() + "     " + product.getProductPrice().toString() + "zl\n");
    }

    @Override
    public void print(String textToBePrinted) {
        System.out.print(textToBePrinted);
    }
}
