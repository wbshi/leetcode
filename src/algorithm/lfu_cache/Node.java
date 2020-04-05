package src.algorithm.lfu_cache;

public class Node implements Comparable<Node>{
    int key;
    int value;
    int freq = 1;
    long idx = System.nanoTime();

    public Node() {}

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(Node node) {
        int diff = freq - node.freq;
        return diff == 0? (int)(idx - node.idx): diff;
    }
}
