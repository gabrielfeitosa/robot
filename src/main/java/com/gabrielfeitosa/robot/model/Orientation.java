package com.gabrielfeitosa.robot.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Orientation {

    NORTH('N', 0),
    EAST('E', 1),
    SOUTH('S', 2),
    WEST('W', 3);

    private static List<Orientation> orientations;

    static {
        orientations = new CircularList<>();
        orientations.addAll(Arrays.asList(NORTH, EAST, SOUTH, WEST));
    }

    private final char label;
    private final int index;

    Orientation(char label, int index) {
        this.label = label;
        this.index = index;
    }

    public char getLabel() {
        return label;
    }

    public Orientation getLeft() {
        return orientations.get(this.index - 1);
    }

    public Orientation getRight() {
        return orientations.get(this.index + 1);
    }


    private static class CircularList<T> extends ArrayList<T> {
        @Override
        public T get(int index) {
            if (index < 0) {
                index = index + size();
            }else if(index >= size()){
                index = index - size();
            }
            return super.get(index);
        }

    }
}
