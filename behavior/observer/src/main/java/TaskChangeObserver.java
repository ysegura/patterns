public interface TaskChangeObserver {

    void taskAdded(Task task);
    void taskChanged(Task task);
    void taskSelected(Task task);

}
