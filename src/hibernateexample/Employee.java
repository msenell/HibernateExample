/*
    Veritabanındaki "EMPLOYEE" tablosuna karşılık gelen Java Sınıfı.
 */
package hibernateexample;

import java.util.Set;

/**
 *
 * @author senel
 */
public class Employee
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
    private Set certificates;
    
    public Employee(){}
    
    public Employee(String firstName, String lastName, int salary)
    {
        this.firstName = firstName.toString();
        this.lastName = lastName.toString();
        this.salary = salary;
    }
    
    public int getId() 
    {
        return id;
    }
   
    public void setId( int id ) 
    {
        this.id = id;
    }
   
    public String getFirstName() 
    {
        return firstName;
    }
   
    public void setFirstName( String first_name ) 
    {
        this.firstName = first_name;
    }
   
    public String getLastName() 
    {
        return lastName;
    }
   
    public void setLastName( String last_name ) 
    {
        this.lastName = last_name;
    }
   
    public int getSalary() 
    {
        return salary;
    }
   
    public void setSalary( int salary ) 
    {
        this.salary = salary;
    }
    
    public Set getCertificates()
    {
        return this.certificates;
    }
    
    public void setCertificates(Set certificates)
    {
        this.certificates = certificates;
    }
}
