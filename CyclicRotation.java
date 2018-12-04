public class CyclicRotation {

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] aux = {3, 8, 9, 7, 6};

        int[] result = cyclicRotation.solutionToRight(aux, 3);

        System.out.println(Arrays.toString(result));

    }

    public int[] solutionToRight(int[] A, int K) {
        // write your code in Java SE 8
        for (int j=0; j<K; j++){
            int temp = A[A.length-1];
            for(int i=A.length-1; i>0; i--){
                A[i] = A[i-1];
            }
            A[0] = temp;
        }
        return A;
    }

    public int[] solutionToLeftRotation(int[] A, int K) {
        // write your code in Java SE 8
        for (int j=0; j<K; j++){
            int temp = A[0];
            for(int i=0; i<A.length-1; i++){
                A[i] = A[i+1];
            }
            A[A.length-1] = temp;
        }
        return A;
    }

}
