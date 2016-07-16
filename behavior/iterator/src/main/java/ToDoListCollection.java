public interface ToDoListCollection extends Iterating {

    void add(ToDoList list);
    void remove(ToDoList list);
    int getNumberOfItems();

}
