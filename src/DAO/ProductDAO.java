package DAO;

import entity.Product;

public interface ProductDAO {
    Product findByBarcode(String barcode);
}
