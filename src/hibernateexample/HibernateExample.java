/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateexample;

import java.util.HashSet;


/**
 *
 * @author senel
 */
public class HibernateExample {

    public static void main(String[] args) 
    {
        HibernateUtil hnu = new HibernateUtil();
        DatabaseFunctions df = new DatabaseFunctions(hnu.getSessionFactory());
        //1. çalışan için bir sertifika kümesi oluşturuluyor:
        HashSet set1 = new HashSet();
        set1.add(new Certificate("MCA"));
        set1.add(new Certificate("MBA"));
        set1.add(new Certificate("PMP"));
        
        Address address1 = new Address("Kondapur","Hyderabad","AP","532");
        
        // Veritabanına birkaç tane Employee eklenir.
        Integer empID1 = df.addEmployee("Zara", "Ali", 1000, set1, address1);
        
        //2. çalışan için bir sertifika kümesi oluşturuluyor:
        HashSet set2 = new HashSet();
        set2.add(new Certificate("BCA"));
        set2.add(new Certificate("BA"));
        
         Address address2 = new Address("Saharanpur","Ambehta","UP","111");
        
        Integer empID2 = df.addEmployee("Daisy", "Das", 5000, set2, address2);
        
        //3. çalışan için boş bir sertifika kümesi oluşturuluyor:
        HashSet set3 = new HashSet();
        Integer empID3 = df.addEmployee("John", "Paul", 10000, set3, address2);
        
        //Employee tablosundaki kayıtlar listelenir:
        df.listEmployees();
        
        System.out.println();
        
        //1. Elemanın maaşı 5000 olarak güncellenir:
        df.updateEmployee(empID1, 5000);
        
        df.listEmployees();
        
        System.out.println();

        //2. Elemanın kaydı silinir:
        df.deleteEmployee(empID2);
        
        df.listEmployees();
    }
    
}
