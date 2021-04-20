package algorithm;


public class ProgGreedy3 {
	public String solution(String number, int k) {
		// number-k 이상 index에서 제일 큰수
		// number-k-1 이상 index에서 제일 큰수
		//String[] nm = number.split("");
		boolean[] visited = new boolean[number.length()];
		StringBuilder sb = new StringBuilder();
		int len = number.length();
		int min = k;
		int maxIdx = 0;
		int size = len-k;
		int max = 0;
		while(sb.length()!= size) {
			max = 0;
			min++;
			for(int i = maxIdx ; i < len-(len-min) ; i++) {
				if(visited[i])continue;
				if(max < Character.getNumericValue(number.charAt(i))) {
					max = Character.getNumericValue(number.charAt(i));
					maxIdx = i;
				}
			}
			visited[maxIdx] = true; 
			sb.append(max);
		} 
		return sb.toString();
	}
	 
	public static void main(String[] args) {
		//"1924"	2 "94"
		ProgGreedy3 t = new ProgGreedy3();
		System.out.println(t.solution("4177252841", 4));
	}
}
