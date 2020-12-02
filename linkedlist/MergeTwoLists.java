package linkedlist;

public class MergeTwoLists {
    //solution1: recursively
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null) return l2;
        if(l2==null) return l1;
        //子问题：
        if(l1.val<l2.val){//就可以确定当前是l1
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    //solution2:
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if(l1==null) return l2;
//         if(l2==null) return l1;
//         //1-1-2
//         ListNode dummy=new ListNode(0);
//         ListNode cur=dummy;
//         while(l1!=null && l2!=null){
//             if(l1.val<l2.val){
//                 cur.next=l1;
//                 cur=cur.next;
//                 l1=l1.next;
//             }else{
//                 cur.next=l2;
//                 cur=cur.next;
//                 l2=l2.next;
//             }
//         }

//         if(l1!=null){
//             cur.next=l1;
//         }
//         if(l2!=null){
//             cur.next=l2;
//         }

//         return dummy.next;

//     }
}