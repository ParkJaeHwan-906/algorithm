package exhaustive_search;

import java.util.*;
// 완전탐색
// 프로그래머스 Level 2
// 소수 찾기
// https://school.programmers.co.kr/learn/courses/30/lessons/42839?language=java
public class no_42839 {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        // 만들 수 있는 모든 경우의 수
        boolean[] visited = new boolean[numbers.length()];
        dfs(numbers, visited, 0, "");
        int answer = 0;
        for(int i : set){
            if(isPrime(i)) answer++;
        }
        return answer;
    }

    public void dfs(String numbers, boolean[] visited, int depth, String s){
        if(depth > numbers.length()) return;

        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                set.add(Integer.parseInt(s+numbers.charAt(i)));
                dfs(numbers, visited, depth+1, s+numbers.charAt(i));
                visited[i] = false;
            }
        }
    }
    // 소수인지 판별
    public boolean isPrime(int n){
        if(n < 2) return false;

        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("numbers : ");
        String numbers = sc.nextLine();
        no_42839 problem = new no_42839();

        int result = problem.solution(numbers);

        System.out.println(result);
    }
}
