package leetcode.recursionPatternWise.getstronghold.StringtoIntegert;

/**
 * StringToInteger
 */
public class StringToInteger {
  public int myAtoi(String s) {
    int position = 0;
    double number = 0;
    int power = s.length() - 1;
    return (int)myAtoiRecursive(s, position, number, power);
  }

  public double myAtoiRecursive(String s, int position, double number, int power) {
    if (position == (s.length() - 1)) {
      return s.charAt(position) - '0';
    }
    number = myAtoiRecursive(s, position + 1, number, power - 1);
    number = number + (Math.pow(10, power) * (s.charAt(position) - '0'));
    return number;
  }

  public static double myAtoiIterative(String s) {
    int length = s.length() - 1;
    double sum = 0;
    int pow = 0;
    for (int i = length; i >= 0; i--) {
      sum = sum + (Math.pow(10, pow) * (s.charAt(i) - '0'));
      pow++;
    }
    return sum;
  }

  public static void main(String[] args) {
    //    double number = StringToInteger.myAtoiIterative("432");
    //    System.out.println(number);
    StringToInteger stringToInteger = new StringToInteger();
    System.out.println(stringToInteger.myAtoi("432"));
  }
}
