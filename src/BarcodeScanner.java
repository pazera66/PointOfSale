
 class BarcodeScanner {

    private int[] exampleBarcodeList =  {1,4,3,2,-1};

     BarcodeScanner(){

    }

     int scanBarcode(int exampleNumberOfBarcodeToBeScanned){
        return exampleBarcodeList[exampleNumberOfBarcodeToBeScanned];
    }
}
