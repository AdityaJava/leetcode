package leetcode.learnthebasics.learnbasicrecursion;

public class PrintGFGWithoutLoop {

    private void printGFGWithoutLoop(int n) {
        if (n == 1) {
            System.out.print("GFG ");
            return;
        } else {
            printGFGWithoutLoop(n - 1);
            System.out.print("GFG ");
        }
    }

    public static void main(String[] args) {
        PrintGFGWithoutLoop printGFGWithoutLoop = new PrintGFGWithoutLoop();
        printGFGWithoutLoop.printGFGWithoutLoop(8);
    }
}
