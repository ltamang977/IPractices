package org.lv.ipractices.ctci._2_linkedlists;

/**
 * Created by root on 12/31/17.
 */
public class _5_AddTwoNumbers {


    //in list 0's element is in first i.e head, 1's in next
    public static LinkedList addNumbers(LinkedList nbr1, LinkedList nbr2){

        int carry = 0;
        Node nbr1Current = nbr1.getFirst();
        Node nbr2Current = nbr2.getFirst();

        LinkedList result = new LinkedList();


        while(nbr1Current!=null || nbr2Current!=null){

            int digit1 = (nbr1Current!=null)?nbr1Current.data:0;
            int digit2 = (nbr2Current!=null)?nbr2Current.data:0;
            int sum = digit1+digit2+carry;

            String sumStr = String.valueOf(sum);
            if(sumStr.length()==1){
                result.insert(sum);
                carry = 0;
            }else {
                result.insert(Integer.parseInt(String.valueOf(sumStr.charAt(1))));
                carry=Integer.parseInt(String.valueOf(sumStr.charAt(0)));
            }
            nbr1Current=(nbr1Current!=null)?nbr1Current.next:null;
            nbr2Current=(nbr2Current!=null)?nbr2Current.next:null;
        }

        return result;
    }


    //method to handle 0's at tail
    // odo padding to handle uneven length number
    public static int sum(Node nbr1, Node nbr2, LinkedList result){
        if(nbr1==null && nbr2==null){
            return 0;
        }

        int digit1 = (nbr1!=null)?nbr1.data:0;
        int digit2 = (nbr2!=null)?nbr2.data:0;
        int carry = sum((nbr1!=null)?nbr1.next:null, (nbr2!=null)?nbr2.next:null, result);

        int sum = digit1+digit2+carry;

        result.prepend(new Node(sum%10));

        return (sum>=10)?1:0;//carr

    }

    public static void main(String[] args){

        LinkedList nbr1 = new LinkedList();
        nbr1.insert(2);
        nbr1.insert(6);
        nbr1.insert(1);
        nbr1.insert(7);
        nbr1.print();

        LinkedList nbr2 = new LinkedList();
        nbr2.insert(5);
        nbr2.insert(9);
        nbr2.insert(5);
        nbr2.print();


       // LinkedList result = addNumbers(nbr1, nbr2);
       // result.print();

        LinkedList result = new LinkedList();
        int count = sum(nbr1.getFirst(), nbr2.getFirst(), result);
        if(count!=0)
            result.prepend(new Node(count));

        result.print();


    }
}
