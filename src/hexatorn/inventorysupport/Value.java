package hexatorn.inventorysupport;

/**
 * Created by Hexatorn on 2017-05-21.
 */
public class Value {
    String textValue = "-";
    int numberValue = 0;
    boolean unknownValue = true;

    public Value(){
    }
    public Value(int value){
        numberValue = value;
        unknownValue = false;
    }
    public String getValue(){
        if(unknownValue)
            return textValue;
        return Integer.toString(numberValue) ;
    }
}
