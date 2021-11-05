import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Currency currency = Currency.get();
        Currency.setDollarExchange(0.014);
        Currency.setEuroExchange(0.012);
        Currency.setEurUsd(1.15);
        Product phone = new ElectronicProduct("iphone", 80000, "Apple", "electronic", 128);
        Product locker = new FurnitureProduct("Locker", 3900, "LockerCompany", "furniture", 100, 100);
        Product sofa = new FurnitureProduct("Sofa", 5000, "SofaCompany", "furniture", 100, 300);
        Stockroom.stockroom.put(phone.getName(), phone);
        Stockroom.stockroom.put(locker.getName(), locker);
        Stockroom.stockroom.put(sofa.getName(), sofa);
        Scanner scanner = new Scanner(System.in);
        String sc;
        while (true) {
            System.out.println("Выберете действие\n1. Вывести список товаров.\n2. Купить товар.\n3.Заменить купленный товар.\n4. Вывести курс валюты ");
            sc = scanner.nextLine();
            switch (Integer.parseInt(sc)) {
                case 1:
                    System.out.println(Stockroom.myStaticToString());
                    break;
                case 2:
                    System.out.println(Stockroom.myStaticToString());
                    System.out.println("Введить название товара для покупки");
                    sc = scanner.nextLine();
                    Product product = Stockroom.stockroom.get(sc);
                    if (Stockroom.stockroom.get(sc).getType().equals("electronic")) {
                        TechnicService technicService = new TechnicService();
                        ElectronicProduct electronicProduct = (ElectronicProduct) product;
                        System.out.println(electronicProduct);
                        System.out.println("Дополнительные сервис (укажите номер):\n1. Доставка.\n2. Настройка\n3. Заказать доставку и настройку");
                        sc = scanner.nextLine();
                        if (sc.equals("1")) {
                            System.out.println("Укажите адрес доставки:");
                            sc = scanner.nextLine();
                            technicService.delivery(electronicProduct, sc);
                            System.out.println("Заказ принят. Адрес доставки " + sc);
                        } else if (sc.equals("2")) {
                            technicService.softwareInstall(electronicProduct);
                            System.out.println("Заказ принят.");
                        } else if (sc.equals("3")) {
                            System.out.println("Укажите адрес доставки:");
                            sc = scanner.nextLine();
                            technicService.delivery(electronicProduct, sc);
                            technicService.softwareInstall(electronicProduct);
                            System.out.println("Заказ принят. Оформлена настройка и доставка товара. Адрес доставки " + sc);
                        }
                        Sold.setSold(electronicProduct);
                    } else if (Stockroom.stockroom.get(sc).getType().equals("furniture")) {
                        FurnitureService furnitureService = new FurnitureService();
                        FurnitureProduct furnitureProduct = (FurnitureProduct) product;
                        System.out.println(furnitureProduct);
                        System.out.println("Дополнительные сервис(укажите номер):\n1. Доставка. ");
                        sc = scanner.nextLine();
                        if (sc.equals("1")) {
                            System.out.println("Укажите адрес доставки:");
                            sc = scanner.nextLine();
                            furnitureService.delivery(furnitureProduct, sc);
                            System.out.println("Заказ принят. Адрес доставки " + sc);
                        }
                        Sold.setSold(furnitureProduct);
                    }
                    break;
                case 3:
                    System.out.println("Вы купили товар: " + Sold.getSold().values());
                    System.out.println(Stockroom.myStaticToString());
                    System.out.println("Введите имя товара который хотите заменить:");
                    sc = scanner.nextLine();
                    if (Sold.getSold().get(sc).equals("")) {
                        System.out.println("Такой товар не найден");
                        break;
                    }
                    Product value1 = Sold.getSold().get(sc);
                    System.out.println("Введите имя товара на который хотите заменить:");
                    sc = scanner.nextLine();
                    if (Stockroom.stockroom.get(sc).equals("")) {
                        System.out.println("Такой товар не найден");
                        break;
                    }
                    Product value2 = Stockroom.stockroom.get(sc);
                    System.out.println("Необходимо доплатить " + (value2.getCost() - value1.getCost()));
                    System.out.println(ExchangeService.exchange(value1.getName(), value2.getName()));
                    break;
                case 4:
                    System.out.println("Укажите из какой валюты в какую интересует перевод\n 1.RUB|USD\n 2. RUB|EUR\n 3.EUR|USD");
                    sc = scanner.nextLine();
                    if (Integer.parseInt(sc) == 1) System.out.println(Exchange.exchange("RUB", "USD"));
                    if (Integer.parseInt(sc) == 2) System.out.println(Exchange.exchange("RUB", "EUR"));
                    if (Integer.parseInt(sc) == 3) System.out.println(Exchange.exchange("EUR", "USD"));
                    break;
            }
        }
    }

}
//TODO (DONE) Madic (Использованы магические числа курса валют в Классе Currency, тем самым м указали в одном месте статические значения переменных и потом их используем в программе.... например в Product.toString и др.)
//TODO (DONE) DRY (Любой метод реализует правило DRY, например использование функции myStaticToString() System.out.println(Stockroom.myStaticToString()) встречающееся в main несколько раз.)
//TODO (DONE) Single-responsibility principle (Хранение всех товаров (Product) вынесено в класс склад (Stockroom), тем самым мы не храним в классе Product список всех имеющихся продуктов)
//TODO (DONE) Open-closed principle (Класс продукт (Product) расширяем с помощью классов (FurnitureProduct) и (ElectronicProduct). Тем самым м не вносисли изменения в родительский класс, а расширили с помощью дочерних классов)
//TODO (DONE) Liskov substitution principle (функция "static String exchange(String value1, String value2)" используется как получение информации по курсу валют (class Exchange), так и как сервис по обмену товара (class ExchangeService). Можно было допустить ошибку отнаследоваться и переопределить метод)
//TODO (DONE) Interface segregation principle (Сервис при покупке товаров разделен. Для Техники доступно доставка и установка ПО (class TechnicService), для мебели только доставка(class FurnitureService). Тем самым мы не использовали ненужные метод по установке ПО в сервисе предоставляющих для мебели.)
//TODO Dependency inversion principle




