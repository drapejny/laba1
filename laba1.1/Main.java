import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите многочлен P");
        List listP = new List(enterSize());
        enterList(listP);
        System.out.println("Введите многочлен Q");
        List listQ = new List(enterSize());
        enterList(listQ);
        listP.print();
        System.out.println();
        listQ.print();
        System.out.println();
        System.out.println("Equality(P,Q):" + equality(listP, listQ));
        System.out.println("\nMeaning(P,X):");
        System.out.println("Введите значение X");
        while (!scan.hasNextInt())
            scan.nextInt();
        int x = scan.nextInt();
        listP.print();
        System.out.printf("= %d , при x = %d\n\n", meaning(listP, x), x);
        System.out.println("Add(P,Q,R):");
        listP.print();
        System.out.println("\n+");
        listQ.print();
        System.out.println("\n=");
        Add(listP, listQ).print();

    }

    public static List Add(List list_1, List list_2) {
        list_1.reset();
        list_2.reset();
        Node current_1 = list_1.getCurrent();
        Node current_2 = list_2.getCurrent();
        List list_3 = new List(list_1.getSize() >= list_2.getSize() ? list_1.getSize() : list_2.getSize());
        while (current_1 != null || current_2 != null) {
            if (current_1 == null) {
                list_3.add(new Node(current_2.getSt(), current_2.getCof()));
                current_2 = current_2.getNext();
            } else if (current_2 == null) {
                list_3.add(new Node(current_1.getSt(), current_1.getCof()));
                current_1 = current_1.getNext();
            } else {
                if (current_1.getSt() > current_2.getSt()) {
                    list_3.add(new Node(current_1.getSt(), current_1.getCof()));
                    current_1 = current_1.getNext();
                } else if (current_1.getSt() == current_2.getSt()) {
                    list_3.add(new Node(current_1.getSt(), current_1.getCof() + current_2.getCof()));
                    current_1 = current_1.getNext();
                    current_2 = current_2.getNext();
                } else if (current_2.getSt() > current_1.getSt()) {
                    list_3.add(new Node(current_2.getSt(), current_2.getCof()));
                    current_2 = current_2.getNext();
                }
            }
        }
        return list_3;
    }

    public static int meaning(List list, int x) {
        list.reset();
        int sum = 0;
        while (list.getCurrent() != null) {
            sum += (int) (list.getCurrent().getCof() * Math.pow(x, list.getCurrent().getSt()));
            list.setCurrent(list.getCurrent().getNext());
        }
        return sum;
    }

    public static boolean equality(List list_1, List list_2) {
        if (list_1.getSize() != list_2.getSize() || list_1.getSize() == 0 || list_2.getSize() == 0)
            return false;
        else {
            list_1.reset();
            list_2.reset();
            while (list_1.getCurrent() != null) {
                if (list_1.getCurrent().getSt() != list_2.getCurrent().getSt() || list_1.getCurrent().getCof() != list_2.getCurrent().getCof())
                    return false;
                list_1.setCurrent(list_1.getCurrent().getNext());
                list_2.setCurrent(list_2.getCurrent().getNext());
            }
            return true;
        }

    }

    public static int enterSize() {
        System.out.println("Введите степень многочлена");
        Scanner scan = new Scanner(System.in);
        int size = -1;
        do {
            while (!scan.hasNextInt())
                scan.next();
            size = scan.nextInt();
        } while (size < 0);
        return size;
    }

    public static void enterList(List list) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите коэффициенты многочлена");
        for (int i = list.getSize(); i >= 0; i--) {
            while (!scan.hasNextInt())
                scan.next();
            list.add(new Node(i, scan.nextInt()));
        }
        list.setSize(list.getHead().getSt());
    }
}
