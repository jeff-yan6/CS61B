import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    // Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("."));
        assertTrue(palindrome.isPalindrome("123..321"));
        assertTrue(palindrome.isPalindrome("a@@addFS0O'O0SFdda@@a"));

        assertFalse(palindrome.isPalindrome("123"));
        assertFalse(palindrome.isPalindrome("jsklajnjffwii1"));
    }

    @Test
    public void testIsPalindromeOverLoad() {
        CharacterComparator offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome(".", offByOne));
        assertTrue(palindrome.isPalindrome("$%", offByOne));
        assertTrue(palindrome.isPalindrome("132", offByOne));

        assertFalse(palindrome.isPalindrome("123..321", offByOne));
        assertFalse(palindrome.isPalindrome("a@@addFS0O'O0SFdda@@a", offByOne));
        assertFalse(palindrome.isPalindrome("jsklajnjffwii1", offByOne));
    }
}
