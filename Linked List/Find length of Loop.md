# 🔁 Length of Loop in a Linked List (Floyd’s Cycle Detection | Java)

## Intuition

If a linked list contains a loop, two pointers moving at different speeds will eventually meet inside the cycle.  
This idea comes from **Floyd’s Cycle Detection Algorithm (Tortoise and Hare)**.

- The **slow pointer** moves one step at a time.
- The **fast pointer** moves two steps at a time.

If a loop exists, they will eventually meet. Once the meeting point is found, we can determine the **starting point of the loop** by resetting one pointer to the head and moving both pointers one step at a time.

After reaching the start of the loop, we can traverse the cycle once to **count the number of nodes inside the loop**, which gives us the loop length.

---

## Approach

1. Initialize two pointers:
   - `slow` → moves one step
   - `fast` → moves two steps

2. Traverse the list:
   - If `slow == fast`, a cycle is detected.

3. To find the start of the loop:
   - Reset one pointer (`temp`) to `head`.
   - Move both pointers one step at a time until they meet.

4. Once the starting node of the loop is found:
   - Traverse the loop once and count the number of nodes until reaching the same node again.

5. Return the count.

If no cycle exists, return `0`.

---

## Complexity

- **Time complexity:**  
  $$O(n)$$  
  The list is traversed at most a few times.

- **Space complexity:**  
  $$O(1)$$  
  Only a few pointers are used.

---

## Code

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
    public int lengthOfLoop(Node head) {
        
        if(head == null) return 0;
        
        int count = 0;
        
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                Node temp = head;
                
                // Find start of loop
                while(temp != slow){
                    temp = temp.next;
                    slow = slow.next;
                }
                
                // Count loop length
                count = 1;
                temp = temp.next;
                
                while(temp != slow){
                    count++;
                    temp = temp.next;
                }
                
                return count;
            }
        }
        
        return 0;
    }
}
