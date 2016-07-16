public class RunPattern {

    public static void main(String [] args) {
        System.out.println("Example for the Observer pattern.");
        System.out.println(
                "This demonstration uses a central observable object to send change notifications to several JPanels in a GUI. Each JPanel is an Observer, receiving notifications when there has been some change in the shared Task that is being edited");
        System.out.println();

        System.out.println("Creating the ObserverGUI");
        ObserverGui gui = new ObserverGui();
        gui.createGui();
    }

}
