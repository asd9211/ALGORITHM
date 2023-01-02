package algorithm;

public class ProgrammersElevator {
	public int solution(int storey) {
		// storey 현재층
		// 0층으로 가기 위해 가장 빠른 숫자
		String s = String.valueOf(storey);
		int overCnt = 0;
		int answer = 0;
		boolean flag = false;

		for (int i = s.length(); i > 0; i--) {
			Integer now = Integer.valueOf(s.substring(i - 1, i));
			Integer next = i > 1 ?Integer.valueOf(s.substring(i - 2, i - 1)):0;

			if (overCnt > 0) {
				if (now == 9)
					now = 0;
				else {
					now += overCnt;
					overCnt = 0;
				}
			}

			if (next >= 5) {
				flag = true;
			}

			if (now > 5 || (now == 5 && flag)) {
				overCnt++;
				now = 10 - now;
				flag = false;
			}
			
			answer += now;
		}

		answer += overCnt;

		return answer;
	}

	public static void main(String[] args) {
		ProgrammersElevator pl = new ProgrammersElevator();
		System.out.println(pl.solution(555));
	}

}
