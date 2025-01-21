package leetcode.recursionPatternWise.getstronghold.pow;

/**
 * Pow
 */
public class Pow {
  public double myPow(double x, int n) {
    int power;
    power = n < 0 ? (n * -1) : n;
    double result = calculatePowRecursively(x, power);
    return n < 0 ? 1 / result : result;
  }

  public double calculatePowRecursively(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    double half = calculatePowRecursively(x, n / 2);
    if (n % 2 == 0) {
      return half * half;
    }
    else {
      return half * half * x;
    }
  }

  public static void main(String[] args) {
    Pow pow = new Pow();
    //    System.out.println(pow.myPow(2.0, 10));
    //    System.out.println(pow.myPow(2.0, -3));
    System.out.println(pow.myPow(2.0, -200000000));
  }
}
