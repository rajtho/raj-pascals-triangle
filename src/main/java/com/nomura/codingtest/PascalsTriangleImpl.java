package com.nomura.codingtest;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static java.util.Arrays.stream;

/**
 * Created by raj on 2/1/20-2:33 PM.
 */
public class PascalsTriangleImpl implements PascalsTriangle {

    private final ObjectArrayList<IntArrayList> twoDArray = new ObjectArrayList<>(1 << 10);

    public static PascalsTriangleImpl from(File file) throws IOException {
        PascalsTriangleImpl pt = new PascalsTriangleImpl();
        try (BufferedReader bf = new BufferedReader(new FileReader(file))){

            String s;
            while((s = bf.readLine())!=null) {
                pt.add(s);
            }
        }
        return pt;
    }

    public static PascalsTriangleImpl from(String[] triangle) {
        PascalsTriangleImpl pt = new PascalsTriangleImpl();
        stream(triangle).forEach(pt::add);
        return pt;
    }

    private void add(String newLine) {
        if(newLine.trim().isEmpty()) return;
        final IntArrayList intList = parse(newLine);
        if(intList.size() != twoDArray.size()+1) {
            String msg = String.format("Invalid Pascals Triangle! : %s has to have only 1 more element than the previous array %s", newLine, twoDArray.get(twoDArray.size()-1));
            throw new RuntimeException(msg);
        }
        twoDArray.add(intList);

    }

    private IntArrayList parse(String line) {
        final String[] intStrings = line.split(" ");
        IntArrayList intList = new IntArrayList(1 << 10);
        stream(intStrings).forEach(s -> intList.add(Integer.parseInt(s.trim())));
        return intList;
    }

    public Position getRootPosition() {
        if(isEmpty()) return null;
        return Position.of(0,0);
    }

    public boolean isEmpty() {
        return twoDArray.isEmpty();
    }

    public boolean hasChildren(Position position) {
        return position.getX() < twoDArray.size()-1;
    }

    public int valueAt(Position position) {
        return twoDArray.get(position.getX()).getInt(position.getY());
    }

    public Position leftChild(Position position) {
        if(!hasChildren(position)) return null;
        return Position.of(position.getX() + 1, position.getY());
    }

    public Position rightChild(Position position) {
        if(!hasChildren(position)) return null;
        return Position.of(position.getX() + 1, position.getY()+1);
    }
}
