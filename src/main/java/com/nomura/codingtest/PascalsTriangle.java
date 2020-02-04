package com.nomura.codingtest;

/**
 * Created by raj on 2/1/20-2:17 PM.
 */
public interface PascalsTriangle {
    Position getRootPosition();

    boolean isEmpty();

    boolean hasChildren(Position position);

    int valueAt(Position position);

    Position leftChild(Position position);

    Position rightChild(Position position);
}
