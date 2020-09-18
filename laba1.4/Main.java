public class Main {
    public static void main(String args[]) {
        Listok listok = new Listok();
        listok.add(new Unit(1234567));
        listok.add(new Unit(2345678));
        listok.add(new Unit(333));
        listok.add(new Unit(3456789));
        listok.add(new Unit(4567890));
        listok.add(new Unit(222));
        listok.add(new Unit(111));
        System.out.println("Элементы двунаправленного списка:");
        do {
            System.out.println(listok.getCurrent().getNumber());
            listok.setCurrent(listok.getCurrent().getNext());
        } while (listok.getCurrent() != listok.getHead());
        System.out.println();
        List list = new List();
        listok.setCurrent(listok.getHead().getPrev());
        do {
            if (listok.getCurrent().getNumber() > 999)
                list.add(new Node(listok.getCurrent().getNumber()));
            listok.setCurrent(listok.getCurrent().getPrev());
        } while (listok.getCurrent() != listok.getHead().getPrev());

        list.reset();
        System.out.println("Элементы однонаправленного списка:");
        do {
            System.out.println(list.getCurrent().getNumber());
            list.setCurrent(list.getCurrent().getNext());
        } while (list.getCurrent() != null);
    }
}
