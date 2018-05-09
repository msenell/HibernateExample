/*
    Sertifika bilgilerini tutmakta kullanılacak olan sınıf.
 */
package hibernateexample;

/**
 *
 * @author senel
 */
public class Certificate 
{
    //Sertifika ID'sine karşılık gelen değişken:
    private int id;
    //Sertifika ismine karşılık gelen değişken:
    private String name;
    
    public Certificate(){}
    
    public Certificate(String name)
    {
        this.name = name.toString();
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name.toString();
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
