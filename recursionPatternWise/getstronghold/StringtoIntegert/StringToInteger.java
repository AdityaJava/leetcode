package leetcode.recursionPatternWise.getstronghold.StringtoIntegert;

/**
 * StringToInteger
 */
public class StringToInteger {
  public int myAtoi(String s) {
    String cleanString = cleanTheString(s);
    if (cleanString == null && cleanString.length() == 1 && cleanString.charAt(0) == '-') {
      return 0;
    }
    int sign = 1;
    if (!Character.isDigit(cleanString.charAt(0))) {
      sign = -1;
      s = cleanString.substring(1);
    }
    int position = 0;
    double number = 0;
    int power = s.length() - 1;
    return (int) myAtoiRecursive(s, position, number, power);
  }

  private String cleanTheString(String s) {
    if (s == null) {
      return null;
    }
    s = s.trim();
    if (s.isEmpty()) {
      return null;
    }

    int i = 0;
    StringBuilder stringBuilder = new StringBuilder();
    if (s.charAt(0) == '-') {
      stringBuilder.append('-');
      i++;
    }
    for (; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        break;
      }
      stringBuilder.append(s.charAt(i));
    }
    return new String(stringBuilder);
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
//    System.out.println(stringToInteger.myAtoi("432"));

    System.out.println(stringToInteger.myAtoi("   -042"));
  }
}
