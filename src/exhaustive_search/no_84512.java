package exhaustive_search;

import java.util.ArrayList;
import java.util.Scanner;

// 완전탐색
// 프로그래머스 Level 2
// 모음사전
// https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=java
public class no_84512 {
    ArrayList<String> dic = new ArrayList<>();
    String[] vowel = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        dfs("", 0);

        return dic.indexOf(word);
    }
    // 첫 번째 단어가 A 이기에 "" (빈 문자열) 을 넣어 인덱스를 맞춰줌
    public void dfs(String str, int depth){
        dic.add(str);
        if(depth == 5) return;

        // 중복이 가능하므로 visited 를 사용하지 않음
        for(int i=0; i<vowel.length; i++){
            dfs(str+vowel[i], depth+1);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("word : ");
        String word = sc.nextLine();

        no_84512 problem = new no_84512();
        int result = problem.solution(word);
        System.out.println(result);
    }
}
