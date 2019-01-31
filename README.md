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

Each left node is a left sub tree of the root node and each right node is a right sub tree of the root node.


<img src="https://cdn-images-1.medium.com/max/1400/1*UjSfPoMwCEkke1_iuNZ1EQ.jpeg?raw=true">


**NOTE**: Any tree can be a binary tree if each node has only two child nodes. It’s the ordering of nodes that makes a binary tree searchable and, by extension, what makes it so powerful.


