package afleveringstuderende;

public class Test {
    public static void main(String[] args) {
        DictionaryDoubleHashing<Integer, String> list = new DictionaryDoubleHashing<>(10);

        list.put(1, "abe");
        list.put(0, "giraf");
        list.writeOut();

        System.out.println();

        System.out.println("Removing key 1");
        System.out.println("value removes: " + list.remove(1));
        list.writeOut();

        System.out.println();

        System.out.println("Getting key 0");
        System.out.println("value: " + list.get(0));

        System.out.println();

        System.out.println("Size of list: " + list.size());
        System.out.println("Is list empty? " + list.isEmpty());

        System.out.println();

        System.out.println("Removing key 0");
        System.out.println("value removes: " + list.remove(0));
        list.writeOut();

        System.out.println();

        System.out.println("Size of list: " + list.size());
        System.out.println("Is list empty? " + list.isEmpty());

        System.out.println();

        list.put(5, "victory");
        list.writeOut();




    }
}
