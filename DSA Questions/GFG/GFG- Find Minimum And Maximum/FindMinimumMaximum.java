
public class FindMinimumMaximum {

    public Pair<Long, Long> getMinMax(int[] arr) {
        // Code Here

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int el : arr) {

            maxVal = Math.max(el, maxVal);
            minVal = Math.min(el, minVal);
        }

        return new Pair(minVal, maxVal);
    }

}
