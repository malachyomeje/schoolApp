package com.School.utils;

import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.enums.Sex;


public class SchoolUtils {

   public static Department department (String department){

        for (Department department1 : Department.values()) {
            if (department1.name().equalsIgnoreCase(department)) {
                return department1;
            }
        }
        return null;
    }
    public static Faculty faculty (String faculty){
        for (Faculty faculty1 : Faculty.values()) {
            if (faculty1.name().equalsIgnoreCase(faculty)) {
                return faculty1;
            }
        }
        return null;
    }
    public static Sex sex (String sex){
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


    public static Department department7 (Department department){

        for (Department department1 : Department.values()) {
            if (department1.name().equalsIgnoreCase(department.toString())) {
                return department1;
            }
        }
        return null;
    }

}



