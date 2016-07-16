import java.util.HashMap;
import java.util.Iterator;

public class ToDoListCollectionImpl implements ToDoListCollection {

    private HashMap lists = new HashMap();

    @Override
    public void add(ToDoList list) {
        if (!lists.containsKey(list.getListName())) {
            lists.put(list.getListName(), list);
        }
    }

    @Override
    public void remove(ToDoList list) {
        if (lists.containsKey(list.getListName())) {
            lists.remove(list.getListName());
        }
    }

    @Override
    public int getNumberOfItems() {
        return lists.size();
    }

    @Override
    public Iterator getIterator() {
        return lists.values().iterator();
    }

    @Override public String toString() {
        return getClass().toString();
    }
}
