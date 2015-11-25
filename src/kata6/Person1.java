package kata6;

public class Person1 {
    private final int id;
    private final String name, gender, birthday, mail;
    private final float weight;

    public Person1(int id, String name, String gender, String birthday, String mail, float weight) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.mail = mail;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getMail() {
        return mail;
    }

    public float getWeight() {
        return weight;
    }
    
    
}
