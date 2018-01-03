# Overview

This is a Java implementation of traversing a Directed Acyclic Graph for the purpose of finding the longest path from any given Vertex. 

In **Graph.java** you will find methods:

* `public Collection<Path> getAllPaths(Vertex origin)` Does a recursive depth first search to find every `Path` from the origin. Only paths that reach a terminating end point are included.   
* `public Path getLongestPath(Vertex origin)` Finds the longest path from a given origin. This simply delegates to `getAllPaths(Vertex origin)` to find all paths, then returns the longest one.

Another thing to note is that this implementation makes use of Java 8 and `Streams`. I have implemented Graph and Tree searches in the past, but have never done it with the new Java Stream functionality. Since this was a learning exercise I thought I would explore if this was an appropriate use case for `Streams` and a `functional` programming style. I believe it is, and I'm pleased with how it came out.  

# Running the code

This is a Maven project with several unit tests that demonstrate usage of `Graph.java`. Please see the tests in `GraphTest.java`, 
where you will find a method that creates a test graph that is used throughout the tests. A crude diagram of the test graph is 
included in the code comments.

To run the tests:
*  Run `mvn test` from the command line.
*  Or open this project in your favorite IDE and execute from there.

The tests for `Graph.getAllPaths()` do a `println()` of the paths that are found (in addition to programmatically asserting correctness). This gives the user something to look at and compare with the crude graph diagram mentioned above. 

# Computational Complexity

Its been a while since I have worked with the formal mathematical constructs for representing complexity, but I believe this would be considered a `polynomial time` algorithm. This is because each vertex is visited once for each distinct path through the graph. So for example, if there were a subset 100 vertices that were reachable from 10 different paths, we would have a combined 1000 visits to those vertices.  

If each vertex were visited only once then this would be `O(n)`. However, since vertices are visited once for each distinct path through the graph, I believe the complexity can be represented as `O(n * p)` where `n = number of vertices` and `p = number of paths` 

The performance could be improved by enhancing the algorithm such that when it encounters a known vertex again via a new path, that it not continue the traversal. Rather recognize that all paths leading from that vertex are already known and simply retrieve them from a cache. 

# Limitations and Potential Optimizations

* The algorithm in Graph.java for finding all paths can not handle cycles. Will work only for Acylic Graphs.
* Graph.getLongestPath() returns only a single path. If multiple paths are found that are tied for the longest then only one will be returned. It will be arbitrary as to which one in returned.
  * Note: It would be fairly simple to enhance Graph.getLongestPath() to return a Collection of Paths. 

