package com.nomura.codingtest;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.nomura.codingtest.Position.of;
import static org.junit.Assert.*;

/**
 * Created by raj on 2/1/20-4:09 PM.
 */

public class PascalsTriangleImplTest {

    @Test
    public void testEmptyTriangle() {
        PascalsTriangleImpl pt = new PascalsTriangleImpl();
        assertTrue(pt.isEmpty());
        assertNull(pt.getRootPosition());
        assertFalse(pt.hasChildren(of(0, 0)));
    }

    @Test
    public void testBasicTriangleFromStringArray() {
        PascalsTriangleImpl pt = PascalsTriangleImpl.from(new String[]{
                "1",
                "22 33 ",
                "5 6 7",
                "88 99 100 101"
        });

        testCommon(pt);
    }

    private void testCommon(PascalsTriangleImpl pt) {
        assertFalse(pt.isEmpty());
        assertEquals(of(0, 0), pt.getRootPosition());
        final Position p6 = of(2, 1);
        final Position p7 = of(2, 2);
        final Position p99 = of(3, 1);
        final Position p100 = of(3, 2);

        assertEquals(6, pt.valueAt(p6));
        assertTrue(pt.hasChildren(p6));
        assertEquals(p99, pt.leftChild(p6));
        assertEquals(pt.leftChild(p7), pt.rightChild(p6));
        assertEquals(100, pt.valueAt(pt.leftChild(p7)));
        assertFalse(pt.hasChildren(p100));
        assertNull(pt.leftChild(p100));
        assertNull(pt.rightChild(p100));
    }

    @Test
    public void testTriangleFromFile() throws IOException {
        PascalsTriangleImpl pt = PascalsTriangleImpl.from(new File(getClass().getClassLoader().getResource("triangle.txt").getFile()));
        testCommon(pt);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidInput() {
        PascalsTriangleImpl.from(new String[]{
                "1",
                "22 33 ",
                "88 99 100 101"
        });

    }

}
