public class PermFindMissing {
    public static void main(String[] args) {

        int[] A = {2,3,1,5}; //missing 4

        PermFindMissing permFindMissing = new PermFindMissing();
        System.out.println(permFindMissing.solution(A));

    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        long N = A.length + 1;
        long sum = N * (N + 1) / 2;
        for (int i = 0; i < A.length; i++) sum -= A[i];
        return (int) sum;
    }
}
