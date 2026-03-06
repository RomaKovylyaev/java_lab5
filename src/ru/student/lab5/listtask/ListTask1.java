package ru.student.lab5.listtask;

import java.util.ArrayList;
import java.util.List;

public class ListTask1 {
    private List<Integer> list;
    private int elementToRemove;

    public ListTask1(List<Integer> list, int elementToRemove) {
        this.list = new ArrayList<>(list);
        this.elementToRemove = elementToRemove;
    }

    public List<Integer> getList() {
        return new ArrayList<>(list);
    }

    public void setList(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    public int getElementToRemove() {
        return elementToRemove;
    }

    public void setElementToRemove(int elementToRemove) {
        this.elementToRemove = elementToRemove;
    }

    public List<Integer> solve() {
        List<Integer> result = new ArrayList<>(list);
        result.removeIf(value -> value == elementToRemove);
        return result;
    }

    @Override
    public String toString() {
        return "ListTask1{list=" + list + ", elementToRemove=" + elementToRemove + "}";
    }
}
