import java.math.BigDecimal;

/**
 * Created by pazer on 20.03.2016.
 */
public class TransferData {
    private String productName;
    private BigDecimal productPrice;

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
