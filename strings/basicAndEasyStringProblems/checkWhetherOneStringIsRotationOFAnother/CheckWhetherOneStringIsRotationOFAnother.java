package leetcode.strings.basicAndEasyStringProblems.checkWhetherOneStringIsRotationOFAnother;

public class CheckWhetherOneStringIsRotationOFAnother {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String concatination = s + s;
        return concatination.contains(goal);
    }

    public static void main(String[] args) {

    }
}
