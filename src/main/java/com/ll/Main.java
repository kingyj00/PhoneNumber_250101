package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main( String[] args){
        App app = new App();
        app.run();
    }
}

class WiseSaying {
    int id;
    String content;
    String author;

    //생정자 자동 생성 class WiseSaying -> 제너레이트
    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
}

class App {
    public void run() {
        System.out.println(" ================");
        System.out.println(" == 전화번호부 ==");
        System.out.println(" ================");
        Scanner scanner = new Scanner(System.in);
        int lastId = 0;
        ArrayList<WiseSaying> wiseSayings = new ArrayList<>();

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
                int id = wiseSayings.size() + 1;
                wiseSayings.add(new WiseSaying(id, content, author));
                System.out.println(" %d번에 명언이 등록되었습니다.".formatted(id));
            } else if (cmd.equals("목록")) {
                System.out.println("번호 / 이름 / 전화번호");
                System.out.println("===================");
                for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    System.out.println("%d / %s / %s".formatted(wiseSaying.id, wiseSaying.content, wiseSaying.author));
                }
            } else if (cmd.equals("삭제")) {
                System.out.print("삭제할 번호 : ");
                int deleteId = Integer.parseInt(scanner.nextLine());
                boolean found = false;

                for (int i = 0; i < wiseSayings.size(); i++) {
                    if (wiseSayings.get(i).id == deleteId) {
                        wiseSayings.remove(i);
                        System.out.println("%d번 전화번호가 삭제되었습니다.".formatted(deleteId));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("해당 번호에 저장된 전화번호가 없습니다.");
                } else {
                    for (int i = 0; i < wiseSayings.size(); i++) {
                        wiseSayings.get(i).id = i + 1;
                    }
                }
            } else if (cmd.equals("수정")) {
                // 명언 수정
                System.out.print("수정할 번호 : ");
                int updateId = Integer.parseInt(scanner.nextLine());
                boolean found = false;

                // 수정할 명언 찾기
                for (int i = 0; i < wiseSayings.size(); i++) {
                    if (wiseSayings.get(i).id == updateId) {
                        // 수정할 명언의 내용과 작가를 입력받음
                        System.out.print("새로운 이름 : ");
                        String newContent = scanner.nextLine();
                        System.out.print("새로운 전화번호 : ");
                        String newAuthor = scanner.nextLine();

                        // 수정된 내용으로 업데이트
                        wiseSayings.get(i).author = newAuthor;
                        wiseSayings.get(i).content = newContent;
                        System.out.println("%d번 전화번호가 수정되었습니다.".formatted(updateId));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("해당 번호에 저장된 전화번호가 없습니다.");
                }
            }
        }
        scanner.close();
    }
}