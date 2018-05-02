# Hibernate Uygulama Örneði

Bir JPA aracý olan Hibernate'in uygulama pratiðini anlamak için yazmýþ olduðum örnek.

Uygulamada bulunan baþlýca sýnýf ve dosyalar:

* 1-hibernate.cfg.xml: Veritabaný konfigürasyonlarýný yaptýðýmýz Hibernate xml dosyasý.

* 2-hibernate.hbm.xml:Veritabaný tablolarý ve Java Objeleri arasýndaki baðlantýyý kurmak için oluþturduðumuz Hibernate Mapping xml dosyasý.

* 3-Employee.java: Veritabanýmýzdaki Employee tablosuna karþýlýk gelecek olan Java sýnýfý.

* 4-HibernateUtil.java: Hibernate konfigürasyon dosyasýný kullanarak veritabanýna eriþim saðlayacak olan Java sýnýfý.

* 5-DatabaseFunctions.java: Hibernate session objesini kullanarak veritabaný üzerinde CRUD iþlemlerini yapmayý saðlayan Java sýnýfý.

* 6-HibernateExample.java: Uygulamayý yürütecek olan ana Java sýnýfý.