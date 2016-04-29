public class RunPattern {

    public static void main(String[] args) {

        System.out.println("Example for Prototype pattern");
        System.out.println();
        System.out.println("This example creates an Address object, which it's then");
        System.out.println("duplicated using the copy method.");
        System.out.println();

        System.out.println("First Address");
        Address addressA = new Address("8445 Silverado Trail", "Rutherford", "CA", "91734");
        System.out.println("\tHashcode -> " + addressA.hashCode());
        System.out.println(addressA);
        System.out.println();

        System.out.println("Second Address");
        Address addressB = (Address) addressA.copy();
        System.out.println("\tHashcode -> " + addressB.hashCode());
        System.out.println(addressB);
    }

}
