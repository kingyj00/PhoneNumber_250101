package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main( String[] args){
        App app = new App();
        app.run();
    }
}

class App {
    public void run() {
        System.out.println(" ================");
        System.out.println(" == 전화번호부 ==");
        System.out.println(" ================");

        Scanner scanner = new Scanner(System.in);
        int lastId = 0;
        ArrayList<String> wiseSayings = new ArrayList<>();

        while (true) {
            System.out.print(" 입력 : ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print(" 이름 : ");
                String content = scanner.nextLine();
                System.out.print(" 전화번호 : ");
                String author = scanner.nextLine();
                int id = ++lastId;
                wiseSayings.add(id + "/" + content + "/" + author);
                System.out.println(" %d번에 번호가 등록되었습니다.".formatted(id));
            } else if (cmd.equals("목록")){
                System.out.println("번호 / 이름 / 전화번호");
                System.out.println("===================");
                for (int i = wiseSayings.size() - 1; i >=0; i--) {
                    System.out.println(wiseSayings.get(i));
                }
            }
        }
        scanner.close();
    }
}