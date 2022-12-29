package com.example.advent2022;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day2  {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> point = new HashMap<>();
        point.put("AX", 4);
        point.put("AY", 8);
        point.put("AZ", 3);
        point.put("BX", 1);
        point.put("BY", 5);
        point.put("BZ", 9);
        point.put("CX", 7);
        point.put("CY", 2);
        point.put("CZ", 6);
        int score = 0;

        try (InputStream inputStream = Day2.class.getClassLoader().getResourceAsStream("day2.txt")) {
            Scanner scanner = new Scanner(inputStream);

            while(scanner.hasNextLine()) {
                String round  = scanner.nextLine().trim().replaceAll("\\s+", "");;
                System.out.println(String.format("round %s: %s", round, point.get(round)));
                score+= point.get(round);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(String.format("total score %s", score));
    }
}
