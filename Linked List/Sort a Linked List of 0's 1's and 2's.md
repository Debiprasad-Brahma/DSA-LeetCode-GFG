# 🔄 Segregate 0s, 1s and 2s in a Linked List (Counting Approach | Java)

## Intuition

Since the linked list contains only three possible values (`0`, `1`, and `2`), we don't actually need to rearrange the nodes.  
A simpler idea is to **count how many times each value appears** and then overwrite the list accordingly.

So the plan is:
1. Traverse the list once to **count the number of `0`s, `1`s, and `2`s**.
2. Traverse the list again and **rewrite node values** based on the counts.

This approach works well because the set of values is limited to only three possibilities.

---

## Approach

1. Initialize three counters:
   - `c1` → number of `0`s  
   - `c2` → number of `1`s  
   - `c3` → number of `2`s  

2. Traverse the linked list and count occurrences of each value.

3. Traverse the list again:
   - Fill `0`s until `c1` becomes `0`
   - Then fill `1`s until `c2` becomes `0`
   - Finally fill `2`s

4. Return the head of the modified list.

This effectively sorts the list into: 0 → 0 → ... → 1 → 1 → ... → 2 → 2
---

## Complexity

- **Time complexity:**  
  $$O(n)$$  
  We traverse the list twice.

- **Space complexity:**  
  $$O(1)$$  
  Only a few counters are used.

---

## Code

```java
/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node segregate(Node head) {

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        Node temp = head;

        // Count number of 0s, 1s, and 2s
        while(temp != null){
            if(temp.data == 0) c1++;
            else if(temp.data == 1) c2++;
            else c3++;

            temp = temp.next;
        }

        temp = head;

        // Rewrite values based on counts
        while(temp != null){
            if(c1 > 0){
                temp.data = 0;
                c1--;
            }
            else if(c2 > 0){
                temp.data = 1;
                c2--;
            }
            else{
                temp.data = 2;
                c3--;
            }

            temp = temp.next;
        }

        return head;
    }
}
