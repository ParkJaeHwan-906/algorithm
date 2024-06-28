package exhaustive_search;

// 완전탐색
// 프로그래머스 Level 2
// 피로도
// https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=java
public class no_87946 {
    static int answer = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        /*
        k : 현재 피로도
        dungeons : [최소 필요 피로도, 소모 피로도]
         */
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);

        return answer;
    }

    public void dfs(int max, int k, int[][] dungeons){
        for(int i=0; i< dungeons.length; i++){
            if(k>=dungeons[i][0] && !visited[i]){
                visited[i] = true;
                dfs(max+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(max, answer);
    }

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};

        no_87946 problem = new no_87946();
        int result = problem.solution(k, dungeons);
        System.out.println(result);
    }
}
