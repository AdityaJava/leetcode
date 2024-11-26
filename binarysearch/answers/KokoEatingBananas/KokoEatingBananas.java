package leetcode.binarysearch.answers.KokoEatingBananas;

public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int max = getMax(piles);

        int low = 1;
        int high = max;
        int mid = -1;
        int totalTimeTakenToEatAllPiles = 0;
        int answer = -1;
        while (low <= high) {
            //Here mid represents speed_to_eat_bananas/hour
            mid = (low + high) / 2;
            totalTimeTakenToEatAllPiles = getTotalTimeTakenToEatAllPiles(piles, mid);
            // Here totalTimeTakenToEatAllPiles is inversely proportional to speed_to_eat_bananas/hour i:e mid
            // That is if we increase speed_to_eat_bananas/hour then we will get less totalTimeTakenToEatAllPiles
            // So now if our totalTimeTakenToEatAllPiles exceeds hour then we need to increase speed_to_eat_bananas/hour
            if (totalTimeTakenToEatAllPiles > h) {
                low = mid + 1;
            } else if (totalTimeTakenToEatAllPiles <= h) {
                answer = mid;
                high = mid - 1;
            }
        }
        return answer;
    }

    private int getTotalTimeTakenToEatAllPiles(int[] piles, double eatingBananaSpeedPerHour) {
        int sum = 0;
        for (double pile : piles) {
            sum = (int) (sum + Math.ceil(pile / eatingBananaSpeedPerHour));
        }
        return sum;
    }

    private int getMax(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int element : array) {
            if (max < element) {
                max = element;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
//        int[] piles = {3, 6, 7, 11};
//        int h = 8;

        int[] piles = {1, 1, 1, 999999999};
        int h = 10;

        System.out.println(kokoEatingBananas.minEatingSpeed(piles, h));
    }
}
