package linkedlist;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 //leetcode2
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        ListNode d1=new ListNode(0);
        ListNode d2=new ListNode(0);
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;//基本步骤

        d1.next=l1;
        d2.next=l2;

        int carry=0;
        while(d1.next!=null || d2.next!=null || carry!=0){//!!!!bug:   || 最后carry!=0，还是要new 新的node

            if(d1.next!=null){
                carry+=d1.next.val;
                d1=d1.next;

            }

            if(d2.next!=null){
                carry+=d2.next.val;
                d2=d2.next;
            }

            ListNode newNode=new ListNode(carry%10);
            cur.next=newNode;
            cur=cur.next;
            carry=carry/10;
        }
        return dummy.next;

    }
}

/*
不用new 那么多dummy node的写法：
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

         int value=0;
        ListNode dummy=new ListNode(0);
        ListNode cur=dummy;


        while( l1!=null || l2!=null || value!=0){//bug1 如果l1，l2都走完了，那么value还剩，还是需要new listNode
             if(l1!=null){
                value+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                value+=l2.val;
                l2=l2.next;
            }

            //(7+8)%10=5

              //  value%=10;   bug2:这里改变了value
                ListNode newNode=new ListNode(value%10);
                cur.next=newNode;
                cur=cur.next;

                value/=10;  //1

        }
        return dummy.next;

    }
}
*/

