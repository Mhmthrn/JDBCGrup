import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1 - Ilgili Driver'i yuklemeliyiz. MySQL kullandigimizi bildiriyoruz.
        // Driver'i bulamama ihtimaline karsi forName metodu icin ClassNotFoundException
        // method signature'imiza axception olarak firlatmamizi istiyor.

        Class.forName("com.mysql.cj.jdbc.Driver");

        //2- Baglantiyi olusturmak icin username ve password giris islemi yapmaliyiz.
        // Burada da bu username ve password'un yanlis olma ihtimaline karsi
        // SQLException firlatmamizi istiyor.


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "15142015");

        // 3- SQL query leri icin bir statement objesi olusturup, java da SQL sorgularimiz icin bir alan acacagiz

        Statement st= con.createStatement();


        // 4-SQL query leri yazip calistirabiliriz

        ResultSet veri=st.executeQuery("select * from worker");


        // 5- sonuclari gormek icin iteration ile set icerisindeki elemanlari bir while dongusuyle yazdiriyoruz.

        while (veri.next()){

            System.out.println(veri.getInt(1)+" "+ veri.getString(2)+" "
                    + veri.getString(3));
        }

        // 6- olusturulan baglatilari kapatalim

        con.close();
        st.close();
        veri.close();

    }


}
