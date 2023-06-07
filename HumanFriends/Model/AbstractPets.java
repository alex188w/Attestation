package HumanFriends.Model;

import java.util.Date;

public abstract class AbstractPets extends AbstractHumanFriends{
    protected AbstractPets(int id, String name, Date birthday, String commands) {
        super(id, name, birthday, commands);
    }    
}
