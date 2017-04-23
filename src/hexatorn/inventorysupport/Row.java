package hexatorn.inventorysupport;

/**
 * Created by Hexatorn on 2017-04-23.
 */
class Row {
    private static int idCounter=1;
    public String kodSKU = "";
    public int id;
    public int qtyLoN;
    public int qtyWM;
    Row(String kodSKU,int qtyLoN,int qtyWM){
        id=idCounter++;
        setKodSKU(kodSKU);
        setQtyLoN(qtyLoN);
        setQtyWM(qtyWM);
    }

    public void setKodSKU(String kodSKU) {
        this.kodSKU = kodSKU;
    }

    public void setQtyLoN(int qtyLoN) {
        this.qtyLoN = qtyLoN;
    }

    public void setQtyWM(int qtyWM) {
        this.qtyWM = qtyWM;
    }
}
