package algorithm;

import java.util.Arrays;

public class ProgGreedy3 {
	
	public static void main(String[] args) {
		ProgGreedy3 p = new ProgGreedy3();
		int[] test = {3, 7, 2, 8, 6, 4, 5, 1};
		p.solution(test, 3);
	}

	private static int k;
	private static int min;
	
	public int solution(int[] numbers, int K) {
		int answer = 0;
		int len = numbers.length;
		int[] output = new int[len]; 
		boolean[] visited = new boolean[len];
	    int cnt = 0;
		k = K;
	    min = Integer.MAX_VALUE;

	    perm(numbers, 0, len, cnt);
		System.out.println(min);
		return answer;
	}

	static void perm(int[] numbers, int depth, int cur, int cnt) {
		int len = numbers.length;
	    if (depth == cur) {
	    	boolean flag = true;
	        for(int i = 0; i < numbers.length-1; i++) {
	        	if(numbers[i] - numbers[i+1] > k || numbers[i+1] - numbers[i] > k) {
	        		flag = false;
	        		break;
	        	}
	        }
	        if(flag) {
	        	if(min > cnt ) {
	        		min = cnt ;
	        		print(numbers, cur, cnt);

	        	}
	        }
	        return;
	    }
	    
	    for (int i= depth; i < len; i++) {
	    	swap(numbers, depth, i);
	    	int plus = depth != i ? 1 : 0;
	    	perm(numbers, depth + 1, cur, cnt+plus);    
	    	swap(numbers, depth, i);
	    }
	}

	static void print(int[] arr, int cur, int cnt) {
		String str = "";
		for (int i = 0; i < cur; i++)
		System.out.print(arr[i]);
		System.out.println("!"+cnt);
	}

	static void swap(int[] numbers, int idx1, int idx2) {
		int tmp = numbers[idx1];
		numbers[idx1] = numbers[idx2];
		numbers[idx2] = tmp;
	}

	class Graph {
		private int n; // 노드들의 수
		private int maps[][]; // 노드들간의 가중치 저장할 변수

		public Graph(int n) {
			this.n = n;
			maps = new int[n][n];

			// 인접행렬 모든 값 무한대로 초기화
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					maps[i][j] = Integer.MAX_VALUE;

				}
			}
		}

		// 가중치를 넣는 함수
		public void input(int i, int j, int w) {
			maps[i][j] = w;
			maps[j][i] = w;
		}

		public void dijkstra(int v) {
			int distance[] = new int[n]; // 최단거리를 저장할 변수
			boolean[] visited = new boolean[n]; // 노드방문

			for (int i = 0; i < n; ++i) {
				distance[i] = Integer.MAX_VALUE;
			}

			// 시작 노드값 초기화
			distance[v] = 0;
			visited[v] = true;
		}
	}
}
