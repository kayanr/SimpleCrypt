import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SonnetCypherTest {

    @Test
    public void testCrypt1() {
        ROT13 rot13 = new ROT13();
        String input = SonnetCypher.readFile();

        String actual = rot13.crypt(input);
        String expected = "Gubh neg zber ybiryl naq zber grzcrengr:Naq fhzzre’f yrnfr ungu nyy gbb fubeg n qngr;Naq bsgra vf uvf tbyq pbzcyrkvba qvzz'q;Ol punapr be angher’f punatvat pbhefr hagevzz'q;Abe ybfr cbffrffvba bs gung snve gubh bj’fg;Jura va rgreany yvarf gb gvzr gubh tebj’fg:   Fb ybat yvirf guvf, naq guvf tvirf yvsr gb gurr.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCrypt2() {
        ROT13 rot13 = new ROT13();
        String input = SonnetCypher.readFile();

        String actual = rot13.crypt(rot13.crypt(input));
        String expected = input;
        Assert.assertEquals(expected, actual);
    }
}