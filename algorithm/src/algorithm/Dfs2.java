package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Dfs2 {

	private String[][] globalMap;
	private boolean[][] visited;
	private int N;
	private int M;

	public int solution(int[][] maps) {
		int answer = 0;
		N = maps[0].length - 1; // 가로
		M = maps.length - 1; // 세로
		// globalMap = maps.clone();
		visited = new boolean[N + 1][M + 1];
		Queue<Integer> xQue = new LinkedList<Integer>();
		Queue<Integer> yQue = new LinkedList<Integer>();
		Queue<Integer> cQue = new LinkedList<Integer>();

		xQue.add(0);
		yQue.add(0);
		cQue.add(1);
		while (!xQue.isEmpty()) {
			int cx = xQue.poll();
			int cy = yQue.poll();
			int cc = cQue.poll();

			if (cx == N && cy == M) {
				answer = cc;
				break;
			}

			if (visited[cy][cx])
				continue;
			visited[cy][cx] = true;

			// 상
			if (check(cx, cy - 1)) {
				yQue.add(cy - 1);
				xQue.add(cx);
				cQue.add(cc + 1);
			}
			// 하
			if (check(cx, cy + 1)) {
				yQue.add(cy + 1);
				xQue.add(cx);
				cQue.add(cc + 1);
			}
			// 좌
			if (check(cx - 1, cy)) {
				yQue.add(cy);
				xQue.add(cx - 1);
				cQue.add(cc + 1);
			}
			// 우
			if (check(cx + 1, cy)) {
				yQue.add(cy);
				xQue.add(cx + 1);
				cQue.add(cc + 1);
			}
		}
		return answer;
	}

	public int solution2(String[] R) {
		int y = R.length;
		int x = R[0].length();

		Queue<String> que = new LinkedList<>();
		que.add("R");
		que.add("D");
		que.add("L");
		que.add("U");

		visited = new boolean[y][x];
		globalMap = new String[y][x];

		for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < R[i].length(); j++) {
				globalMap[i][j] = String.valueOf(R[i].charAt(j));
			}
		}

		String direction = "R";

		int cy = 0;
		int cx = 0;
		while (true) {
			if (visited[cy][cx]) break;

			if (globalMap[cy][cx].equals("X")) {
				que.add(que.poll());
				direction = que.peek();
				continue;
			}

			visited[cy][cx] = true;
			
			switch (direction) {
			case "R":
				cx = cx + 1;
				break;
			case "L":
				cx = cx - 1;
				break;
			case "U":
				cy = cy - 1;
				break;
			case "D":
				cy = cy + 1;
				break;
			default:
				break;
			}

		}

		return 0;
	}

	public boolean check(int x, int y) {
    	if(x<0 || y<0 || x > N || y > M) return false;
    	if(globalMap[y][x].equals("X")) return false;
		return true;
	}
	
//	public boolean check(int x, int y) {
////    	if(x<0 || y<0 || x > N || y > M) return false;
////    	if(globalMap[y][x] == 0) return false;
//		return true;
//	}

	public static void main(String[] args) {
		Dfs2 d = new Dfs2();
		String[] R = { "...X", ".X..X" };
		d.solution2(R);

	}
}
