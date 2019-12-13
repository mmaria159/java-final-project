package lab5.macoveim.model;

import java.util.Date;

public class Employee {
    private long id;
    private long organizationId;
    private String firstName;
    private String lastName;
    private Date birthday;

      public Employee( int id, long organizationId,String firstName,String lastName,Date birthday){

          this.id=id;
          this.organizationId = organizationId;
          this.lastName=lastName;
          this.firstName=firstName;
          this.birthday=birthday;
      }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
