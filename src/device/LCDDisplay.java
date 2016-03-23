package device;

import entity.Product;

import java.util.List;

public class LCDDisplay implements OutputDevice {

    private static final String CURRENCY = "zl";

    @Override
    public void print(List<Product> products) {
        System.out.print(" \n");
        for (Product product : products)
            System.out.println(product.getProductName() + "     " + product.getProductPrice().toString() + CURRENCY);
    }

    @Override
    public void print(String textToBePrinted) {
        System.out.print(textToBePrinted);
    }
}
