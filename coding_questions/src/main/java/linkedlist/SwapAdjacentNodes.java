package linkedlist;

public class SwapAdjacentNodes {

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            this.data = d;
        }
    }

    public static Node swapPairs(Node head) {
        // Create a dummy node to handle edge cases easily
        Node dummy = new Node(0);
        dummy.next = head;
        Node current = dummy;
        
        while (current.next != null && current.next.next != null) {
            // Nodes to be swapped
            Node first = current.next;
            Node second = current.next.next;
            
            // Swapping
            first.next = second.next;
            second.next = first;
            current.next = second;
            
            // Move to the next pair
            current = current.next.next;
        }
        
        return dummy.next;
    }
    
    // Utility method to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    // Main method with test cases
    public static void main(String[] args) {
        // Test Case 1: 1->2->3->4
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        
        System.out.println("Original List 1:");
        printList(head1);
        
        head1 = swapPairs(head1);
        System.out.println("After swapping adjacent nodes:");
        printList(head1);
        
        // Test Case 2: 1->2->3->4->5
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        
        System.out.println("\nOriginal List 2:");
        printList(head2);
        
        head2 = swapPairs(head2);
        System.out.println("After swapping adjacent nodes:");
        printList(head2);
        
        // Test Case 3: Single node
        Node head3 = new Node(1);
        
        System.out.println("\nOriginal List 3:");
        printList(head3);
        
        head3 = swapPairs(head3);
        System.out.println("After swapping adjacent nodes:");
        printList(head3);
    }

    
}
