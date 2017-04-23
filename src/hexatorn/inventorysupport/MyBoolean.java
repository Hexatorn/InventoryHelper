package hexatorn.inventorysupport;

/**
 * Created by Hexatorn on 2017-04-23.
 */
public class MyBoolean {
    private boolean b;
    MyBoolean(){
        setB(true);
    }

    public void setB(boolean b) {
        this.b = b;
    }
    public boolean getB(){
        return b;
    }

    @Override
    public String toString() {
        System.out.println(b);
        return "";
    }
}
