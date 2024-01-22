public class ArrayDequeTest {
    
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		
        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, ad1.isEmpty());

        ad1.addFirst("front");

        passed = checkSize(1, ad1.size()) && passed;
        passed = checkEmpty(false, ad1.isEmpty()) && passed;

        ad1.addLast("middle");
        passed = checkSize(2, ad1.size()) && passed;

        ad1.addLast("back");
        passed = checkSize(3, ad1.size()) && passed;

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        printTestStatus(passed);

    }

    public static void addRemoveTest() {
        System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the l" +
        "ines below (and delete this print statement).");
		
        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();

        boolean passed = checkEmpty(true, ad2.isEmpty());

        for (int i = 119 ; i >= 0 ; --i) {
            ad2.addFirst(i);
        }
        passed = checkSize(120, ad2.size()) && passed;

        for (int i = 0 ; i < 30 ; ++i) {
            ad2.removeLast();
        }
        passed = checkSize(90, ad2.size()) && passed;

        for (int i = 90 ; i < 120 ; ++i) {
            ad2.addLast(i);
            // System.out.print(ad2.get(i) + " ");
        }
        passed = checkSize(120, ad2.size()) && passed;

        for (int i = 0 ; i < 10 ; ++i) {
            ad2.removeFirst();
        }
        passed = checkSize(110, ad2.size()) && passed;

        for (int i = 10 ; i < 120 ; ++i) {
            // System.out.print(ad2.removeFirst()+" ");
            passed = (i == ad2.removeFirst()) && passed;
        }

        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }
}
