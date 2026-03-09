# 🗑 Delete All Occurrences of a Given Key in a Doubly Linked List (Java)

## Intuition

In a **doubly linked list**, each node has two pointers:
- `next` → points to the next node
- `prev` → points to the previous node

To delete a node, we must **update both connections**:
- The previous node should point to the next node.
- The next node should point back to the previous node.

While traversing the list, whenever we find a node whose value equals `k`, we adjust these pointers to remove that node from the list.

Special care is required when the node to delete is the **head**, because there is no previous node.

---

## Approach

1. Start traversing the list using a pointer `curr`.
2. For each node:
   - If `curr.data == k`, remove the node by adjusting pointers.
3. Handle two cases carefully:
   - If `curr.prev != null`  
     → update `curr.prev.next = curr.next`
   - If `curr.prev == null`  
     → the node is the **head**, so move `head` to `head.next`.
4. If `curr.next != null`, update the backward pointer:

curr.next.prev = curr.prev

5. Continue traversal until the end of the list.
6. Return the updated `head`.

This removes **all occurrences of `k`** from the doubly linked list.

---

## Complexity

- **Time complexity:**  
$$O(n)$$  
We traverse the list once.

- **Space complexity:**  
$$O(1)$$  
No additional data structures are used.

---

## Code

```java
/****************************************************************

Following is the class structure of the Node class:

class Node {
  public int data;
  public Node next;
  public Node prev;

  Node()
  {
      this.data = 0;
      this.next = null;
      this.prev = null;
  }
  Node(int data)
  {
      this.data = data;
      this.next = null;
      this.prev = null;
  }
  Node(int data, Node next, Node prev)
  {
      this.data = data;
      this.next = next;
      this.prev = prev;
  }
}

*****************************************************************/

public class Solution {
 public static Node deleteAllOccurrences(Node head, int k) {

     if(head == null) return null;

     Node curr = head;

     while(curr != null){
         if(curr.data == k){

             if(curr.prev != null){
                 curr.prev.next = curr.next;
             }
             else{
                 head = head.next;
             }

             if(curr.next != null){
                 curr.next.prev = curr.prev;
             }
         }

         curr = curr.next;
     }

     return head;
 }
}
