/*
    Veritabanındaki "EMPLOYEE" tablosuna karşılık gelen Java Sınıfı.
 */
package hibernateexample;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author senel
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable
{
    //Tablodaki id sütununa karşılık gelir.
    private int id;
    //Tablodaki first_name sütununa karşılık gelir.
    private String firstName;
    //Tablodaki last_name sütununa karşılık gelir.
    private String lastName;
    //Tablodaki salary sütununa karşılık gelir.
    private int salary;
    //One-to-Many ilişkisi ile tutulacak sertifika bilgileri:
    private Set<Certificate> certificates;
    //Component olarak tanımlanacak adres bilgileri:
    private Address address;
    
    public Employee(){}
    
    public Employee(String firstName, String lastName, int salary)
    {
        this.firstName = firstName.toString();
        this.lastName = lastName.toString();
        this.salary = salary;
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() 
    {
        return id;
    }
   
    public void setId( int id ) 
    {
        this.id = id;
    }
    
    @Column(name = "first_name")
    public String getFirstName() 
    {
        return firstName;
    }
   
    public void setFirstName( String first_name ) 
    {
        this.firstName = first_name;
    }
    
    @Column(name = "last_name")
    public String getLastName() 
    {
        return lastName;
    }
   
    public void setLastName( String last_name ) 
    {
        this.lastName = last_name;
    }
    
    @Column(name = "salary")
    public int getSalary() 
    {
        return salary;
    }
   
    public void setSalary( int salary ) 
    {
        this.salary = salary;
    }
    
    @OneToMany(
        mappedBy = "employee",
        cascade = CascadeType.ALL,
            targetEntity = Certificate.class
    )
    public Set getCertificates()
    {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates)
    {
        this.certificates = certificates;
    }
    
    @Embedded
    public Address getAddress()
    {
        return this.address;
    }
    
    public void setAddress(Address address)
    {
        this.address = address;
    }
    
    
}
