public class RunPattern {

    public static void main(String[] args){
        System.out.println("Example of Singleton Pattern");
        System.out.println();
        System.out.println("This example will demonstrate the use of");
        System.out.println("the Singleton pattern by creating two GUI");
        System.out.println("editors, both referencing the same history list.");

        System.out.println("Creating the first editor...");
        System.out.println();
        SingletonGui editorA = new SingletonGui();
        editorA.createGui();

        System.out.println("Creating the second editor...");
        System.out.println();
        SingletonGui editorB = new SingletonGui();
        editorB.createGui();
    }

}
