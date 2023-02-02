package calisma02;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.sql.*;

public class Query1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "15142015");
        Statement st = con.createStatement();

        // Baskentler isim li bir tablo olusturun, siraNo , isim, nufus, spor kulubu, iklimi olan
        // fieldlsar olusturun.

        String createTable = "create table baskentler(srNo int,isim varchar(15),SporKulubu varchar(15), iklim varchar(15))";

      /* if (!st.execute(createTable)) {
            System.out.println("Tablo olusturuldu.");
        }*/

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");


        // baskent tablosuna icerik eklyin

      String [] valuearr = {"insert into baskentler values (001,'Berlin','Herta Berlin','Iliman')",
                "insert into baskentler values (002,'Kiev','Dinamo Kiev','Karasal Soguk')",
                "insert into baskentler values (003,'Paris','Paris Saint','Kasvetli')",
                "insert into baskentler values (004,'Real Madrid','Real Madrid','Akdeniz')",
                "insert into baskentler values (005,'Ankara','Genclerbirligi','Karasal')"
        };
      for (String each:valuearr){
          st.executeUpdate(each);
      }

       String gorme="Select * from baskentler";

        ResultSet select1=st.executeQuery(gorme);

        while (select1.next()){

            System.out.println( select1.getInt(1)+" "+select1.getString(2)+" "+
                               select1.getString(3)+" "+ select1.getString(4));
        }

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        // update ismi kiev olan sehrin iklimini iliman yapalim

        String update1="update baskentler set iklim='Iliman' where  isim='kiev'";

        st.executeUpdate(update1);

         gorme="Select * from baskentler";

        ResultSet select2=st.executeQuery(gorme);

        while (select2.next()){

            System.out.println( select2.getInt(1)+" "+select2.getString(2)+" "+
                    select2.getString(3)+" "+ select2.getString(4));
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        // iklimi iliman olan  sehir kiev kayitlari siliniz

        String delete= "delete from baskentler where iklim='iliman' and isim='berlin'";

        st.executeUpdate(delete);

        ResultSet select3=st.executeQuery(gorme);

        while (select3.next()){

            System.out.println( select3.getInt(1)+" "+select3.getString(2)+" "+
                    select3.getString(3)+" "+ select3.getString(4));
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");


        // spor kulubu icinde 'ad' gecen kayiti NoFanatizm yazin


        String update2="update baskentler set sporKulubu='NoFanatizm' where sporKulubu like '%ad%'";

        st.executeUpdate(update2);



        // baskentler tablosunu siliniz

        String drop="drop table baskentler";

       st.executeUpdate(drop);


        con.close();
        st.close();
        select1.close();
        select3.close();
        select2.close();


    }
}
