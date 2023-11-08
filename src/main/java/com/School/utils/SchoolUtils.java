package com.School.utils;

import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.enums.Sex;

import java.security.SecureRandom;


public class SchoolUtils {

    public static Department department(String department) {

        for (Department department1 : Department.values()) {
            if (department1.name().equalsIgnoreCase(department)) {
                return department1;
            }
        }
        return null;
    }

    public static Faculty faculty(String faculty) {
        for (Faculty faculty1 : Faculty.values()) {
            if (faculty1.name().equalsIgnoreCase(faculty)) {
                return faculty1;
            }
        }
        return null;
    }

    public static Sex sex(String sex) {
        for (Sex sex1 : Sex.values()) {
            if (sex1.name().equalsIgnoreCase(sex)) {
                return sex1;
            }
        }
        return null;
    }

    public static boolean validPhoneNumber(String phoneNumber) {
        String regex = "^(\\+234|0)[789]\\d{9}$";
        return phoneNumber.matches(regex);

    }


    public static Department department7(String department) {

        for (Department department1 : Department.values()) {
            if (department1.name().equalsIgnoreCase(department)) {
                return department1;
            }
        }
        return null;
    }


    public static String generateRegNo(String department) {
       // int codeCounter = 0;
        switch (department) {
            case "LAW":
                SecureRandom secureRandom = new SecureRandom();
                int lawRegNumber = secureRandom.nextInt(10000); // Generate a random 4-digit number

                return "2020/LAW/" + String.format("%04d", lawRegNumber);


            case "ELECTRICAL_ENGINEERING":

                SecureRandom electricalRandom = new SecureRandom();
                int electNumber = electricalRandom.nextInt(10000); // Generate a random 4-digit number

                return "2020/EEE/" + String.format("%04d", electNumber);


            case "EDUCATION_FOUNDATION":

                SecureRandom educationRandom = new SecureRandom();
                int eduNumber = educationRandom.nextInt(10000); // Generate a random 4-digit number

                return "2020/EDU/" + String.format("%04d", eduNumber);


            case "COMPUTER_ENGINEERING":

                SecureRandom computerRandom = new SecureRandom();
                int comNumber = computerRandom.nextInt(10000); // Generate a random 4-digit number

                return "2020/COM/" + String.format("%04d", comNumber);

          case "ELECTRONICS_ENGINEERING":

                SecureRandom electronicsRandom = new SecureRandom();
                int eceNumber = electronicsRandom.nextInt(10000); // Generate a random 4-digit number

                return "2020/ECE/" + String.format("%04d", eceNumber);

            default:
                throw new IllegalStateException("Unexpected value: " + department);
        }
    }


}









