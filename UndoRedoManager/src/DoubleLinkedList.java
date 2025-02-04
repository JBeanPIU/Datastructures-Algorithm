// Project: A double linked list class used to create undo/redo methods, meant to be an extension of UndoRedoManager
// By: Cameron Beanland
// Date: Feb. 4th, 2025

public class DoubleLinkedList<T> {
    private class Node {
        // a node class representing elements in the list with data and links to previous/next nodes
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head; // this is the first node in the list
    private Node tail; // and this is the last
    private Node currentState; // pointer that refers to the current state of the node

    public DoubleLinkedList() {
        head = null;
        tail = null;
        currentState = null;
    }

    /* ==================================================== */
    // ADD NEW STATE TO LIST; this method creates a new node and links it to the current state
    public void addState(T newState) {
        Node newNode = new Node(newState);
        if (head == null) {
            head = tail = currentState = newNode; // if list is empty, sets new node as head, tail, and current state
        } else {
            newNode.prev = currentState;
            if (currentState != null) {
                currentState.next = newNode;
            }
            currentState = newNode;
            tail = newNode; // update tail to most recent state
        }
    }

    /* ==================================================== */
    // UNDO OPERATION; move to previous state and return data
    public T undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev; // this is used to roll back to previous state
            return currentState.data;
        }
        System.out.println("Error! No previous state to undo.");
        return null;
    }

    // REDO OPERATION; move to next state and return data
    public T redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next; // similar to  undo, this moves to next state
            return currentState.data;
        }
        System.out.println("Error! No next state to redo.");
        return null;
    }

    /* ==================================================== */
    // PRINT; prints linked list from head to tail for debugging purposes
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null"); // end of list
    }
}

/*
if everything runs smoothly, UndoRedoManager should be able to have direct access to this class and use everything in here
for testing purposes.
 */

