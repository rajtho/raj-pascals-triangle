
How to Run:

raj@macmini:/opt/code/raj-pascals-triangle/bin$ java -jar raj-pascals-triangle-1.0.jar triangle.txt

 Max sum of verticalTrace is 7272


MaxSum uses Dynamic Programming to accomplish the maximum sum of tracing from top to bottom of the pascals tree.

Since the problem set is a one-time invocation effort has not been put in for object reuse.
But the datastructures have been selected keeping the same in mind.
 - use of fastUtil's' primitive expandable collections and the same could be reset and reused.
 - Position being a mutable object could use a Recycler class to reset its state and be reused
 - The tricky portion is to load the input triangle.txt garbage free. I would approach this with a custom IntStreamIterator that reads the next byte and appends into an int until it hits the delimeter.

