package com.king;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KingApplication {

    public static void main(String[] args) {
        SpringApplication.run(KingApplication.class, args);

        System.out.println("                                    \n" +
                "       ,--.                                    \n" +
                "   ,--/  /|                                    \n" +
                ",---,': / '   ,--,                             \n" +
                ":   : '/ /  ,--.'|          ,---,              \n" +
                "|   '   ,   |  |,       ,-+-. /  |   ,----._,. \n" +
                "'   |  /    `--'_      ,--.'|'   |  /   /  ' / \n" +
                "|   ;  ;    ,' ,'|    |   |  ,\"' | |   :     | \n" +
                ":   '   \\   '  | |    |   | /  | | |   | .\\  . \n" +
                "|   |    '  |  | :    |   | |  | | .   ; ';  | \n" +
                "'   : |.  \\ '  : |__  |   | |  |/  '   .   . | \n" +
                "|   | '_\\.' |  | '.'| |   | |--'    `---`-'| | \n" +
                "'   : |     ;  :    ; |   |/        .'__/\\_: | \n" +
                ";   |,'     |  ,   /  '---'         |   :    : \n" +
                "'---'        ---`-'                  \\   \\  /  \n" +
                "                                      `--`-'   ");
    }
}
