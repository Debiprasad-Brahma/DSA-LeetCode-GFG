# Power of Four

## Problem Statement
Given an integer `n`, determine if it is a **power of four**.  
A number is considered a power of four if it can be expressed as `4^k` where `k` is a non-negative integer.

---

## Input Format
- An integer `n`

## Output Format
- `true` → if `n` is a power of four  
- `false` → otherwise

---

## Examples

### Example 1
**Input:**  
```
n = 16
```
**Output:**  
```
true
```
**Explanation:**  
`16 = 4^2`, so it is a power of four.

---

### Example 2
**Input:**  
```
n = 5
```
**Output:**  
```
false
```
**Explanation:**  
`5` cannot be expressed as `4^k` for any integer `k`.

---

### Example 3
**Input:**  
```
n = 1
```
**Output:**  
```
true
```
**Explanation:**  
`1 = 4^0`, which is a valid power of four.

---

## Intuition
If a number is a power of four:
- It must be **positive**.
- Repeatedly dividing it by `4` should eventually give `1`.
- If at any point it is **not divisible by 4**, then it cannot be a power of four.

We can check this in **three ways**:
1. **Recursive approach** — keep dividing by 4 until reaching 1.  
2. **Iterative approach** — loop until `n` becomes 1.  
3. **Bitwise approach** — powers of four have only one `1` bit at an odd position.

---

## Approach 1: Recursive

### Dry Run (n = 16)
1. `n = 16` → divisible by 4 → call with `n = 4`.
2. `n = 4` → divisible by 4 → call with `n = 1`.
3. `n = 1` → return `true`.

### Dry Run (n = 5)
1. `n = 5` → not divisible by 4 → return `false`.

### Dry Run (n = 1)
1. `n = 1` → return `true`.

```java
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;  // 0 is not a power of four
        if (n == 1) return true;   // 4^0 = 1
        if (n % 4 == 0) return isPowerOfFour(n / 4);
        return false;              // not divisible by 4
    }
}
```
**Time Complexity:** `O(log₄n)`  
**Space Complexity:** `O(log₄n)`

---

## Approach 2: Iterative

### Dry Run (n = 16)
- Loop 1: `n = 16` → divisible by 4 → `n = 4`.
- Loop 2: `n = 4` → divisible by 4 → `n = 1`.
- Exit loop → `n == 1` → return `true`.

### Dry Run (n = 5)
- Loop 1: `n = 5` → not divisible by 4 → exit loop.
- `n != 1` → return `false`.

### Dry Run (n = 1)
- Skip loop → `n == 1` → return `true`.

```java
class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }
}
```
**Time Complexity:** `O(log₄n)`  
**Space Complexity:** `O(1)`  

---

## Approach 3: Bitwise (Most Efficient)

### Dry Run (n = 16 → 10000 in binary)
1. `n > 0` → true.
2. `(n & (n - 1)) == 0` → ensures only one bit set (`10000 & 01111 = 0`).
3. `(n & 0x55555555) != 0` → checks if the set bit is in an odd position → true.
4. Return `true`.

### Dry Run (n = 5 → 101 in binary)
1. `(n & (n - 1)) != 0` → fails (more than one bit set) → false.

### Dry Run (n = 1 → 1 in binary)
1. Positive, power of two, and in correct bit position → true.

```java
class Solution {
    public boolean isPowerOfFour(int n) {
        return n > 0 &&
               (n & (n - 1)) == 0 &&
               (n & 0x55555555) != 0;
    }
}
```
**Time Complexity:** `O(1)`  
**Space Complexity:** `O(1)`

---

## Comparison of Approaches

| Approach   | Time Complexity | Space Complexity | Notes |
|------------|----------------|------------------|-------|
| Recursive  | O(log₄n)       | O(log₄n)         | Simple to understand but uses stack space |
| Iterative  | O(log₄n)       | O(1)             | No recursion overhead |
| Bitwise    | O(1)           | O(1)             | Most optimal for large numbers |

---
