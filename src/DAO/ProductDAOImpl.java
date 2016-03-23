package DAO;

import entity.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductDAOImpl implements ProductDAO {

    private final static Map<String, Product> productMap = new HashMap<>();

    static {
        Product product = new Product("12345", "Mleko", BigDecimal.valueOf(2.39));
        productMap.put(product.getBarcode(), product);

        product = new Product("123456", "Chleb", BigDecimal.valueOf(4.85));
        productMap.put(product.getBarcode(), product);

        product = new Product("1234567", "Jajka", BigDecimal.valueOf(10.11));
        productMap.put(product.getBarcode(), product);

        product = new Product("12345678", "Sok", BigDecimal.valueOf(6.50));
        productMap.put(product.getBarcode(), product);

        product = new Product("123456789", "Maslo", BigDecimal.valueOf(4.99));
        productMap.put(product.getBarcode(), product);
    }

    @Override
    public Product findByBarcode(String barcode) {
        return productMap.get(barcode);
    }
}
