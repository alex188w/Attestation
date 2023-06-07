package HumanFriends.Model.ClassAnimal;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;
import HumanFriends.DateTimeParseException;
import HumanFriends.Controller.Controller;
import HumanFriends.Model.AbstractHumanFriends;
import HumanFriends.Model.AbstractPets;

public class Cat extends AbstractPets {

    public Cat(int id, String name, Date birthday, String commands) {
        super(id, name, birthday, commands);
    }

    @Override
    public int getId() {
        return super.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }

    @Override
    public Date getBirthday() {
        return super.birthday;
    }

    @Override
    public void setBirthday(Date birthday) {
        super.birthday = birthday;
    }

    @Override
    public String getCommands() {
        return super.commands;
    }

    @Override
    public void setCommands(String commands) {
        super.commands = commands;
    }

    @Override
    public String toString() {
        SimpleDateFormat parseDate = new SimpleDateFormat("dd-MM-yyyy");
        return id + " " + name + " " + parseDate.format(birthday) + " " + commands;
    }

    public static void createHumanFriends(AbstractHumanFriends friends) {
        File file = new File("Counter.db");
        int count = 0;
        if (file.exists()) {
            String countStr = Controller.loadFromFile("Counter.db");
            if (!countStr.equals(null)) {
                count = Integer.parseInt(countStr);
            }
        }
        // присваиваем id животного в зависимости от класса животного и порядкового
        // номера записи (count), который считываем из файла "Counter.db":
        // кот 1000 + count, собака 2000 + count, хомяк 3000 + count, лошадь 4000 +
        // count, верблюд 5000 + count, осел 6000 + count.
        friends.setId(1000 + count);
        friends.setName(Controller.inputData("Введите имя животного\n"));
        try {
            SimpleDateFormat parseDate = new SimpleDateFormat("dd-MM-yyyy");
            friends.setBirthday(
                    parseDate.parse(Controller.inputData("Введите дату рождения животного, в формате dd-MM-yyyy\n")));
        } catch (DateTimeException | ParseException e) {
            throw new DateTimeParseException(
                    "Ошибка ввода даты рождения. Введите в формате dd-mm-yyyy\n", e);
        }
        friends.setCommands(Controller.inputData("Введите команды, которые умеет выполнять животное\n"));
    }
}
