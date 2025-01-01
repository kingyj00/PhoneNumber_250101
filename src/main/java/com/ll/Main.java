package com.ll;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        App app = new App();
        app.run();
    }
}

class App {
    public void run(){
        System.out.println(" ================");
        System.out.println(" == 전화번호부 ==");
        System.out.println(" ================");

        Scanner scanner = new Scanner(System.in);

        int lastId = 0;

        while (true){
            System.out.print(" 입력 : ");
            String a = scanner.nextLine();

            if (a.equals("종료")) {
                break;
            } else if (a.equals("등록")){
                System.out.print("이름 :");
                String content = scanner.nextLine();
                System.out.print("번호 :");
                String author = scanner.nextLine();
                int id = ++lastId;
                System.out.println("%d번 번호가 등록되었습니다.".formatted(id));
                id++;
            }
        }
        scanner.close();
    }
}