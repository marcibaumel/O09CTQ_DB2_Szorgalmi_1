package com.company;

import com.sun.jdi.connect.Transport;
import java.util.Date;
import java.util.Properties;

public class Main {



    static DbMethods dbm= new DbMethods();
    static ConsoleMethods cm= new ConsoleMethods();

    public static void main(String[] args) {


        dbm.Reg();
        dbm.Connect();

        dbm.UniqueId();

        while(1!=0){
            menu();
        }
    }

    static void menu(){

        SM("\nMenü\n");

        dbm.SM("=====================================\n\n");
        dbm.SM("0.Kilépés \n");

        dbm.SM("1. Katalógus \n");

        dbm.SM("2. Panasz Lap \n");

        dbm.SM("3. Korábbi Panaszok Listázása \n");

        dbm.SM("4. Korábbi Panaszok Listázása Játék Szerint\n");

        String ms= cm.ReadData("Add meg a meg melyik funkciót akarod használni");
        int m= -1;

        if(test(ms, 0, 5))m = StringToInt(ms);
        switch(m){
            case 0:
                dbm.DisConnect();
                dbm.SM("A program leállt!");
                System.exit(0);
                break;
            case 1:
                Katalog();
                break;
            case 2:
                Panasz();
                break;
            case 3:
                KorabbiPanasz();
                break;
            case 4:
                KorabbiPanaszJatekSzerint();

        }

    }

    static void KorabbiPanaszJatekSzerint(){
        String IDTermek = cm.ReadData("Add meg a termék kódját: ");

        if(test(IDTermek,1, 11)){
            int Termek=StringToInt(IDTermek);
            dbm.ReadAllDataFromPanaszWhereTermekID(Termek);
        }
        else{
            //SM("Ilyen adat nincs a listában");
        }

    }

    static  void KorabbiPanasz(){
        dbm.ReadAllDataFromPanasz();
    }

    static void Katalog(){

        dbm.ReadAllDataFromTermek();

    }

    static void Panasz(){
        int PanaszID=dbm.UniqueId();
        String IDTermek = cm.ReadData("Add meg a termék kódját: ");
        String Email=cm.ReadData("Add meg az email címed: ");
        String PanaszCim=cm.ReadData("Adj címet a panaszra: ");
        String PanaszLeiras = cm.ReadData("Írd le pontosan a problémát: ");
        String Datum=cm.ReadData("Add meg mikor észlelted a hibát (formátum: yyyy.mm.dd.)");

        int Termek=StringToInt(IDTermek);

        dbm.InsertNewPanasz(PanaszID, Termek, Email, PanaszCim, PanaszLeiras, Datum );
    }

    static boolean test(String s, int min, int max){
        if(s.length() == 0){
            dbm.SM("Próbáld újra");
            return  false;
        }
        else{
            try{

                int x= Integer.valueOf(s);
                if(x>=min && x<max) return true;
                else{
                    dbm.SM("Nem megfelelő adat");
                    return false;
                }

            }catch (NumberFormatException nfe)
            {
                dbm.SM("Ez se jó");
                return false;
            }
        }
    }

    static boolean testID(String s){
        if(s.length() == 0){
            dbm.SM("Próbáld újra");
            return  false;
        }
        else{
            try{

                int x= Integer.valueOf(s);
                if(x>=1 && x<11) return true;
                else{
                    dbm.SM("Valami nem jó :(");
                    return false;
                }

            }catch (NumberFormatException nfe)
            {
                dbm.SM("Ez se jó");
                return false;
            }
        }
    }

    static int StringToInt(String s){
        int x= 0;
        try{
            x=Integer.valueOf(s);

        }catch (NumberFormatException nfe){}
        return x;
    }

    static void SM(String msg) {
        System.out.println(msg);

    }


}
