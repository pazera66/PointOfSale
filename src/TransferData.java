import java.math.BigDecimal;


public class TransferData {
    private String productName;
    private BigDecimal productPrice;

    //TODO singleton????

    public TransferData(){

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
