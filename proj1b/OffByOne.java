import java.math;
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return math.abs(diff) == 1;
    }
}