// Project: A simple Java object used to test Linked List deletion methods w nodes
// By: Cameron Beanland (intellij always telling me my name is a typo 😭)
// Date: Feb 3rd, 2025

public class LinkedList {
    Node head; // Head of the list

    static class Node { // originally had this as a normal class, but changed to static to prevent any errors
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* ============================================= */
    // NODE DELETE METHOD VIA KEY
    void deleteNode(int key) {
        Node temp = head, prev = null;

        // CASE 1: used when list is empty
        if (temp == null) {
            System.out.println("List is empty. Reduced to ashes.");
            return;
        }

        // CASE 2: delete at beginning (head)
        if (head.data == key) {
            head = head.next;
            return;
        }

        // search for key to be deleted
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // CASE 3: occurs when key is not found in list
        if (temp == null) {
            System.out.println("Key " + key + " is lost to the abyss.");
            return;
        }

        // CASE 4: unlink node from list
        prev.next = temp.next;
    }

    /* ============================================= */
    // UTIL FUNCTION METHOD, USE TO INSERT NEW NODE AT FRONT
    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // util function to print linked list
    public void printList() {
        Node tnode = head;
        if (tnode == null) {
            System.out.println("The list is empty. ");
            return;
        }

        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.println();
    }

    /* ============================================= */
    // DRIVER METHOD USED FOR TESTING PURPOSES
    public static void main(String[] args) {
        LinkedList llist = new LinkedList(); // used llist because im lazy, easier to write out lol

        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);

        System.out.println("Created linked list:");
        llist.printList();

        llist.deleteNode(1);

        System.out.println("Linked list after deletion of 1:");
        llist.printList();

        llist.deleteNode(10); // test deletion of non-existing element
        llist.deleteNode(7);  // test deletion of last element
        llist.deleteNode(2);  // test  deletion of head
        llist.deleteNode(3);  // test deletion until list is empty
        llist.printList();     // should print empty message??
    }
}

// if everything works out, code should produce the following:

/*
Created linked list:
2 3 1 7
Linked list after deletion of 1:
2 3 7
Key 10 is lost to the abyss.
The list is empty.

Process finished with exit code 0
 */

// if not then i failed