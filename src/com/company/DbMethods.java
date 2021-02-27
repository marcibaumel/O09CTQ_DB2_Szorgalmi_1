package com.company;

import java.io.File;
import java.sql.*;

public class DbMethods {

    private Statement s = null;
    private Connection conn= null;

    private ResultSet rs= null;
    private PreparedStatement ps;

    public void Connect() {
        try {

            //String url= new File("src/panasz.db").getAbsolutePath();

            String url= "D:/Program Files (x86)/SQLite/panasz.db";
            conn = DriverManager.getConnection("jdbc:sqlite:"+url);
            SM("Connection EMP OK!");
            SM("=====================================\n");

        } catch (SQLException e) {

            SM("Sikertelen driver regisztráció \n"+e.getMessage());
        }

    }

    public void DisConnect(){
        try{
            conn.close();
            SM("Disconected");
        }catch (SQLException e){

        }
    }

    public void ReadAllDataFromTermek(){
        String nev="";
        int id=0;
        System.out.println("Termék List:");

        String sqlp="select TermekID, TermekNev from Termek";

        try{
            s=conn.createStatement();
            rs=s.executeQuery(sqlp);
            while(rs.next()){
                id=rs.getInt("TermekID");
                nev=rs.getString("TermekNev");
                SM(id +" "+nev+" ");
                SM("=====================================\n");
            }
        }catch (SQLException e){
            SM(e.getMessage());
        }
    }

    public void ReadAllDataFromPanasz(){

        String PanaszNev="", PanaszLeiras="", Datum="", Email="";
        int PanaszID=0, IDTermek=0;
        SM("=====================================\n");
        System.out.println("Panasz List: \n");

        String sqlp="select PanaszID, IDTermek, Email, PanaszCim, PanaszLeiras, Datum from Panasz";

        try{
            s=conn.createStatement();
            rs=s.executeQuery(sqlp);
            while(rs.next()){
                PanaszID=rs.getInt("PanaszID");
                IDTermek=rs.getInt("IDTermek");
                Email=rs.getString("Email");
                PanaszNev=rs.getString("PanaszCim");
                PanaszLeiras=rs.getString("PanaszLeiras");
                Datum= rs.getString("Datum");

                SM("ID:"+PanaszID +"\nTermek Azonosító: "+IDTermek+"\nBejelentő Email Címe: "+Email +"\nPanasz Név: "
                        +PanaszNev+"\nPanasz Leírás: "+PanaszLeiras +"\nRögzítés Dátuma: "+Datum+" ");

                SM("=====================================\n");
            }
        }catch (SQLException e){
            SM(e.getMessage());
        }
    }

    public void InsertNewPanasz(int PanaszID, int IDTermek, String Email, String PanaszCim, String PanaszLeiras, String Datum){
        String sqlp="insert into Panasz values (" +PanaszID+", '"+ IDTermek+"', '"+Email+"', '"+PanaszCim+"', '"+ PanaszLeiras+"', '"+ Datum +"')";
        try{
            s=conn.createStatement();
            s.execute(sqlp);
            SM("\nPanasz rögzítve!");

        }catch(SQLException e){
            SM("JDB Insert: "+ e.getMessage());
        }
    }

    public void Reg() {
        try {
            Class.forName("org.sqlite.JDBC");
            SM("Sikeres driver regisztráció");

        } catch (ClassNotFoundException e){

            SM("Sikertelen driver regisztráció"+e.getMessage());
        }

    }

    public int UniqueId(){
        int id=0;

        String sqlp="select count(*) from Panasz";
        try{
            s=conn.createStatement();
            rs=s.executeQuery(sqlp);
            while(rs.next()){
                //return rs.getInt(1);
                id++;
            }

        }catch (SQLException e){
            SM(e.getMessage());
        }
        id++;
        SM(""+id);
        return id;
    }

    public void SM(String msg)
    {
        System.out.println(msg);

    }


}
