package algorithm;

public class Dfs {
	
	private boolean[] visited;
	static int [] result = new int [3];
	static int [] arr = {1,2,3};
	
    public int solution(int[] numbers, int target) {
        int answer = 0;
        visited = new boolean[numbers.length];
        dfs(0, numbers);
        return answer;
    }
    
    public void dfs(int idx, int[] numbers) {
    	if(visited[idx]) return;
    	visited[idx] = true;
    	System.out.println(numbers[idx]);
    	for(int i = 0 ; i < numbers.length; i ++) {
   			dfs(i, numbers);
    	}
    	visited[idx] = false;

    }
    
   
    
    public static void dfs(int n){
        if(n == arr.length){
            for(int i= 0;i<result.length;i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }else{
            for(int i =0;i<arr.length;i++){
                result[n] = arr[i];
                dfs(n + 1);
            }
        }
    }
    
    public static void main(String[] args) {
    	int[] numbers = {1,2,3,4};
    	Dfs dfs = new Dfs();
    	dfs.solution(numbers, 0);
    }

}
