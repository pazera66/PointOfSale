import java.math.BigDecimal;

/**
 * Created by pazer on 20.03.2016.
 */
public class Processor {

    private Database database;
    private String[] sampleItemNameList = {"Mleko", "Chleb", "Jajka", "Sok", "Maslo"};
    private BigDecimal[] sampleItemPriceList = {new BigDecimal("2.39"), new BigDecimal("4.85"), new BigDecimal("10.11"),
            new BigDecimal("6,50"), new BigDecimal("4,99")};


    public Processor(){
        createSampleDatabase();
    }

    private void createSampleDatabase() {
        database = new Database();
        for(int i = 0; i < sampleItemNameList.length; i++){
            database.addItemToDatabase(i, sampleItemNameList[i], sampleItemPriceList[i]);
        }



    }


}
