public class Main {
    public static void main(String args[]) {
        List list = new List();
        list.add(new Node("Кост А.Б.", 89));
        list.add(new Node("Андрюков С.С.", 8));
        list.add(new Node("Жилинская С.В.", 23));
        list.add(new Node("Автобус Н.Н.", 24));
        list.add(new Node("Автилова К.Ж.", 0));
        list.add(new Node("Бабич Б.Б.", 243));
        list.add(new Node("Носов Ж.Ж.", 24));
        list.add(new Node("Носков А.А.", 2424));
        list.add(new Node("Притыцкий С.Ф.", 432415));
        list.add(new Node("Поляк А.А.", 89148291));
        list.add(new Node("Яблонский А.А.", 898989));
        list.add(new Node("Бабичева А.Г.", 2839129));
        list.add(new Node("Мохно П.П.", 24891249));
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getCurrent().getName());
            list.setCurrent(list.getCurrent().getNext());
        }
        System.out.println();
        
        searchName(list,55);
        searchNumber(list,"Мохно П.П.");

    }
    public static void searchNumber(List list, String name){
        list.reset();
        while(list.getCurrent() != null && !name.contentEquals(list.getCurrent().getName()))
            list.setCurrent(list.getCurrent().getNext());
        if(list.getCurrent() == null)
            System.out.println("Абонент отсутствует");
        else System.out.println(name + " " +  list.getCurrent().getNumber());
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
