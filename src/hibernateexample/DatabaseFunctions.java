/*
    Veritabanı üzerinde CRUD işlemleri yapacak olan sınıf.
 */
package hibernateexample;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author senel
 */
public class DatabaseFunctions
{
    private SessionFactory factory;
    public DatabaseFunctions(SessionFactory factory)
    {
        this.factory = factory;
    }
    /*
        public Integer addEmployee(String fname, String lname, int salary, Set certs, Address addr):
        Tanım: 
            Kendisine parametre olarak gönderilen değerler ile bir Employee objesi oluşturan ve
            bu objeyi veritabanına yeni bir kayıt olarak ekleyen method.
        Parametreler:
            -fName: Employee'nin isim bilgisi.
            -lName: Employee'nin soyadı bilgisi.
            -salary: Employee'nin maaş bilgisi.
            -certs : Employee'nin sahip olduğu sertifikaları tutan set değişkeni.
            -addr : Employee tablosuna component olarak dahil olan adres bilgisi.
        Geri dönüş:
            -Integer: Eklenecek Employee'e atanan id bilgisi.
    */
    public Integer addEmployee(String fName, String lName, int salary, Set certs, Address addr)
    {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
      
        try
        {
            tx = session.beginTransaction();
            Employee employee = new Employee(fName, lName, salary);
            employee.setCertificates(certs);
            employee.setAddress(addr);
            employeeID = (Integer) session.save(employee); 
            tx.commit();
        }catch(HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally
        {
            session.close(); 
        }
        return employeeID;
    }
        
    /*
        public void listEmployees():
        Tanım:
            EMPLOYEES ve CERTIFICATES tablolarında bulunan kayıtları Java ortamına Employee ve Certificate objeleri halinde çeken ve
            bunları ekrana yazdıran method.
    */
    public void listEmployees( )
    {
        Session session = factory.openSession();
        Transaction tx = null;
      
        try
        {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list(); 
            for(Iterator iterator = employees.iterator(); iterator.hasNext();)
            {
                Employee employee = (Employee) iterator.next(); 
                System.out.print("First Name: " + employee.getFirstName()); 
                System.out.print("  Last Name: " + employee.getLastName()); 
                System.out.println("  Salary: " + employee.getSalary());
                
                Address add = employee.getAddress();
                System.out.println("Address ");
                System.out.println("\tStreet: " +  add.getStreet());
                System.out.println("\tCity: " + add.getCity());
                System.out.println("\tState: " + add.getState());
                System.out.println("\tZipcode: " + add.getZipcode());
                
                Set certificates = employee.getCertificates();
                for(Iterator iterator2 = certificates.iterator(); iterator2.hasNext();)
                {
                    Certificate ctf = (Certificate) iterator2.next();
                    System.out.println("Certificate : " + ctf.getName());
                }
            }
            tx.commit();
        }catch(HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally
        {
         session.close(); 
        }
    }
    
    /*
        public void updateEmployee(Integer EmployeeID, int salary ):
        Tanım:
            Id'si gönderilen Employee'nin maaşını güncelleyen method.
        Parametreler:
            -EmployeeID: Maaş bilgisi güncellenecek Employee'nin id'si.
            -salary: Employee'nin yeni maaş değeri.
    */
    public void updateEmployee(Integer EmployeeID, int salary )
    {
        Session session = factory.openSession();
        Transaction tx = null;
      
        try
        {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
            employee.setSalary( salary );
            session.update(employee); 
            tx.commit();
        }catch(HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally
        {
            session.close(); 
        }
    }
    
    /*
        public void deleteEmployee(Integer EmployeeID):
        Tanım:
            ID bilgisi gönderilen Employee'nin kaydını veritabanından silen method.
        Parametreler:
            -EmployeeID: Kaydı silinecek Employee'nin ID bilgisi.
    */
    public void deleteEmployee(Integer EmployeeID)
    {
        Session session = factory.openSession();
        Transaction tx = null;
      
        try
        {
            tx = session.beginTransaction();
            Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
            session.delete(employee); 
            tx.commit();
        }catch(HibernateException e)
        {
            if (tx!=null) tx.rollback();
            e.printStackTrace(); 
        }finally
        {
            session.close(); 
        }
    }
}
