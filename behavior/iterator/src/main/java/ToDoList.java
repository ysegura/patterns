public interface ToDoList extends Iterating{

    void add(String item);
    void add(String item, int position);
    void remove(String item);
    int getNumberOfItems();
    String getListName();
    void setListName(String newListName);

}
