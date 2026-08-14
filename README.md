# 🚀 Java DSA, Revision & Low-Level Design (LLD) Mastery

A comprehensive repository containing data structures, algorithms, pattern printing, core Java & OOP concepts, technical interview problems, and real-world Low-Level Design (LLD) projects with UML diagrams.

---

## 📌 Table of Contents

- [Overview](#-overview)
- [📁 Repository Structure](#-repository-structure)
- [🧠 Data Structures & Algorithms (DSA)](#-data-structures--algorithms-dsa)
  - [Arrays & Matrices (`ArrayAll.java`)](#arrays--matrices-arrayalljava)
  - [Linked Lists (`LinkedList.java` & `LRUCache.java`)](#linked-lists-linkedlistjava--lrucachejava)
  - [Stacks & Queues (`stacks.java` & `QueusAll.java`)](#stacks--queues-stacksjava--queusalljava)
  - [Trees & Binary Search Trees (`Trees.java` & `binarySearchTree.java`)](#trees--binary-search-trees-treesjava--binarysearchtreejava)
  - [Graphs (`graph.java` & `graph2.java`)](#graphs-graphjava--graph2java)
  - [Dynamic Programming (`dp.java`)](#dynamic-programming-dpjava)
  - [Greedy Algorithms (`greedyAlgorithm.java`)](#greedy-algorithms-greedyalgorithmjava)
  - [Sorting Algorithms (`sorting.java`)](#sorting-algorithms-sortingjava)
  - [Recursion & Backtracking (`Recursion.java`)](#recursion--backtracking-recursionjava)
  - [Strings (`StringAll.java`)](#strings-stringalljava)
  - [Bit Manipulation (`bitOpe.java`)](#bit-manipulation-bitopejava)
  - [Mathematics & Number Theory (`mathproblem.java`)](#mathematics--number-theory-mathproblemjava)
  - [Object-Oriented Programming (`oops.java`)](#object-oriented-programming-oopsjava)
- [📐 Low-Level Design (LLD) Projects](#-low-level-design-lld-projects)
- [🧩 Pattern Printing](#-pattern-printing)
- [💼 Interview Preparation & Revision](#-interview-preparation--revision)
- [💻 Getting Started](#-getting-started)

---

## ℹ️ Overview

This repository serves as an all-in-one resource for mastering **Java Programming**, **Data Structures & Algorithms**, **Competitive Coding**, and **System Design (LLD)**. Each module includes fully functional Java implementations, optimal time/space complexity approaches, and architectural UML diagrams for system design projects.

---

## 📁 Repository Structure

```text
java_rivision/
├── ArrayAll.java            # Comprehensive 50+ Array & 2D Matrix Algorithms
├── LinkedList.java          # Singly & Doubly Linked List Operations & Algorithms
├── LRUCache.java            # LRU Cache implementation (HashMap + Doubly LinkedList)
├── stacks.java              # Stack Data Structure & Classic Stack Problems
├── QueusAll.java            # Queue Implementation, Interleaving & Dual-Stack Queue
├── Trees.java               # Binary Tree Traversals, Height, Diameter, LCA, BFS
├── binarySearchTree.java    # BST Search, Insert, Delete, Balance & Range Queries
├── graph.java               # Graph Traversals (BFS/DFS), Cycle Detection, Topo Sort
├── graph2.java              # Dijkstra, Prim's, Kruskal's, Bellman-Ford, Kosaraju
├── dp.java                  # Dynamic Programming (Knapsack, LCS, Coin Change, MCM)
├── greedyAlgorithm.java     # Activity Selection, Fractional Knapsack, Job Sequencing
├── sorting.java             # Bubble, Selection, Insertion, Counting, Merge, Quick Sort
├── Recursion.java           # Subsets, Combination Sum, N-Queens, Backtracking
├── StringAll.java           # String Manipulations, Sliding Window, Anagrams
├── bitOpe.java              # Bitwise Manipulation Tricks & Exponentiation
├── mathproblem.java         # Prime Sieve, GCD/LCM, Armstrong, Digit Counting
├── oops.java                # OOP Principles: Inheritance, Polymorphism, Abstraction
├── practiceSet.java         # Mixed Problem Set for Speed & Accuracy Revision
├── revision.java            # Quick Cheatsheet & Code Snippets
├── Pattern/                 # Star & Number Pattern Printing Solutions
│   ├── Basic.java           # 15+ Pyramid, Diamond, Butterfly Patterns
│   └── README.md
├── interview/               # Technical Interview Coding Questions
│   └── interview.java
└── lld/                     # Low-Level System Design (LLD) Projects with UMLs
    ├── DocumentEditorClient/
    ├── Facade Design Pattern/
    ├── NotificationSystem/
    ├── SnakeAndLadder/
    ├── Tic Tac Toe/
    ├── ZeptoClone/
    └── paymentgateway/
```

---

## 🧠 Data Structures & Algorithms (DSA)

### Arrays & Matrices (`ArrayAll.java`)
- **Key Algorithms**: Second & Third Largest Element, Move Zeroes to End, Reverse Array, Missing Number ($1 \dots N$), Single Element (XOR), Kadane’s Algorithm (Max Subarray Sum), Two Sum (Brute Force & Hash Maps).
- **Two Pointers & Sliding Window**: Max Average Subarray ($K$), Majority Element (Boyer-Moore Voting $N/2$ & $N/3$), Rearrange Positives & Negatives, Subarray Sum Equals $K$.
- **2D Matrix Operations**: Spiral Matrix Traversal, Matrix Search (2D), Row with Maximum 1s, Pascal's Triangle.
- **Advanced Problems**: Stock Buy & Sell, Chocolate Distribution, Product of Array Except Self, Leader Elements, Equilibrium Index, Dutch National Flag Algorithm ($0, 1, 2$ sorting).

### Linked Lists (`LinkedList.java` & `LRUCache.java`)
- **Linked List Fundamentals**: Add First/Last/Index, Delete First/Last/Key, Length calculation, Iterative & Recursive Search.
- **Classic Algorithms**: Reversing a Linked List, Delete $N$-th Node from End, Midpoint (Slow & Fast Pointers), Floyd's Cycle Detection & Removal.
- **Advanced Operations**: Merge Two Sorted Lists, Merge Sort on Linked List, Segregate Even and Odd Nodes, Intersection Point of Two Linked Lists.
- **LRU Cache (`LRUCache.java`)**: $O(1)$ `get` and `put` implementation combining a `HashMap` and custom Doubly Linked List with dummy head/tail nodes.

### Stacks & Queues (`stacks.java` & `QueusAll.java`)
- **Stack Applications**: Valid Parentheses Matching, String Reversal, Next Greater Element, Previous Smaller Element, Min Stack implementation, Stock Span Problem.
- **Queue Applications**: First Non-Repeating Character in a Stream, Interleaving First Half with Second Half.
- **Cross Implementations**: Queue implementation using 2 Stacks, Stack implementation using 2 Queues.

### Trees & Binary Search Trees (`Trees.java` & `binarySearchTree.java`)
- **Binary Tree (`Trees.java`)**: Tree Construction from Preorder, Traversal (Preorder, Inorder, Postorder, Level-Order / BFS), Height & Depth, Total Node Count, Sum of Nodes, Tree Diameter ($O(N^2)$ and $O(N)$), Subtree Verification, Top View, $K$-th Level Traversal, Lowest Common Ancestor (LCA), Minimum Distance between Nodes.
- **Binary Search Tree (`binarySearchTree.java`)**: Insertion, Search, Deletion, Print in Range, Root-to-Leaf Paths, BST Validation, Sorted Array to Balanced BST, Mirror BST, BST to Sorted Doubly Linked List.

### Graphs (`graph.java` & `graph2.java`)
- **Basics (`graph.java`)**: Adjacency List Representation, Breadth-First Search (BFS), Depth-First Search (DFS), `hasPath` Verification, Cycle Detection (Undirected & Directed Graphs), Bipartite Graph Check, Topological Sort (DFS & Kahn’s BFS algorithm).
- **Advanced Graph Algorithms (`graph2.java`)**:
  - **Dijkstra's Algorithm**: Single-Source Shortest Path using Priority Queue.
  - **Prim's Algorithm**: Minimum Spanning Tree (MST).
  - **Kruskal's Algorithm**: MST using Disjoint Set Union (DSU).
  - **Bellman-Ford Algorithm**: Shortest Path with negative edge weights.
  - **Kosaraju's Algorithm**: Strongly Connected Components (SCC).

### Dynamic Programming (`dp.java`)
- **Core DP Patterns**: Memoization & Tabulation techniques.
- **Classic Problems**: Fibonacci Numbers, Climbing Stairs, 0/1 Knapsack Problem, Unbounded Knapsack, Subset Sum, Target Sum, Coin Change (Minimum Coins & Total Ways), Longest Common Subsequence (LCS), Edit Distance, Wildcard Matching, Matrix Chain Multiplication (MCM).

### Greedy Algorithms (`greedyAlgorithm.java`)
- **Problems Covered**: Activity Selection / Interval Scheduling, Fractional Knapsack, Minimum Absolute Difference Pairs, Max Length Chain of Pairs, Indian Coin Denomination Greedy Choice, Job Sequencing Problem with Deadlines, Chocola Problem (Min Cost to Cut Board).

### Sorting Algorithms (`sorting.java`)
- **Comparison & Non-Comparison Sorts**: Bubble Sort, Selection Sort, Insertion Sort, Counting Sort, Merge Sort (Divide & Conquer), Quick Sort (Lomuto/Hoare Partitioning).

### Recursion & Backtracking (`Recursion.java`)
- **Recursive Basics**: Factorial, Fibonacci, Power Function ($O(\log N)$).
- **Backtracking & Combinatorics**: All Subsets Generation, Combination Sum I & III, N-Queens Problem on $N \times N$ Chessboard.

### Strings (`StringAll.java`)
- **String Manipulations**: Two-Pointer String Reversal, Reverse Words in Sentence, Palindrome Verification, Anagram Checking, Frequency Counting, Remove Duplicates, Capitalize First Letters, Longest Word Identification, First Non-Repeating Character, Max Depth of Nested Parentheses, Longest Substring Without Repeating Characters (Sliding Window), Asterisk Removal.

### Bit Manipulation (`bitOpe.java`)
- **Operations & Tricks**: Bitwise AND, OR, XOR, Left Shift, Right Shift, Get Bit, Set Bit, Clear Bit, Update Bit, Clear $i$ Bits, Check Power of 2, Count Set Bits (Brian Kernighan's Algorithm), Fast Exponentiation ($O(\log N)$).

### Mathematics & Number Theory (`mathproblem.java`)
- Prime Number Check, Sieve of Eratosthenes, Euclidean Algorithm for GCD & LCM, Palindrome Number, Armstrong Number, Reverse Digits, Count Digits, Power Calculation, Factorial.

### Object-Oriented Programming (`oops.java`)
- Classes & Objects, Encapsulation, Inheritance (Single, Multilevel, Hierarchical), Polymorphism (Method Overloading & Overriding), Abstraction (Abstract Classes & Interfaces), Constructors & Constructor Overloading.

---

## 📐 Low-Level Design (LLD) Projects

Located under the `lld/` directory, these projects demonstrate object-oriented design principles, clean design patterns, and system architectures accompanied by UML diagrams:

| Project | Description | Key Features / Patterns | UML Diagram |
| :--- | :--- | :--- | :--- |
| **`DocumentEditorClient/`** | Rich Text Document Editor | Node hierarchy (Text/Image/Paragraph), Commands, Undo/Redo | `standardUml.png` |
| **`Facade Design Pattern/`** | Structural Design Pattern | Facade wrapper simplifying complex subsystem dependencies | `Standard UML.jpeg` |
| **`NotificationSystem/`** | Multi-Channel Notification Service | Email, SMS, Push Notification routing, Extensible Providers | `UML.png` |
| **`SnakeAndLadder/`** | Interactive Board Game Engine | Configurable grid, Snakes, Ladders, Dice rolling, Multi-player queue | `UML.jpeg` |
| **`Tic Tac Toe/`** | Extensible Tic-Tac-Toe Game | Flexible board size ($N \times N$), Dynamic piece symbols, Win checking | `UML.jpeg` |
| **`ZeptoClone/`** | Quick-Commerce Delivery Engine | Warehouse management, Inventory tracking, Order fulfillment, Payment integration | `UML.jpeg` |
| **`paymentgateway/`** | Multi-Mode Payment Gateway | UPI/Card/NetBanking routing, Retry logic, Transaction logger | `UML.jpeg` |

---

## 🧩 Pattern Printing

Located in `Pattern/Basic.java`:
- Star Pyramids & Inverted Pyramids
- Half Pyramids & Number Pyramids
- Floyd's Triangle & 0-1 Triangle
- Butterfly Pattern & Solid Rhombus
- Diamond Pattern & Palindromic Number Pyramids

---

## 💼 Interview Preparation & Revision

- **`interview/interview.java`**: Targeted coding round problems, boundary condition handling, and frequency-based interview questions.
- **`practiceSet.java`**: Curated mixed problem set for sharpening speed and problem-solving intuition.
- **`revision.java`**: High-yield summary snippets for fast pre-interview review.

---

## 💻 Getting Started

### Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher (JDK 17+ recommended).

### Compiling and Running
To compile and run any Java module:

```bash
# Clone the repository
git clone https://github.com/Satyam6201/JAVA.git
cd JAVA

# Compile a specific file (e.g., ArrayAll.java)
javac ArrayAll.java

# Run the compiled class
java ArrayAll
```

To run an LLD Project (e.g., Snake & Ladder):

```bash
# Navigate to the LLD project folder
cd lld/SnakeAndLadder

# Compile and Run
javac SnakeAndLadder.java
java SnakeAndLadder
```

---

## ⭐ Show Your Support

If you find this repository helpful for your Java learning, Data Structures revision, or System Design interview preparation, give it a ⭐ on GitHub!