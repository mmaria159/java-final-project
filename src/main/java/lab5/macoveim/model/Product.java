package lab5.macoveim.model;

public class Product { 
    private long id;
    private long organisationID;
    private String name;
    private Double weight;
    private Double price;
    
     public Product(long id, long organisationID,String name, Double weight, Double price){
         this.id=id;
         this.name=name;
         this.weight=weight;
         this.price=price;
         this.organisationID=organisationID;
         
     }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(long organisationID) {
        this.organisationID = organisationID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", organisationID=" + organisationID +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
