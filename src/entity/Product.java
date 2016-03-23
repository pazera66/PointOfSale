package entity;

import java.math.BigDecimal;

public class Product {

    private String barcode;
    private String productName;
    private BigDecimal productPrice;

    public Product(String barcode, String productName, BigDecimal productPrice){
        this.barcode = barcode;
        this.productName=productName;
        this.productPrice = productPrice;
    }


    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }
}
