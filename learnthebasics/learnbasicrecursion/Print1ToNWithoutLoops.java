package leetcode.learnthebasics.learnbasicrecursion;

public class Print1ToNWithoutLoops {

    private void print1ToNWithoutLoops(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        } else {
            print1ToNWithoutLoops(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Print1ToNWithoutLoops print1ToNWithoutLoops = new Print1ToNWithoutLoops();
        print1ToNWithoutLoops.print1ToNWithoutLoops(9);
    }
}
