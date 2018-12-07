import java.util.Arrays;

/*
An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.
 */
public class TriangleCodility {

    /*
    A partir da primeira solução (que você pode ver abaixo) que funcionava apenas para pequenos Arrays.
    Analisei melhor o código e tentei identificar uma maneira de executar apenas um FOR.
    Percebi que se o menor número analisado for maior que o resultado da subtração dos dois maiores numeros,
    estes numeros atendiam ao criterio de uma Triplet.
    O(N*log(N))
     */
    public int solution(int[] A){
        int result = 0;
        if(A.length > 2){
            Arrays.sort(A);
            for(int i=0; i<A.length-2; i++){
                if(A[i] > 0) {
                    if(A[i] > A[i+2] - A[i+1]){
                        result = 1;
                    }
                }
            }
        }
        return result;
    }

    /*
    Este foi minha primeira Solução, como brute force.
    Porém, ela não é muito eficiente. Algo como O(N^2)
    Ao Exeutar no Codility, ela realmente não se mostrou eficiente.
    */
    public int firstSolution(int[] A){
        int result = 0;
        if(A.length > 3){
            Arrays.sort(A);
            for(int i=0; i<A.length-3; i++){
                if(A[i] > 0) {
                    for(int j=i+1; j<A.length-2; j++){
                        if(A[i]+A[j]>A[j+1]) {
                            result = 1;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        TriangleCodility triangleCodility = new TriangleCodility();
        int[] A = {10, 2,5,1,8,20};

        System.out.println(triangleCodility.solution(A));

        int[] B = {10,50,5,1};
        System.out.println(triangleCodility.solution(B));

        int[] C = {5, 3, 3};
        System.out.println(triangleCodility.solution(C));

        int[] D = new int[1000];
        System.out.println(triangleCodility.solution(D));
    }

}
