public class Solution{
     public String solution(String s, String skip, int index) {
        // 규칙에 따라 암호를 만든다.
        // s의 각 알파벳을 index만큼의 뒤의 알파벳으로 바꾼다.
        // index 만큼의 뒤에 알파벳이 z를 넘어갈 경우 다시 a로 돌아간다.
        // skip에 있는 알파벳은 제외하고 넘어 간다.
        String[] sArr = s.split("");
        return Arrays.stream(sArr)
                        .map(origin -> encryptString(origin, skip, index))
                        .collect(Collectors.joining());
    }

    public String encryptString(String origin, String skip, int backwardIndex){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabetArr = alphabet.split("");

        int nowIdx = alphabet.indexOf(origin);

        while(true){
            if(skip.contains(alphabetArr[nowIdx])){
                backwardIndex++;
            }
            if(backwardIndex == 0) break;

            nowIdx++;
            backwardIndex--;

            if(nowIdx == alphabetArr.length) nowIdx = 0;
        }

        return alphabetArr[nowIdx];
    } 
}
