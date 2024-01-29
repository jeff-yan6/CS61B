public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> dq = new ArrayDeque<Character>();
        for (char ch : word.toCharArray()) {
            dq.addLast(ch);
        }
        return dq;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);

        return helper(deque);
    }
    private boolean helper(Deque<Character> deque) {
        if (deque.isEmpty()) {
            return true;
        } else if (deque.size() == 1) {
            return true;
        } else if (deque.removeFirst() == deque.removeLast()) {
            return helper(deque);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);

        return helper2(deque, cc);
    }
    private boolean helper2(Deque<Character> deque, CharacterComparator cc) {
        if (deque.isEmpty() || deque.size() == 1) {
            return true;
        } else if (cc.equalChars(deque.removeFirst(), deque.removeLast())) {
            return helper2(deque, cc);
        } else {
            return false;
        }
    }
}