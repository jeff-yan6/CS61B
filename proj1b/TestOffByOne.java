import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class.d
    @Test
    public void testEqualChars() {

        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('1', '2'));

        assertFalse(offByOne.equalChars('\0', '\0'));
        assertFalse(offByOne.equalChars('.', '.'));
        assertFalse(offByOne.equalChars(' ', ' '));
    }

}
