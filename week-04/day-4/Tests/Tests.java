import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class Tests {

    @Test
    public void getApple_Basic_ReturnsString() {
        Apples apple1 = new Apples();
        assertEquals("apple", apple1.getApple());
    }

    @Test
    public void sum_EmptyList_ReturnsZero() {
        assertEquals(0, new Sum().sum(new ArrayList<Integer>()));
    }

    @Test
    public void sum_ListWithOneElement_ReturnsElement() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3));
        assertEquals(3, new Sum().sum(numbers));
    }

    @Test(expected = NullPointerException.class)
    public void sum_ListWithNull_ThrowsException() {
       new Sum().sum(null);
    }

    @Test
    public void sum_ListWithMultipleElements_ReturnsSum() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 4, 2, -5));
        assertEquals(4, new Sum().sum(numbers));
    }

    @Test
    public void sum_ListWithNegativeElement_ReturnsSum() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(-5));
        assertEquals(-5, new Sum().sum(numbers));
    }

    @Test
    public void sum_ListWithMultipleNegativeElement_ReturnsSum() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, -4, 2, -5));
        assertEquals(-4, new Sum().sum(numbers));
    }

    @Test(expected = NullPointerException.class)
    public void isAnagram_OneEmptyString_ThrowsException() {
        Anagram anagram = new Anagram();
        anagram.isAnagram("", "fluster");
    }

    @Test(expected = NullPointerException.class)
    public void isAnagram_TwoEmptyStrings_ThrowsException() {
        Anagram anagram = new Anagram();
        anagram.isAnagram("", "");
    }

    @Test(expected = NullPointerException.class)
    public void isAnagram_OneNullString_ThrowsException() {
        Anagram anagram = new Anagram();
        anagram.isAnagram(null, "fluster");
    }

    @Test(expected = NullPointerException.class)
    public void isAnagram_TwoNullString_ThrowsException() {
        Anagram anagram = new Anagram();
        anagram.isAnagram(null, null);
    }

    @Test
    public void isAnagram_AnagramStrings_ReturnsTrue() {
        Anagram anagram = new Anagram();
        assertTrue(anagram.isAnagram("restful", "fluster"));
    }

    @Test
    public void isAnagram_AnagramStringsWithSpace_ReturnsTrue() {
        Anagram anagram = new Anagram();
        assertTrue(anagram.isAnagram("forty five", "over fifty"));
    }

    @Test
    public void isAnagram_EqualLengthNonAnagramStrings_ReturnsFalse() {
        Anagram anagram = new Anagram();
        assertFalse(anagram.isAnagram("restful", "flugter"));
    }

    @Test
    public void isAnagram_NonEqualLengthStrings_ReturnsFalse() {
        Anagram anagram = new Anagram();
        assertFalse(anagram.isAnagram("restful", "flus gterv"));
    }

    @Test(expected = NullPointerException.class)
    public void countLetters_Null_ThrowsException() {
        CountLetters countLetters = new CountLetters();
        countLetters.countLetters(null);
    }

    @Test
    public void countLetters_NoLetter_ReturnsEmptyMap() {
        CountLetters countLetters = new CountLetters();
        HashMap<Character, Integer> expectedMap = new HashMap<>();
        assertEquals(expectedMap, countLetters.countLetters(""));
    }

    @Test
    public void countLetters_OneLetter_ReturnsSolution() {
        CountLetters countLetters = new CountLetters();
        HashMap<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('d', 1);
        assertEquals(expectedMap, countLetters.countLetters("d"));
    }

    @Test
    public void countLetters_AllLettersDifferent_ReturnsSolution() {
        CountLetters countLetters = new CountLetters();
        HashMap<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('d', 1);
        expectedMap.put('e', 1);
        expectedMap.put('f', 1);
        expectedMap.put('a', 1);
        expectedMap.put('u', 1);
        expectedMap.put('l', 1);
        expectedMap.put('t', 1);
        assertEquals(expectedMap, countLetters.countLetters("default"));
    }

    @Test
    public void countLetters_OneLetterMultipleTimes_ReturnsSolution() {
        CountLetters countLetters = new CountLetters();
        HashMap<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('d', 1);
        expectedMap.put('i', 1);
        expectedMap.put('f', 2);
        expectedMap.put('e', 1);
        expectedMap.put('r', 1);
        assertEquals(expectedMap, countLetters.countLetters("differ"));
    }

    @Test
    public void countLetters_MultipleLettersMultipleTimes_ReturnsSolution() {
        CountLetters countLetters = new CountLetters();
        HashMap<Character, Integer> expectedMap = new HashMap<>();
        expectedMap.put('d', 1);
        expectedMap.put('i', 1);
        expectedMap.put('f', 2);
        expectedMap.put('e', 2);
        expectedMap.put('r', 1);
        expectedMap.put('n', 1);
        expectedMap.put('t', 1);
        assertEquals(expectedMap, countLetters.countLetters("different"));
    }




    }
