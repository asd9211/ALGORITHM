package algorithm;


public class ProgGreedy3 {

	public String solution(String number, int k) {
		// number-k 이상 index에서 제일 큰수
		// number-k-1 이상 index에서 제일 큰수
		String[] nm = number.split("");
		boolean[] visited = new boolean[nm.length];
		StringBuffer sb = new StringBuffer();
		int len = nm.length;
		int min = k;
		int maxIdx = 0;
		while(sb.length()!= (len-k)) {
			int max = 0;
			int siz = 0;
			if(min > 0 && ((len-k) - sb.length()) <= min) min --;
			siz = min;
			for(int i = maxIdx ; i < (len-siz) ; i++) {
				if(visited[i])continue;
				if(max<Integer.parseInt(nm[i])) {
					max = Integer.parseInt(nm[i]);
					maxIdx = i;
				}
			}
			visited[maxIdx] = true;
			sb.append(max);
			
		}
		String answer = sb.toString();
		return answer;
	}
	public static void main(String[] args) {
		//"1924"	2 "94"
		ProgGreedy3 t = new ProgGreedy3();
		System.out.println(t.solution("4177252841", 4));
	}
}
