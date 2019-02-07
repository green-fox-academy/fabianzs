import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestExtension {

    Extension extension = new Extension();

    @Test
    public void testAdd_2and3is5() {
        assertEquals(5, extension.add(2, 3));
    }

    @Test
    public void testAdd_1and4is5() {
        assertEquals(5, extension.add(1, 4));
    }

    @Test
    public void testAdd_2and4is6() {
        assertEquals(6, extension.add(2, 4));
    }

    @Test
    public void testMaxOfThree_first() {
        assertEquals(5, extension.maxOfThree(5, 4, 3));
    }

    @Test
    public void testMaxOfThree_third() {
        assertEquals(5, extension.maxOfThree(3, 4, 5));
    }

    @Test
    public void testMaxOfThree_second() {
        assertEquals(6, extension.maxOfThree(3, 6, 5));
    }

    @Test
    public void testMaxOfThree_firstAndSecond() {
        assertEquals(7, extension.maxOfThree(7, 7, 5));
    }

    @Test
    public void testMaxOfThree_secondAndThird() {
        assertEquals(8, extension.maxOfThree(4, 8, 8));
    }

    @Test
    public void testMaxOfThree_firstAndThird() {
        assertEquals(10, extension.maxOfThree(10, 5, 10));
    }

    @Test
    public void testMaxOfThree_all() {
        assertEquals(10, extension.maxOfThree(10, 10, 10));
    }

    @Test(expected = NullPointerException.class)
    public void testMedian_empty() {
        extension.median(Arrays.asList());
    }

    @Test
    public void testMedian_one() {
        assertEquals(5, extension.median(Arrays.asList(5)), 0.1);
    }

    @Test
    public void testMedian_two() {
        assertEquals(6, extension.median(Arrays.asList(5, 8)), 0.1);
    }

    @Test
    public void testMedian_four() {
        assertEquals(5, extension.median(Arrays.asList(7,5,3,5)), 0.1);
    }

    @Test
    public void testMedian_fourDifferentInOrder() {
        assertEquals(4, extension.median(Arrays.asList(1,3,5,6)), 0.1);
    }

    @Test
    public void testMedian_fourDifferentNotInOrder() {
        assertEquals(4, extension.median(Arrays.asList(3,6,1,5)), 0.1);
    }

    @Test
    public void testMedian_five() {
        assertEquals(2, extension.median(Arrays.asList(1,2,3,2,5)), 0.1);
    }

    @Test
    public void testMedian_fiveDifferentInOrder() {
        assertEquals(3, extension.median(Arrays.asList(1,2,3,4,5)), 0.1);
    }

    @Test
    public void testMedian_fiveDifferentNotInOrder() {
        assertEquals(6, extension.median(Arrays.asList(3,6,7,2,13)), 0.1);
    }

    @Test
    public void testIsVowel_a() {
        assertTrue(extension.isVowel('a'));
    }

    @Test
    public void testIsVowel_u() {
        assertTrue(extension.isVowel('u'));
    }

    @Test
    public void testIsVowel_specialchar() {
        assertTrue(extension.isVowel('ú'));
    }

    @Test
    public void testIsVowel_b() {
        assertFalse(extension.isVowel('b'));
    }

    @Test
    public void testTranslate_bemutatkozik() {
        assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
    }

    @Test
    public void testTranslate_ribizli() {
        assertEquals("rivibivizlivi", extension.translate("ribizli"));
    }

    @Test
    public void testTranslate_fűnyíró() {
        assertEquals("fűvűnyívíróvó", extension.translate("fűnyíró"));
    }

    @Test
    public void testTranslate_lagopus() {
        assertEquals("lavagovopuvus", extension.translate("lagopus"));
    }
}