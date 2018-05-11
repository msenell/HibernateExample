/*
    Sertifika bilgilerini tutmakta kullanılacak olan sınıf.
 */
package hibernateexample;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author senel
 */

@Entity
@Table(name = "CERTIFICATE")
public class Certificate implements Serializable
{
    //Sertifika ID'sine karşılık gelen değişken:
    private int id;
    //Sertifika ismine karşılık gelen değişken:
    private String name;
    
    private Employee employee;
    
    public Certificate(){}
    
    public Certificate(String name)
    {
        this.name = name.toString();
    }
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    @Column(name = "certificate_name")
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name.toString();
    }
    
    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Employee getEmployee()
    {
        return this.employee;
    }
    
    public void setEmployee(Employee emp)
    {
        this.employee = emp;
    }
    
    //Certificate nesnelerinin eşitlik durumunu daha sağlıklı kontrol edebilmek için
    //equals() methodunu Override ederek özelleştiriyoruz:
    @Override
    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(! this.getClass().equals(obj.getClass()))
            return false;
        
        Certificate ctf = (Certificate) obj;
        if( this.id == ctf.getId() && this.name.equals(ctf.getName()) )
            return true;
        return false;
    }
    
    //hashCode() methodunu Certificate sınıfının üye değişkenlerini dikkate alarak özelleştiriyoruz:
    public int hashCode()
    {
        int tmp = 0;
        tmp = (id + name).hashCode();
        return tmp;
    }
}
