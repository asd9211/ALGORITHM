package algorithm;

public class ProgrammersDepence {
	private boolean[] visited;
	static int[] result = new int[3];
	static int[] arr = { 1, 2, 3 };

	public int solution(int n, int k, int[] enemy) {
		// 병사 n명
		// 매 라운드마다 enemy[i]만큼 적 등장
		// n - enemy[i]로 막을 수 있음.
		// 무적권 k번. 한턴 무적권 막을 수 있음.

		int answer = 0;
		return answer;
	}

	public void dfs(int idx, int[] numbers) {
		if (visited[idx])
			return;
		visited[idx] = true;
		System.out.println(numbers[idx]);
		for (int i = 0; i < numbers.length; i++) {
			dfs(i, numbers);
		}
		visited[idx] = false;

	}

}
