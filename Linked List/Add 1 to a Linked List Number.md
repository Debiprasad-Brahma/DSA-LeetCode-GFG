# GFG QUESTION - Add 1 to a Linked List Number
## 🧠 Intuition  
The problem gives a number represented as a **linked list**, where each node stores a single digit.  
We must add one to this number and return the resulting list.  

Since addition starts from the least significant digit (the end of the list), reversing the list allows us to perform the addition easily, without recursion or stack usage.

---

## 💡 Approach  
1. **Reverse the list** — so we start from the least significant digit.  
2. Initialize a carry as `1` (since we’re adding one).  
3. Traverse the list:
   - Add `carry` to the current node’s data.  
   - Update the current node’s value as `sum % 10`.  
   - Update the carry as `sum / 10`.  
   - If carry becomes 0, we can stop early.  
4. If the loop ends and carry is still nonzero (e.g., in `999 → 1000`), add a new node for the remaining carry.  
5. **Reverse the list again** to restore the original order.  
6. Return the head of the new list.

---

## ⏱️ Complexity  
- **Time Complexity:** `O(n)` — each node is visited twice (for two reversals and one traversal).  
- **Space Complexity:** `O(1)` — done in-place using only constant extra memory.

---

## 🧩 Code  
```java
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    Node reverse(Node head) {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addOne(Node head) {
        // Step 1: Reverse the list
        head = reverse(head);
      
        Node prev = null;
        Node temp = head;
        int carry = 1;

        // Step 2: Add one and handle carry
        while (temp != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            carry = sum / 10;

            if (carry == 0) break;

            if (temp.next == null && carry > 0) {
                temp.next = new Node(carry);
                carry = 0;
                break;
            }

            temp = temp.next;
        }

        // Step 3: Reverse back to restore order
        head = reverse(head);
        return head;
    }
}
