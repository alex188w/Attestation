package HumanFriends.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import HumanFriends.DataFormatException;
import HumanFriends.Model.AbstractHumanFriends;
import HumanFriends.Model.ClassAnimal.Horse;

public class Controller {

    public static List<AbstractHumanFriends> inputFromFileHumanFriends() {
        List<AbstractHumanFriends> humanFriends = new ArrayList<>();

        try (FileReader fr = new FileReader("Animal.db")) {

            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                Horse friends = new Horse(0, null, null, null);
                String[] friendsArr = line.split(" ");
                friends.setId(Integer.parseInt(friendsArr[0]));
                friends.setName(friendsArr[1]);
                SimpleDateFormat parseDate = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    friends.setBirthday(parseDate.parse(friendsArr[2]));
                } catch (ParseException e) {
                    throw new DataFormatException(
                            "Ошибка ввода даты рождения. Введите в формате dd-mm-yyyy\n", e);
                }
                ArrayList<String> newCommands = new ArrayList<String>();
                for (int i = 3; i < friendsArr.length; i++) {
                    newCommands.add(friendsArr[i].replaceAll("^\\[|\\]|\\,$", ""));
                }
                friends.setCommands(newCommands.toString());
                humanFriends.add(friends);
                line = reader.readLine();
            }
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return humanFriends;
    }

    public static String inputData(String message) {
        System.out.print(message);
        String data = " ";
        Scanner in = new Scanner(System.in, "cp866");
        try {
            data = in.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            in.close();
        }
        return data;
    }

    public static void saveFromFile(String data, String fileName, boolean flag) {
        try (FileWriter writer = new FileWriter(fileName, flag)) {
            writer.write(data + '\n');
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
            e.printStackTrace();
        }
    }

    public static void saveFromFileFriends(List<AbstractHumanFriends> humanFriends, String fileName, boolean flag) {
        try (FileWriter writer = new FileWriter(fileName, flag)) {
            for (AbstractHumanFriends t : humanFriends) {
                writer.write(t.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
            e.printStackTrace();
        }
    }

    public static String loadFromFile(String fileName) {
        String line;
        try (FileReader fr = new FileReader(fileName)) {
            BufferedReader reader = new BufferedReader(fr);
            line = reader.readLine();
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return line;
    }

    public static String seeGetCommands(ArrayList<AbstractHumanFriends> friends, int idFriend) {
        for (AbstractHumanFriends t : friends) {
            if (t.getId() == idFriend) {
                String commands = t.getCommands();
                return commands;
            }
        }
        return "Животного с таким id нет в зоопарке";
    }

    public static AbstractHumanFriends addNewCommands(ArrayList<AbstractHumanFriends> friends, int idFriend,
            String addCommands) {
        for (AbstractHumanFriends t : friends) {
            if (t.getId() == idFriend) {
                String commands = t.getCommands();
                String newCommands = new StringBuilder(commands).append(" ").append(addCommands).toString();
                t.setCommands(newCommands);
                return t;
            }
        }
        return null;
    }
}
