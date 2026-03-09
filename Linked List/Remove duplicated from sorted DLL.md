# 🔗 Remove Duplicates from a Sorted Linked List (Java)

## Intuition

Since the linked list is **already sorted**, any duplicate values will always appear **next to each other**.  
This property allows us to remove duplicates easily by comparing each node with its next node.

If two consecutive nodes contain the same value, we can simply **skip the duplicate node** by adjusting the `next` pointer.

---

## Approach

1. Handle edge cases:
   - If the list is empty or contains only one node, return the head since there are no duplicates.

2. Use a pointer `curr` starting from the head.

3. Traverse the list while `curr.next` is not `null`:
   - If `curr.data == curr.next.data`
     - Skip the duplicate node by updating:
       ```
       curr.next = curr.next.next
       ```
   - Otherwise, move `curr` to the next node.

4. Continue this process until the end of the list.

Because the list is sorted, removing duplicates this way ensures each value appears only once.

---

## Complexity

- **Time complexity:**  
  $$O(n)$$  
  We traverse the linked list once.

- **Space complexity:**  
  $$O(1)$$  
  No additional memory is used.

---

## Code

```java
/********************************************************

    Following is the class structure of the Node class:
    
    class Node
    {
        public:
            int data;
            Node next;
            Node(int data)
            {
                this.data = data;
                this.next = null;
            }
    };

********************************************************/

public class Solution {
    public static Node uniqueSortedList(Node head) {

        if(head == null || head.next == null) return head;

        Node curr = head;

        while(curr.next != null){
            if(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }

        return head;
    }
}
