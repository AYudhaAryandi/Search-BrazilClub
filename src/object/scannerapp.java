package object;

import java.util.Scanner;

public class scannerapp {
    public static Scanner scanner = new Scanner(System.in);
    public static String inputUser(String query){
        System.out.print(query + " : ");
        return scanner.nextLine();
    }
    public static void main(String[] args) {
        label:
        while (true){
            System.out.println("\n  SEARCH DATA FOOTBALL CLUBS FROM BRAZIL");
            System.out.println("---------------------------------------------");
            String result = inputUser("SEARCH CLUB ");

           Main main = new Main();
            model resultQuery = main.ResultData(result);
            if(resultQuery.getName() == null && resultQuery.getCode() == null && resultQuery.getCountry() == null){
                System.out.println("Data Kosong");
            } else {
                System.out.println("\n  Result Query");
                System.out.println("---------------------");
                System.out.println("name : " + resultQuery.getName());
                System.out.println("code : " + resultQuery.getCode());
                System.out.println("country : " + resultQuery.getCountry());
            }
//            System.out.println(" ");
//            String choose = inputUser("Mau memilih club yang lain? (y/n)");
//            if(choose.equals("n") || choose.equals("N")) {
//                break label;
//            }
        }
    }
}