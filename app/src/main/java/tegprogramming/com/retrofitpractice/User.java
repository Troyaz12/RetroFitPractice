package tegprogramming.com.retrofitpractice;

/**
 * Created by TroysMacBook on 10/29/17.
 */

public class User {

    private Integer id;
    private String name;
    private String email;
    private int age;
    private String[] topics;

    public User(Integer id, String name, String email, int age, String[] topics) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.topics = topics;
    }

    public Integer getId() {
        return id;
    }
}
