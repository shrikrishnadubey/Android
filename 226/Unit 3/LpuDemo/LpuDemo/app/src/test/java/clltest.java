import com.example.admin.lpudemo.testter;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by subhita.menon on 27/04/2017.
 */

public class clltest {
    testter t;
    @Test
    public void get() throws Exception
    {
        t=new testter();
        int res=t.sum(20,20);
assertEquals(40,res);
        int c=10+10;
        //assertEquals(20,c);
    }
    @Test(expected = NullPointerException.class)
    public void nullStringTest() {
        String str = null;
        assertTrue(str.isEmpty());
    }


}



