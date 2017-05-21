package hexatorn.inventorysupport.Tests;

import hexatorn.inventorysupport.Value;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Hexatorn on 2017-05-21.
 */
public class ValueTest {
    private Value value;

    @Before
    public void setUp(){
        value = null;
    }

    @Test
    public void getNotNumberValue(){
        value = new Value();
        assertEquals("-",value.getValue());
    }

    @Test
    public void getNumberValue(){
        value = new Value(1);
        assertEquals("1",value.getValue());
    }

}