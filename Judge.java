import java.util.*;

public class Judge {

    public int findJudge(int n, int [][] trust) {

        int trusts[] = new int[n];
        int j = 0;
        for (int i = 0; i < trust.length; i++) {

            if (trust[i][0] > 0 && trust[i][j] != trust[i][j+1]) {
                trusts[trust[i][0]-1] += 1;
            } else {
                System.out.println("Values are the same for: " + trust[i][j] + " " + trust[i][j+1]);
            }
        }

        int judge_n = -1;
        int list[] = new int[n];
        for (int k = 0; k < n; k++) {

            int c = 0;
            if (trusts[k]==0) {
                for (int p = 0; p < trust.length; p++) {
                    boolean b = false;

                    for (int l = 0; l < c; l++) {
                        if (trust[p][0] == list[l]) {
                            b = true;
                            break;
                        }
                    }

                    if (trust[p][1] == k+1 && b == false) {
                        list[c] = trust[p][0];
                        c += 1;
                    } else {
                        if (!b) {
                            break;
                        }
                    }

                }
            }
            if (c== n-1) {
                judge_n = k+1;
                break;
            }
        }
        return judge_n;
    }

    public static void main(String[] args) {
        Judge j = new Judge();
        int arr[][] = {{1,3}, {2,3}};
        int arr2[][] = {{1,3}, {2,3}, {3,1}};
        int arr3[][] = {{1,2}, {2,3}};
        int arr4[][] = {{1,3}, {1,4}, {2,3}, {2,4}, {4,3}};

        System.out.println("The judge for arr is: " + j.findJudge(3,arr));
        System.out.println("The judge for arr2 is: " + j.findJudge(3,arr2));
        System.out.println("The judge for arr3 is: " + j.findJudge(3,arr3));
        System.out.println("The judge for arr4 is: " + j.findJudge(4,arr4));

    }
}
