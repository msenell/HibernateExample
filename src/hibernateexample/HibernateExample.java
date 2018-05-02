/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateexample;


/**
 *
 * @author senel
 */
public class HibernateExample {

    public static void main(String[] args) 
    {
        HibernateUtil hnu = new HibernateUtil();
        DatabaseFunctions df = new DatabaseFunctions(hnu.getSessionFactory());
        /* Veritabanına birkaç tane Employee eklenir. */
        Integer empID1 = df.addEmployee("Zara", "Ali", 1000);
        Integer empID2 = df.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = df.addEmployee("John", "Paul", 10000);
        
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
