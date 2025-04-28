package TP3;

public class User {
    private long id;
    private String name;

    // Constructeur
    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter pour 'name'
    public String getName() {
        return name;
    }

    // Getter pour 'id'
    public long getId() {
        return id;
    }

    // Setter pour 'name'
    public void setName(String name) {
        this.name = name;
    }

    // Setter pour 'id'
    public void setId(long id) {
        this.id = id;
    }
}
