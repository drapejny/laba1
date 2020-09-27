public class Main {
    public static void main(String args[]) {
        List list = new List();
        list.add(new Node("Кост", 89));
        list.add(new Node("Андрюков", 8));
        list.add(new Node("Автобус", 23));
        list.add(new Node("Автобус", 24));
        list.add(new Node("Автилова", 0));
        list.add(new Node("Бабич", 243));
        list.add(new Node("Носов", 24));
        list.add(new Node("Носков", 2424));
        list.add(new Node("Притыцкий", 432415));
        list.add(new Node("Поляк", 89148291));
        list.add(new Node("Яблонский", 898989));
        list.add(new Node("Бабичева", 2839129));
        list.add(new Node("Мохно", 24891249));
        list.add(new Node("Носов",132123123));
        list.add(new Node("Носов",3444444));
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getCurrent().getName());
            list.setCurrent(list.getCurrent().getNext());
        }
        System.out.println();
        
        searchName(list,55);
        searchNumber(list,"Носов");

    }
    public static void searchNumber(List list, String name){
        list.reset();
        while(list.getCurrent() != null && !name.contentEquals(list.getCurrent().getName()))
            list.setCurrent(list.getCurrent().getNext());
        if(list.getCurrent() == null)
            System.out.println("Абонент отсутствует");
        else{
            while(list.getCurrent() != null && list.getCurrent().getName().contentEquals(name)){
                System.out.println(name + " " +  list.getCurrent().getNumber());
                list.setCurrent(list.getCurrent().getNext());
            }
        }
    }

    public static void  searchName(List list, int number) {
        list.reset();
        while (list.getCurrent() != null && number != list.getCurrent().getNumber())
            list.setCurrent(list.getCurrent().getNext());

        if (list.getCurrent() == null)
            System.out.println("Номер отсутствует");
        else System.out.println(list.getCurrent().getName() + " " + number);
    }
}
