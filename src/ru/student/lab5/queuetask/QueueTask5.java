package ru.student.lab5.queuetask;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class QueueTask5 {
    private Queue<Integer> sourceQueue;

    public QueueTask5(Queue<Integer> sourceQueue) {
        this.sourceQueue = new ArrayDeque<>(sourceQueue);
    }

    public Queue<Integer> getSourceQueue() {
        return new ArrayDeque<>(sourceQueue);
    }

    public void setSourceQueue(Queue<Integer> sourceQueue) {
        this.sourceQueue = new ArrayDeque<>(sourceQueue);
    }

    public Queue<Integer> reverseCopy() {
        List<Integer> items = new ArrayList<>(sourceQueue);
        Deque<Integer> result = new ArrayDeque<>();
        for (int i = items.size() - 1; i >= 0; i--) {
            result.add(items.get(i));
        }
        return result;
    }

    @Override
    public String toString() {
        return "QueueTask5{sourceQueue=" + sourceQueue + "}";
    }
}
