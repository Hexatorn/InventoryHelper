package hexatorn.inventorysupport;

/**
 * Created by Hexatorn on 2017-04-23.
 */
    public class Row {
    private static int idCounter=1;
    private String kodSKU = "null";
    private int id;
    private int qtyListOfNature;
    private int qtyWerhouseMovement;
    private int qtyForeignStock=0;
    private int qtyOwnStock=0;
    Row(String kodSKU, int qtyListOfNature, int qtyWerhouseMovement){
        id=idCounter++;
        setKodSKU(kodSKU);
        setQtyListOfNature(qtyListOfNature);
        setQtyWerhouseMovement(qtyWerhouseMovement);
    }

    Row(String kodSKU){
        id=idCounter++;
        setKodSKU(kodSKU);
        setQtyListOfNature(0);
        setQtyWerhouseMovement(0);
        setQtyForeignStock(0);
        setQtyOwnStock(0);
    }



    public int getId() {
        return id;
    }

    public void setKodSKU(String kodSKU) {
        this.kodSKU = kodSKU;
    }

    public String getKodSKU() {
        return kodSKU;
    }

    public void setQtyListOfNature(int qtyListOfNature) {
        this.qtyListOfNature = qtyListOfNature;
    }

    public int getQtyListOfNature() {
        return qtyListOfNature;
    }

    public void setQtyWerhouseMovement(int qtyWerhouseMovement) {
        this.qtyWerhouseMovement = qtyWerhouseMovement;
    }

    public int getQtyWerhouseMovement() {
        return qtyWerhouseMovement;
    }

    public void setQtyForeignStock(int qtyForeignStock) {
        this.qtyForeignStock = qtyForeignStock;
    }

    public int getQtyForeignStock() {
        return qtyForeignStock;
    }
    public void setQtyOwnStock(int qtyOwnStock) {
        this.qtyOwnStock = qtyOwnStock;
    }

    public int getQtyOwnStock() {
        return qtyOwnStock;
    }

    public int getQtyCurrentStock(){
        return qtyWerhouseMovement + qtyListOfNature;
    }

    public int getAllStock(){
        return getQtyForeignStock()+getQtyOwnStock();
    }

    public int getRW(){
        if(getQtyForeignStock()-(getQtyCurrentStock()-getQtyOwnStock())<0)
            return 0;
        else
            return getQtyForeignStock()-(getQtyCurrentStock()-getQtyOwnStock());
    }

    public int getForeignRW(){
        if(getRW()>getQtyForeignStock())
            return getQtyForeignStock();
        else
            return getRW();
    }

    public int getOwnRW(){
        return getRW()-getForeignRW();
    }

    public int getOwnPW(){
        if(getQtyCurrentStock()>getAllStock())
            return getQtyCurrentStock()-getAllStock();
        else
            return 0;
    }

    public int getCurentForeignStock(){
        return getQtyForeignStock()-getForeignRW();
    }

    public int getCurentOwnStock(){
        return getQtyOwnStock()-getOwnRW()+getOwnPW();
    }
}
