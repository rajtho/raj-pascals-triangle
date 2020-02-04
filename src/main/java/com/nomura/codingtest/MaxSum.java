package com.nomura.codingtest;

import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;

/**
 * Created by raj on 2/1/20-1:59 PM.
 */

/**
 * Uses the {@link PascalsTriangle} to get the max Sum of the trace from top to bottom.
 * Implements the same using dynamic Programming. The cache can be "reset" to reuse the objects in a REPL scenario by recycling  the Position objects.
 * That recycle case is not needed here as the App is used for a one-time command line call. If used in a REPL case, should be improved for reuse.
 */
public class MaxSum {

    private PascalsTriangle pt;
    private final Object2LongOpenHashMap<Position> cacheMaxSum = new Object2LongOpenHashMap<>(1 << 10);


    public long maxSum(PascalsTriangle pt) {
        if(pt.isEmpty()) return 0;
        this.pt = pt;
        return maxSum0(pt.getRootPosition());
    }

    private long maxSum0(Position startP) {
        if(!pt.hasChildren(startP)) return pt.valueAt(startP);
        if(cacheMaxSum.containsKey(startP)) return cacheMaxSum.getLong(startP);

        long maxTrackSum = pt.valueAt(startP) + Math.max(maxSum0(pt.leftChild(startP)), maxSum0(pt.rightChild(startP)));
        cacheMaxSum.put(startP, maxTrackSum);
        return maxTrackSum;
    }


}
