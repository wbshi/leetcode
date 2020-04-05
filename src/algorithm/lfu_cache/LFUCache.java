package src.algorithm.lfu_cache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LFUCache {
    Map<Integer, Node> map; //存储键值对
    Queue<Node> queue; //根据频率排序
    int capacity;

    public LFUCache(int capacity) {
        map = new HashMap<>(capacity);
        if (capacity > 0) {
            queue = new PriorityQueue<>(capacity);
        }
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        //1. 同Key更新Value
        //2. 未满添加
        //3. 已满添加
        if (capacity == 0) return;

        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            queue.remove(node);
            node.freq ++;
            node.idx = System.nanoTime();
            queue.offer(node);
            return;
        }
        if (map.size() == capacity) {
            Node temp = queue.poll();
            map.remove(temp.key);
        }
        Node nNode = new Node(key, value);
        map.put(key, nNode);
        queue.offer(nNode);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        queue.remove(node);
        node.freq ++;
        node.idx = System.nanoTime();
        queue.offer(node);
        return node.value;
    }

}
