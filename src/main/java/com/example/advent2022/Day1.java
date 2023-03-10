package com.example.advent2022;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws InterruptedException {
//        launch();
        int mostCalories = 0;
        int totalCaloriesByElfCarrying = 0;

        List<Integer> totalCaloriesCarryingbyElfArr = new ArrayList<>();

        try(InputStream inputStream = Day1.class.getClassLoader().getResourceAsStream("day1.txt")) {
            Scanner scanner = new Scanner(inputStream);

            while(scanner.hasNextLine()) {
                String calo = scanner.nextLine();
                if (calo.trim().isBlank()) {
                    if (mostCalories < totalCaloriesByElfCarrying) {
                        mostCalories = totalCaloriesByElfCarrying;
                    }

                    totalCaloriesCarryingbyElfArr.add(totalCaloriesByElfCarrying);
                    totalCaloriesByElfCarrying = 0;
                }

                totalCaloriesByElfCarrying+= calo.trim().isBlank()? 0 : Integer.parseInt(calo);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(totalCaloriesCarryingbyElfArr, Collections.reverseOrder());

        int totalTopThreeCalories = totalCaloriesCarryingbyElfArr.get(0) + totalCaloriesCarryingbyElfArr.get(1) + totalCaloriesCarryingbyElfArr.get(2);
        System.out.println(String.format("Top three calories carrying by elf: %s", totalTopThreeCalories));
        Thread.sleep(10000);
    }
}