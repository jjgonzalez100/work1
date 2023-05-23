public class GitHubReview {

    public static boolean isOdd(int a) {
        boolean oddResult = false;

        if (a % 2 != 0) {
            oddResult = true;
        }
        return oddResult;
    }

    public static boolean isEven(int a) {
        boolean evenResult = false;

        if(a % 2 == 0) {
            evenResult = true;
        }
        return evenResult;
    }
}
