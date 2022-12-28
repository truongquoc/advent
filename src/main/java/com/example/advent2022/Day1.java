package com.example.advent2022;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Day1 extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        String calories  = """
                1000
                2000
                3000
                                
                4000
                                
                5000
                6000
                                
                7000
                8000
                9000
                                
                10000
                """;
        int mostCalories = 0;
        int totalCaloriesByElfCarrying = 0;

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("day1.txt")) {
            Scanner scanner = new Scanner(inputStream);

            while(scanner.hasNextLine()) {
                String calo = scanner.nextLine();
                if (calo.trim().isBlank()) {
                    if (mostCalories < totalCaloriesByElfCarrying) {
                        mostCalories = totalCaloriesByElfCarrying;
                    }

                    totalCaloriesByElfCarrying = 0;
                }

                totalCaloriesByElfCarrying+= calo.trim().isBlank()? 0 : Integer.parseInt(calo);
            }
        }

        System.out.println(String.format("The most calories carrying by elf is: %s", mostCalories));
        Thread.sleep(10000);
    }

    public enum EnumTest {
        ENTRY_1,
        ENTRY_2
    }

    public static void main(String[] args) {
        launch();
    }
}