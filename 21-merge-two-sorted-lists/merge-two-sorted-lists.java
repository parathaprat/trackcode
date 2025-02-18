/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        //using a temp node to store head's position (we return temp.next)
        ListNode temp = new ListNode(0);

        //current node tracker
        ListNode currentNode = temp;

        while(list1 != null && list2 != null){

            //append smaller value 
            if(list1.val < list2.val){

                currentNode.next = list1;
                list1 = list1.next;

            }
            else{

                currentNode.next = list2;
                list2 = list2.next;

            }

            currentNode = currentNode.next;
        }

        while(list1 != null){

            currentNode.next = list1;
            list1 = list1.next;
            currentNode = currentNode.next;

        }

        while(list2 != null){

            currentNode.next = list2;
            list2 = list2.next;
            currentNode = currentNode.next;
            
        }

        return temp.next;

    }
}