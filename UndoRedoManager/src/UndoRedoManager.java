// Project: a boilerplate for assignment usage purposes; this class draws from the DoubleLinkedList and utilizes the methods in that file for test purposes
// By: Cameron Beanland (base repo for this class provided by Kennedy Azupwah)
// Date: Feb. 4th, 2025

/**
 * Implement an application that supports undo/redo functionality. Use a linked list to maintain a sequence of states.
 * Each state change is stored as a node in the list, allowing for easy navigation.
 * Example state sequence: 1 <> 2 <> 3 <> 4 <> 5
 */

// side note, for this class to work properly you MUST have DoubleLinkedList as well + have them in the same folder together

public class UndoRedoManager<T> {
    // refers to DoubleLinkedList to store states
    private final DoubleLinkedList<T> stateList;

    public UndoRedoManager() {
        stateList = new DoubleLinkedList<>(); // initialize DoubleLinkedList
    }

    // UNDO OPERATION; reverse to previous state
    public T undo() {
        return stateList.undo(); // uses undo method from DoubleLinkedList, same with the others (more info on there about how they work)
    }

    // REDO OPERATION; move to next state
    public T redo() {
        return stateList.redo();
    }

    // ADD OPERATION; add new state to list (didn't want this one to feel left out)
    public void addState(T newState) {
        stateList.addState(newState);
    }

    /* =========================================================== */
    public static void main(String[] args) {
        // Example of using the UndoRedoManager
        UndoRedoManager<Integer> manager = new UndoRedoManager<>();

        // add states from 1-4
        manager.addState(1);
        manager.addState(2);
        manager.addState(3);
        manager.addState(4);

        System.out.println("Undo: " + manager.undo()); // undo to state 3
        System.out.println("Undo: " + manager.undo()); // undo to state 2
        System.out.println("Redo: " + manager.redo()); // redo to state 3
        System.out.println("Undo: " + manager.undo()); // undo to state 2
    }
}