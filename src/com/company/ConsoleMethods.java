package com.company;
import java.util.Scanner;

public class ConsoleMethods {

    Scanner scanInput= new Scanner(System.in);

    public String ReadData(String s){
        String data="";
        System.out.println("\n"+s);
        data=scanInput.nextLine();
        return data;
    }

    public int ReadID(String s){
        int data;
        System.out.println(s);
        data = scanInput.nextInt();
        if(data<=0){
            return 0;
        }
        return data;
    }

}
