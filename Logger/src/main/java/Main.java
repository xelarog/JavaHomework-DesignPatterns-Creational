import java.util.*;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.log("Запуск программы");
        Scanner scanner = new Scanner(System.in);

        logger.log("Просим пользователя ввести входные данные");
        int sizeList = 0;
        while (sizeList <= 0) {
            try {
                System.out.println("Введите размер списка: ");
                sizeList = scanner.nextInt();
                if(sizeList <=0 )
                    logger.log("Ошибка ввода");
            } catch (InputMismatchException e) {
                logger.log("Ошибка ввода");
            }
            scanner.nextLine();
        }

        int upperLimitValue = 0;
        while (upperLimitValue <= 0) {
            try {
                System.out.println("Введите верхний порог значений: ");
                upperLimitValue = scanner.nextInt();
                if (upperLimitValue <= 0)
                    logger.log("Ошибка ввода");
            } catch (InputMismatchException e) {
                logger.log("Ошибка ввода");
            }
            scanner.nextLine();
        }

        logger.log("Создаём и наполняем список");
        List<Integer> list = new ArrayList<>();
        list = fillListRandom(list, sizeList, upperLimitValue);
        System.out.print("Вот случайный список:");
        printList(list);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int filterLimit = 0;
        while (filterLimit <= 0 || filterLimit >= upperLimitValue) {
            try {
                System.out.println("Введите порог для фильтрации: ");
                filterLimit = scanner.nextInt();
                if (filterLimit <= 0 || filterLimit >= upperLimitValue)
                    logger.log("Ошибка ввода");

            } catch (InputMismatchException e) {
                logger.log("Ошибка ввода");
            }
            scanner.nextLine();
        }

        Filter filter = new Filter(filterLimit);
        logger.log("Запускаем фильтрацию");
        List<Integer> listFiltered = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        printList(listFiltered);

        logger.log("Завершаем программу");
    }

    private static void printList(List<Integer> list) {
        for (Integer value : list) {
            System.out.print(" " + value);
        }
        System.out.println();
    }

    private static List<Integer> fillListRandom(List<Integer> list, int sizeList, int upperLimitValue) {
        Random random = new Random();
        while (list.size() < sizeList) {
            list.add(random.nextInt(upperLimitValue));
        }
        return list;
    }
}
