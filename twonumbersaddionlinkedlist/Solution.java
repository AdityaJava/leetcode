package leetcode.twonumbersaddionlinkedlist;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String number1 = (getReverseStringFromLL(l1));
        String number2= (getReverseStringFromLL(l2));
        String number3 = addStrings(number1,number2);
        // System.out.println("number3"+number3);
        // StringBuilder sb = new StringBuilder(s);
        // s = sb.reverse().toString();
        return createListNodeFromNumber(number3);
    }
    public String addStrings(String number1, String number2){
        List<String> s1 = Arrays.asList(number1.split(""));
        List<String> s2 = Arrays.asList(number2.split(""));
        Integer carry = 0;
        Integer n1=0,n2=0,n3=0;
        String temp = new String();
        if(s1.size()>=s2.size()){
            for(int i=(s1.size()-1), k=(s2.size()-1); i>=0 || k>=0;i--,k--){
                if(k>=0){
                    n1 = Integer.valueOf(s1.get(i));
                    n2 = Integer.valueOf(s2.get(k));
                    n3 = n1 + n2 + carry;
                    carry = n3 / 10;
                    n3 = n3 % 10;
                    temp = temp+n3;
                }else{
                    n1 = Integer.valueOf(s1.get(i));
                    n3 = n1 + carry;
                    carry = n3 / 10;
                    n3 = n3 % 10;
                    temp = temp+n3;
                }
            }
        }
        else{
            for(int i=(s2.size()-1), k=(s1.size()-1); i>=0 || k>=0;i--,k--){
                if(k>=0){
                    n1 = Integer.valueOf(s1.get(k));
                    n2 = Integer.valueOf(s2.get(i));
                    n3 = n1 + n2 + carry;
                    carry = n3 / 10;
                    n3 = n3 % 10;
                    temp = temp+n3;
                }else{
                    n1 = Integer.valueOf(s2.get(i));
                    n3 = n1 + carry;
                    carry = n3 / 10;
                    n3 = n3 % 10;
                    temp = temp+n3;
                }
            }
        }
        if(carry!=0){
            temp= temp + carry;
        }
        return temp;
    }
    public String getReverseStringFromLL(ListNode l1){
        ListNode tempNode = l1;
        String s =  new String();
        while(tempNode!=null){
            s = s + String.valueOf(tempNode.val);
            tempNode = tempNode.next;
        }
        StringBuilder sb = new StringBuilder(s);
        return new String(sb.reverse());
    }
    public ListNode createListNodeFromNumber(String number){
        List<String> stringList = Arrays.asList(number.split(""));
        ListNode rootNode = null;
        ListNode tempNode = new ListNode();
        for(String e : stringList){
            if(rootNode==null){
                rootNode = new ListNode();
                rootNode.val = Integer.parseInt(e);
                tempNode = rootNode;
            }
            else{
                tempNode.next = new ListNode();
                tempNode = tempNode.next;
                tempNode.val = Integer.parseInt(e);
            }
        }
        ListNode ln = rootNode;
        return rootNode;
    }

}