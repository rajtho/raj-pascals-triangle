package com.nomura.codingtest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by raj on 2/1/20-4:59 PM.
 */
public class MaxSumTest {

    @Test
    public void maxSumOfEmptyTriangle() {
        MaxSum ms = new MaxSum();
        assertEquals(0, ms.maxSum(new PascalsTriangleImpl()));
    }

    @Test
    public void maxSumBasic() {
        PascalsTriangleImpl pt = PascalsTriangleImpl.from(new String[]{
                "1",
                "22 33 ",
                "5 6 7",
                "88 99 100 101"
        });

        assertEquals(1 + 33 + 7 + 101, new MaxSum().maxSum(pt));
    }

    @Test
    public void maxSumSingleElement() {
        PascalsTriangleImpl pt = PascalsTriangleImpl.from(new String[]{
                "1",
        });
        assertEquals(1 , new MaxSum().maxSum(pt));

    }

}