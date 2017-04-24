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
    Row(String kodSKU, int qtyListOfNature, int qtyWerhouseMovement){
        id=idCounter++;
        setKodSKU(kodSKU);
        setQtyListOfNature(qtyListOfNature);
        setQtyWerhouseMovement(qtyWerhouseMovement);
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
        System.out.println(qtyWerhouseMovement);
        return qtyWerhouseMovement;
    }

    public int getQtyCurrentStock(){
        return qtyWerhouseMovement + qtyListOfNature;
    }
}
