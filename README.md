# Data Structure
DataStructure is way of organizing data more effectively and efficiently.

There are different types of data structures which are commonly used.

## Types of Data Structures
* Linear data structures
* Non-Linear data structures

## Commonly used Data Structures
* [Array](#array)
* [LinkedList](#linkedlist)
* [BinaryTrees](#binarytrees)
* [Strings](#strings)
* [Tries](#tries)
* [Graphs](#graphs)

## Array
Array is a linear data structure. Array is a collection of variables/items of similar data type. In array, the elements are stored at contagious memory locations.

<img src="https://cdncontribute.geeksforgeeks.org/wp-content/uploads/array-2.png?raw=true">

### Advantage of arrays
* **Random Access**: Easy to access data elements randomly.
* **Sorting** and **retrieving** particular data can be done efficiently.
* Arrays have better **cache** locality and increases the performance.

### Disadvantages of arrays
* **Limited Size**: The size of the array is limited, i.e. it is of fixed size. Once the length of the array is defined it cannot be changed.

#### Representation of array in java
```
int[] array = new int[ARRAY_LENGTH];
int[] array = {10,20,30,40};
```

## Binary Trees
Trees are non-linear data structures. A tree whose elements have two at most 2 children is called binary tree. The top most element of the tree is called **Root Node** or **Parent Node**.
The node which is present left of the root node is called **Left Child** and the node which is present right of the root node is called **Right Child**.

A node which doesnt have any children are called as **Leaf Node**.

Each left node is a left sub tree of the root node and each right node is a right sub tree of the root node.

The Tree conenctions are called as **Branches**.

Trees are mainly used to store data in hierarchical form.


<img src="https://cdn-images-1.medium.com/max/1400/1*UjSfPoMwCEkke1_iuNZ1EQ.jpeg?raw=true">


**NOTE**: Any tree can be a binary tree if each node has only two child nodes. It’s the ordering of nodes that makes a binary tree searchable and, by extension, what makes it so powerful.


## Sorting
Sorting algorithms is classifed into two types
* Comparison based
* Non-Comparison based

### Comparison based
* In this type, sorting is performed by comparing the comparing the input elements.
* Examples of comparison based sorting are
  * Bubble sort
  * Selction sort
  * Insertion sort
  * Merge Sort
  * Quick sort
  * Heap sort

### Non-Comparison based
* In this type, sorting is performed by considering other info like keys to perform the sorting.
* Examples of non-comparison based sorting are
  * Radix sort
  * Count Sort
  * Bucket Sort

### Properties of sorting on which they are compared
* **Time Complexity** - Time Complexity is the running time of the sorting algorithms. The time complexity is calculated as best case, average case, worst case.
* **Auxillary Space Complexity** - Auxillary Space Complexity is the extra space used in the algorithms other than the input space.
* **Online** - If an algorithm is online it means that we dont have to give all the data before hand. It means if we add more data when the algorithm is running then the algorithm will continue as it is without getting disturbed and gives the correct output.
* **Stability** - An sorting algorithm is said to be stable when array maintains the duplicate elemets in the same inserted order even after sorting.
* **InPlace** - If the algorithm is inplace it will not take any extra space that means the auxillary space complexity will be O(1).

### Comparison based Cheat Sheet 

| Sort | Best TC |Avg TC | Worst Case | Aux. Space Complexity|Online|Stable|Inplace| 
| ------------- | ------------- |------------- | ------------- |------------- | ------------- |------------- | ------------- |
| Bubble  | n  |n<sup>2</sup> | n<sup>2</sup>  |O(1)  | &cross;  |&check;  | &check;  |
| Selection  | n<sup>2</sup>  |n<sup>2</sup>  | n<sup>2</sup>  |O(1)  | &cross;  |&cross;  | &check;  |
| Insertion  |  n   |n<sup>2</sup>  | n<sup>2</sup>  |O(1)  | &check;  |&check;  | &check;  |
| Merge  | nlog(n)  |nlog(n)  | nlog(n)  |O(n)  | &cross;  |&check;  | &cross;  |
| Quick  | nlog(n)  |nlog(n)  | n<sup>2</sup>  |O(1)  | &cross;  |&cross;  | &check;  |
| Heap  | nlog(n)  |nlog(n)  | nlog(n)  |O(1)  | &cross; |&cross;  | &check;  |

## Amortized Time
* Amortized time is the way to express the time complexity.
* When an algorithm has a very bad time complexity once in a while, besides the time complexity that happens most of the time.
* An example for this is the ArrayList which contains an array that can be extended.
* When ArrayList hits the array capacity in it, then it create a new array with the doubled size of the old array and copy all the items in the old array to the new array. In ArrayList, two time complexities exist; one is O(1) and the other is O(n).
