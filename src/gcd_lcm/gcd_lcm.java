package gcd_lcm;

import java.util.Scanner;

public class gcd_lcm {
    public int gcd(int a, int b){
        // 최대 공약수를 구하는 알고리즘
        // 유클리드 호제법
        /*
        2개의 자연수 a, b(a > b)에 대해서 a를 b로 나눈 나머지가 r일 때, a와 b의 최대공약수는 b와 r의 최대공약수와 같다.


        예를 들어 두 수 648과 232을 입력받는다고 했을 때, 두 수에서 더 큰 수는 648이기 때문에 a를 648로 두고 위의 과정에 대입해서 계산해본다. 648을 232로 나눴을 때 나누어 떨어지지 않기 때문에 나머지를 구한다.
        648 % 232 = 184, 232는 184로 나누어 떨어지지 않음 다시 나눔
        232 % 184 = 48, 184은 48로 나누어 떨어지지 않음 다시 나눔
        184 % 48 = 40, 48은 40으로 나누어 떨어지지 않음 다시 나눔
        48 % 40 = 8, 40은 8로 나누어 떨어지므로
        최종적으로 r은 0이 되므로 계산 종료 최대공약수는 8
         */

        int max = Math.max(a,b);
        int min = Math.min(a,b);
        int r = 0;
        while(min > 0){
            r = max % min;
            max = min;
            min = r;
        }
        return max;
    }

    public static int lcm(int r, int a, int b){
        // 최소 공배수
        // 두 수의 곱을 최대 공약수로 나누는 것 
        return a * b / r;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[2];
        for(int i = 0; i< 2; i++){
            arr[i] = sc.nextInt();
        }
        gcd_lcm gcm = new gcd_lcm();
        int r = gcm.gcd(arr[0], arr[1]);
        System.out.println(r);
        int l = lcm(r, arr[0], arr[1]);
        System.out.println(l);
    }
}
