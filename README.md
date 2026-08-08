# ⚡ DSA Patterns Java (`dsa-patterns-java`)

![Java](https://img.shields.io/badge/Java-21-orange.svg?style=for-the-badge&logo=java)
![Build](https://img.shields.io/badge/Build-Maven-blue.svg?style=for-the-badge&logo=apachemaven)
![Focus](https://img.shields.io/badge/Focus-DSA%20Patterns%20%26%20Interview%20Prep-green.svg?style=for-the-badge)
![Author](https://img.shields.io/badge/Author-Raman--8688-purple.svg?style=for-the-badge)

A comprehensive, pattern-driven Data Structures & Algorithms (DSA) repository written in **Java 21**. This repository goes beyond simple code solutions by providing **dual-approach implementations (Brute Force vs. Optimal)**, **detailed runtime markdown notes**, and **module-wise 5-minute revision cheat sheets** equipped with mental tricks for fast recall.

---

## 🎯 Main Motive & Philosophy

Solving 500+ random LeetCode problems without structure leads to quick memory decay and slow interview preparation. This project is built around **Pattern Recognition**:

1. **Master the Underlying Pattern**: Learn *why* a pattern works rather than memorizing individual solutions.
2. **Dual-Approach Paradigm**: Every concept provides both **Brute-Force ($O(n^2)$)** and **Optimal ($O(n)$ or $O(\log n)$)** implementations to understand trade-offs.
3. **Runtime Notes & Intuition**: Every topic has a matching `.md` document containing problem statements, algorithm breakdowns, step-by-step dry runs, and **🔑 Mental Tricks**.
4. **5-Minute Flash Revision**: Module-wise `README.md` files allow reviewing 10+ problems in under 5 minutes before technical interviews.

---

## 📂 Repository Structure

```text
dsa-patterns-java/
├── pom.xml                                   # Maven Build Configuration (Java 21)
├── src/main/java/com/raman/dsa/              # Runnable Java Implementations
│   ├── arrays/
│   │   ├── two_pointers/                     # Two Pointers Java Solutions
│   │   ├── sliding_window/                   # Sliding Window Java Solutions
│   │   ├── prefix_sum/                       # Prefix Sum Java Solutions
│   │   └── kadane/                           # Kadane's Algorithm Java Solutions
│   ├── binary_search/
│   │   ├── classsic_binary_search/           # Classic Binary Search Java Solutions
│   │   └── lowerbound_upperbound/            # Lower & Upper Bound Java Solutions
│   └── strings/
│       ├── twopointers/                      # String Two Pointers Solutions
│       └── slidingwindow/                    # String Sliding Window Solutions
└── notes/                                    # Markdown Notes & Revision Guides
    ├── README.md                             # Master Revision Hub
    ├── arrays/
    │   ├── two-pointers/                     # Notes + Module README.md
    │   ├── sliding-window/                   # Notes + Module README.md
    │   ├── prefix-sum/                       # Notes + Module README.md
    │   └── kadane/                           # Notes + Module README.md
    ├── binary-search/                        # Notes + Module README.md
    └── strings/                              # Notes + Module README.md
```

---

## 📚 Modules & Revision Cheat Sheets

Click on any module below to access the **Quick Revision Guide**:

| Module Pattern | Core Motive & Technique | Topics Covered | Revision Guide |
| :--- | :--- | :--- | :---: |
| **Two Pointers** | Opposite & Same-direction pointer movements to eliminate $O(n^2)$ loops | Two Sum II, Move Zeroes, Sort Colors (Dutch Flag), 3Sum, Container Water, Trapping Rain Water | [📖 Read Guide](./notes/arrays/two-pointers/README.md) |
| **Sliding Window** | Dynamic & Fixed subarray boundaries for contiguous sequence problems | Max Sum Subarray, Max Consecutive Ones (I & III), Min Subarray Sum, Product < K, Fruits Basket, K Distinct, Sliding Window Max | [📖 Read Guide](./notes/arrays/sliding-window/README.md) |
| **Prefix Sum** | Cumulative totals & HashMap state tracking for range & sum queries | Pivot Index, Product Except Self, Subarray Sum = K, Continuous Subarray Sum, Divisible by K, Matrix Block Sum (2D) | [📖 Read Guide](./notes/arrays/prefix-sum/README.md) |
| **Kadane's Algorithm** | Dynamic greedy decision making on contiguous subarray optimization | Maximum Subarray Sum, Maximum Product Subarray, Circular Max Subarray, Max Absolute Sum, Kth Largest Subarray Sum | [📖 Read Guide](./notes/arrays/kadane/README.md) |
| **Binary Search** | Logarithmic $O(\log n)$ search space reduction on monotonic boundaries | Target Search, Insert Position, Sqrt, Rotated Array Search, Min in Rotated, Peak Element, Ceiling, Floor, First/Last Position, Kth Rotation | [📖 Read Guide](./notes/binary-search/README.md) |
| **Strings** | String windowing & character frequency arrays (`int[128]`) | Reverse String, Valid Palindromes (I & II), Longest Palindromic Substring, Non-Repeating Substring, Anagrams, Minimum Window Substring, Concatenated Words | [📖 Read Guide](./notes/strings/README.md) |

---

## 🔑 Key Features of Each Problem Note

Each `.md` document inside the `notes/` folder follows a standardized structure:
1. **Problem Statement & Constraints**
2. **Brute Force Approach**: Algorithm, Complexity ($O(n^2)$), and Dry Run.
3. **Optimal Approach**: Algorithm, Complexity ($O(n)$ or $O(\log n)$), and Dry Run.
4. **Complete Java Source Code**: Runnable class matching `src/main/java`.
5. **🔑 Mental Trick**: Real-world analogy / intuitive trigger for instant memory retrieval during interviews.

---

## 🛠️ How to Build & Run Locally

### Prerequisites
- **Java Development Kit (JDK)**: Version 21 or higher
- **Apache Maven**: Version 3.8+

### 1. Clone the Repository
```bash
git clone https://github.com/Raman-8688/dsa-patterns-java.git
cd dsa-patterns-java
```

### 2. Compile the Project using Maven
```bash
mvn clean compile
```

### 3. Run Any Java Program directly
```bash
# Example: Run Ceiling in Sorted Array
java -cp target/classes com.raman.dsa.binary_search.lowerbound_upperbound.CeilingInSortedArray

# Example: Run Trapping Rain Water
java -cp target/classes com.raman.dsa.arrays.two_pointers.TrappingRainWater

# Example: Run Minimum Window Substring
java -cp target/classes com.raman.dsa.strings.slidingwindow.MinimumWindowSubstring
```

---

## 👤 Author

Developed and maintained by **Boya Ramanjaneyulu** ([@Raman-8688](https://github.com/Raman-8688)).  
*Dedicated to mastering Data Structures & Algorithms with clean code and intuitive pattern notes.*

---

⭐ **If you find this repository helpful, consider giving it a star on GitHub!**
