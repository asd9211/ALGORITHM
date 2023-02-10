import java.util.*;
class Solution {

 public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, 0));
        HashSet<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int depth = node.depth;
            int value = node.value;
            
            if(set.contains(value)){
                continue;
            }else{
                set.add(value);
            }

            if (value == y) {
                answer = depth;
                break;
            }

            if (value < y) {
                queue.add(new Node(value * 2, depth+1));
                queue.add(new Node(value * 3, depth+1));
                queue.add(new Node(value + n, depth+1));
            }

        }

        return answer;
    }

    private static class Node {
        int value;
        int depth;

        Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }
    }
}
