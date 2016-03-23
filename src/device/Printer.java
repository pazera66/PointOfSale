package device;

import entity.Product;
import java.util.List;

public class Printer implements OutputDevice {

    @Override
    public void print(List<Product> products) {
        System.out.print("\nReceipt:\n");
        for (Product product : products)
            System.out.print(product.getProductName() + "     " + product.getProductPrice().toString() + "zl\n");
        }


    @Override
    public void print(String textToBePrinted) {
        System.out.print(textToBePrinted);
    }


}
