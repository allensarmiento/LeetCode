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
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode head = list1;
        ListNode follow = null;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                follow = list1;
                list1 = list1.next;
            } else {
                if (list1 == head) {
                    ListNode temp = list2.next;
                    head = list2;
                    follow = head;
                    list2.next = list1;
                    list2 = temp;
                } else {
                    ListNode temp = list2.next;
                    follow.next = list2;
                    list2.next = list1;
                    follow = list2;
                    list2 = temp;
                }
            }
        }
        
        if (list2 != null) {
            follow.next = list2;
        }
        
        return head;
    }
}