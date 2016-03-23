package device;

import entity.Product;
import java.util.List;

public interface OutputDevice {
    void print(List<Product> products);
    void print(String textToBePrinted);
}
