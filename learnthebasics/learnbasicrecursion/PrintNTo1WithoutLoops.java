package leetcode.learnthebasics.learnbasicrecursion;

public class PrintNTo1WithoutLoops {

    private void printNTo1WithoutLoops(int n) {
        System.out.print(n + " ");
        if (n == 1) {
            return;
        }
        printNTo1WithoutLoops(n - 1);
    }

    public static void main(String[] args) {
        PrintNTo1WithoutLoops printNTo1WithoutLoops = new PrintNTo1WithoutLoops();
        printNTo1WithoutLoops.printNTo1WithoutLoops(9);
    }
}
