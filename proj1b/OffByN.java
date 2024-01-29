import java.lang.Math;
public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;

        return diff == 1 || diff == -1;
    }
}