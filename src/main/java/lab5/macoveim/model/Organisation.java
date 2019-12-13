package lab5.macoveim.model;

public class Organisation {
    private long id;
    private String name;
    private String street;
    private long telephone;


    public Organisation(long id, String name, String street, long telephone) {
        
        this.id = id;
        this.name = name;
        this.street = street;
        this.telephone = telephone;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
