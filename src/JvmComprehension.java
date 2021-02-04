public class JvmComprehension {     // Подсистема загрузчиков классов ищет классы JvmComprehension, Object, Integer, System.
                                    // данные о классах помещаются в метаспейс

    public static void main(String[] args) { // В стэке создается фрейм метода main
        int i = 1;                      // 1 Внутри фрейма main создается примитив int i = 1;
        Object o = new Object();        // 2 Внутри хипа создается объект Object. Внутри фрейма main создается переменная o, куда кладется ссылка на Object
        Integer ii = 2;                 // 3 Внутри хипа создается объект Integer. Внутри фрейма main создается переменная ii, куда кладется ссылка на Integer
        printAll(o, i, ii);             // 4 В стэке создается еще один фрейм printAll.
                                        // 4.1 В этом фрейме создаются переменные o, i, ii, которые хранят в себе ссылки на соответствующие объекты
        System.out.println("finished"); // 7 Фреймы sout из printAll и сам printAll удаляются из стэка. В хипе создается объект String со значением "finished".
                                        // Создается новый фрейм для System.out.println. Туда передается ссылка на "finished". Так же сборщик мусора должен удалить из хипа
                                        // переменную uselessVar, т.к. на неё больше нет ссылок.
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 В хипе создается объект Integer. В фрейм printAll добавляется переменная uselessVar, в которую кладется ссылка на Integer
        System.out.println(o.toString() + i + ii);  // 6 Создается еще один фрейм в стэке с соответствующими переменными.
    }
}