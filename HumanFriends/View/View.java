package HumanFriends.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import HumanFriends.Controller.Controller;
import HumanFriends.Controller.Counter;
import HumanFriends.Model.AbstractHumanFriends;
import HumanFriends.Model.ClassAnimal.Camel;
import HumanFriends.Model.ClassAnimal.Cat;
import HumanFriends.Model.ClassAnimal.Dog;
import HumanFriends.Model.ClassAnimal.Donkey;
import HumanFriends.Model.ClassAnimal.Hamster;
import HumanFriends.Model.ClassAnimal.Horse;

public class View {

    public static void onClick() {

        while (true) {
            AbstractHumanFriends friends;
            String key = Controller.inputData("Нажмите: \n"
                    + "1 - завести новое животное\n"
                    + "2 - просмотреть список животных из файла\n"
                    + "3 - просмотреть список команд, которое выполняет животное\n"
                    + "4 - обучить животное новым командам\n"
                    + "Любой другой символ - выход из программы\n");
            switch (key) {
                case "1":
                    Counter counter = new Counter();
                    String key1 = Controller.inputData("Введите вид животного, которое хотите завести, нажмите:\n"
                            + "1 - завести новое животное - кот\n"
                            + "2 - завести новое животное - собака\n"
                            + "3 - завести новое животное - хомяк\n"
                            + "4 - завести новое животное - лошадь\n"
                            + "5 - завести новое животное - верблюд\n"
                            + "6 - завести новое животное - осел\n");
                    switch (key1) {
                        case "1":
                            try {
                                counter.add();
                                friends = new Cat(0, null, null, null);
                                Cat.createHumanFriends(friends);
                                Controller.saveFromFile(friends.toString(), "Animal.db", true);
                            } catch (Exception e) {
                                System.out.println("Ошибка <завести новое животное и записать его в файл>");
                            }
                            break;
                        case "2":
                            try {
                                counter.add();
                                friends = new Dog(0, null, null, null);
                                Dog.createHumanFriends(friends);
                                Controller.saveFromFile(friends.toString(), "Animal.db", true);
                            } catch (Exception e) {
                                System.out.println("Ошибка <завести новое животное и записать его в файл>");
                            }
                            break;
                        case "3":
                            try {
                                counter.add();
                                friends = new Hamster(0, null, null, null);
                                Hamster.createHumanFriends(friends);
                                Controller.saveFromFile(friends.toString(), "Animal.db", true);
                            } catch (Exception e) {
                                System.out.println("Ошибка <завести новое животное и записать его в файл>");
                            }
                            break;
                        case "4":
                            try {
                                counter.add();
                                friends = new Horse(0, null, null, null);
                                Horse.createHumanFriends(friends);
                                Controller.saveFromFile(friends.toString(), "Animal.db", true);
                            } catch (Exception e) {
                                System.out.println("Ошибка <завести новое животное и записать его в файл>");
                            }
                            break;
                        case "5":
                            try {
                                counter.add();
                                friends = new Camel(0, null, null, null);
                                Camel.createHumanFriends(friends);
                                Controller.saveFromFile(friends.toString(), "Animal.db", true);
                            } catch (Exception e) {
                                System.out.println("Ошибка <завести новое животное и записать его в файл>");
                            }
                            break;
                        case "6":
                            try {
                                counter.add();
                                friends = new Donkey(0, null, null, null);
                                Donkey.createHumanFriends(friends);
                                Controller.saveFromFile(friends.toString(), "Animal.db", true);
                            } catch (Exception e) {
                                System.out.println("Ошибка <завести новое животное и записать его в файл>");
                            }
                            break;
                    }
                    System.out.println("Информация о животном добавлена в файл:");
                    break;
                case "2":
                    printFriends(Controller.inputFromFileHumanFriends());
                    break;

                case "3":
                    List<AbstractHumanFriends> humanFriends = new ArrayList<>(Controller.inputFromFileHumanFriends());
                    int idFriend = Integer.parseInt(
                            Controller.inputData(
                                    "Введите id животного, выполняемые команды которого хотите посмотреть : "));
                    System.out.println(
                            Controller.seeGetCommands((ArrayList<AbstractHumanFriends>) humanFriends, idFriend));
                    break;
                case "4":
                    List<AbstractHumanFriends> humanFriends1 = new ArrayList<>(Controller.inputFromFileHumanFriends());
                    int idFriend1 = Integer.parseInt(
                            Controller.inputData("Введите id животного, которого хотите обучить новым командам: "));
                    String newCommands1 = Controller.inputData(
                            "Введите новые комманды, которым обучилось животное (например: стоять, лежать) ");

                    friends = Controller.addNewCommands((ArrayList<AbstractHumanFriends>) humanFriends1, idFriend1,
                            newCommands1);
                    if (friends != null) {
                        System.out.println(friends);
                        Controller.saveFromFileFriends(humanFriends1, "Animal.db", false);
                        System.out.println("Новые команды, которые выполняет животное добавлены.");
                    } else {
                        System.out.println("Животного с таким id нет в зоопарке.");
                    }                    
                    break;
                    
                default:
                    System.out.println("Выход из программы.");
                    return;
            }
        }
    }

    public static void printFriends(List<AbstractHumanFriends> humanFriends) {
        SimpleDateFormat parseDate = new SimpleDateFormat("dd-MM-yyyy");
        for (AbstractHumanFriends t : humanFriends) {
            if (t.getId() > 999 && t.getId() < 2000) {
                System.out.println("Домашнее животное - кот, id = " + t.getId() + ", имя: " + t.getName()
                        + ", день рождения: " + parseDate.format(t.getBirthday())
                        + ", выполняет команды: " + t.getCommands());
            }
            if (t.getId() > 1999 && t.getId() < 3000) {
                System.out.println("Домашнее животное - собака, id = " + t.getId() + ", имя: " + t.getName()
                        + ", день рождения: " + parseDate.format(t.getBirthday())
                        + ", выполняет команды: " + t.getCommands());
            }
            if (t.getId() > 2999 && t.getId() < 4000) {
                System.out.println("Домашнее животное - хомяк, id = " + t.getId() + ", имя: " + t.getName()
                        + ", день рождения: " + parseDate.format(t.getBirthday())
                        + ", выполняет команды: " + t.getCommands());
            }
            if (t.getId() > 3999 && t.getId() < 5000) {
                System.out.println("Вьчное животное - лошадь, id = " + t.getId() + ", имя: " + t.getName()
                        + ", день рождения: " + parseDate.format(t.getBirthday())
                        + ", выполняет команды: " + t.getCommands());
            }
            if (t.getId() > 4999 && t.getId() < 6000) {
                System.out.println("Вьючное животное - верблюд, id = " + t.getId() + ", имя: " + t.getName()
                        + ", день рождения: " + parseDate.format(t.getBirthday())
                        + ", выполняет команды: " + t.getCommands());
            }
            if (t.getId() > 5999 && t.getId() < 7000) {
                System.out.println("Вьючное животное - осел, id = " + t.getId() + ", имя: " + t.getName()
                        + ", день рождения: " + parseDate.format(t.getBirthday())
                        + ", выполняет команды: " + t.getCommands());
            }
        }
    }
}
