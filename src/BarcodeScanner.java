import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BarcodeScanner {

    public String scanBarcode() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter barcode\n");

        return br.readLine();
    }

}
