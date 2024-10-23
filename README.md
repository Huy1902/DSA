# My process
- Lec1: Introduction to Java (done)
  + IntroJava
- Lec2: Union-Find (done)
  + Percolation
  + Quick find (optimize find is O(1)) is too slow (with access model is N^2 to 
process a sequence of N union operations of N object). Union too expensive. Trees are flat,
but too expensive to keep them flat
  + Quick union: Trees can get tall. Find/connected too expensive (could be N array accesses).
  + Improvement 1: Weighting: Keep track of size of each tree to avoid tall tree by linking
root of smaller tree to root of larger tree.
    + Find: take time proportional to depth of p
    + Union: takes constant time, **given roots**
    + Depth of any node x is at most lg(N) (Pf: What cause depth of tree contain x increase? 
    The size of tree can double at most lgN time means at most lgN of depth. Why?).
    + Hence, we can ensure find O(lgN), union O(lgN), connected O(lgN)
  + Improvement 2: path compression: Make every node in path point to its grandparent
    + Keep tree almost completely flat
  + wighted QU + path compression: in theory is not linear but linear in practice.
  + Benefits: It significantly improves the performance of the union-find algorithm in practical scenarios.

  ![img.png](src/main/resources/img.png)
- Lec3: Algorithm analyzing (done)
  + Linkedlist: Hackerrank
  + Interface and Generic: Build my Linkedlist
  + Observation
    + Empirical analysis
    + Data analysis (Standard plot, Log-log plot)
    + Example for Log-log plot
    
    ![img.png](src/main/resources/img1.png)
    
  + Mathematical model
    + Simplification 1: Cost model
    + Simplification 2: Tilde notation
    + Diversion: estimate a discrete sum (Trick: replace sum with an integral, and use calculus.)
  + Order-of-growth classification(Better => Faster in practice)
    
    ![img.png](img.png)

  + Theory of algorithm
    + Best case: Lower bound on cost (a goal for all input)
    + Worst case: Upper bound on cost (a guarantee for all input)
    + Average case: Expected cost for random input (a way to predict performance)
    + Optimal algorithm: Lower bound = upper bound (to within a constant factor)
    + Notation:
  
    ![img_2.png](src/main/resources/img_2.png)
  
  + Memory: Typical memory in Java
    + Object overhead: 16 bytes
    + Reference: 8 bytes
    + Padding: Each object uses a multiple of 8 bytes
  
- Lec4: Stack and Queue (done)
  + Iterator: Build my Stack and Queue
  + Stack LIFO and Queue FILO: Hackkerank
  + When i mention linked list, i mean singly linked list. In doubly linked list, it's easier to implement.

  + Stack: linked list
    + push: O(1)
    + pop: O(1)
  + Stack: resizing array (Remember: amortized analysis account for the long-term 
  average performance rather than worst-case for each operation)
    + Double when array is full
    + Halve size when array is one-quarter full
    + Array is between 25% and 100% full
    + We have N for doubling and halving operations

  ![img_1.png](img_1.png)

  + Queue: linked list
    + enqueue: O(1) (we save position last node of list)
    + dequeue: O(1) 
  + Queue: resizing array:
    + We keep elements in queue in middle of arrays, not at start either end.
    + Enqueue and dequeue have same complexity as stack
  + Generic: use parameter to specify type
  + Iterator: use a same interface for loop through any type of object which is implementation of Iterator
- Lec5: Simple Sorting algorithms (done)
  + Insertion sort and Selection sort: Report in [this file](src/Lec5/Report.md)
  + Shuffle algorithm
  + Exercise on HackerRank
- Lec6: Merge sort and Quick sort (done)
  + Sort2: Ex1, Ex2
  + Mergesort and Quicksort Implementation
  + Update report in [this file](src/Lec5/Report.md)
- Lec7: Priority queue (done)
  + Priority Queue Implementation
  + Sort2: all rest exercise in Sort2
- Lec8: Midterm exam: Prepare for test (Works on Leetcode):
  + Union - Find
- Lec9: Symbol table and BinaryTree
- Lec10: BinarySearchTree, BalancedSearchTree
- Lec11: Hash Table
- Lec12: Graph
- Lec13: Minium spanning tree
- Lec14: Shortest Path
- Lec15: Dynamic Programming, NP-Completeness
