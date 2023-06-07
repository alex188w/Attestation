package HumanFriends.Model;

import java.util.Date;

public abstract class AbstractHumanFriends {
    // public static final int length = 0;
    protected int id;
    protected String name;
    protected Date birthday;
    protected String commands;

    abstract public int getId();

    abstract public void setId(Integer id);

    abstract public String getName();

    abstract public void setName(String name);

    abstract public Date getBirthday();

    abstract public void setBirthday(Date birthday);

    abstract public String getCommands();

    abstract public void setCommands(String commands);

    public AbstractHumanFriends(int id, String name, Date birthday, String commands) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }   
}
