package HumanFriends.Model;

import java.util.Date;

public abstract class AbstractPackAnimals extends AbstractHumanFriends {
    public AbstractPackAnimals(int id, String name, Date birthday, String commands) {
        super(id, name, birthday, commands);
    }
}
