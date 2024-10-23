package org.example;


public class Main {
    public static void main(String[] args) {
        University universityMSU = new University("1", "Lomonosov Moscow State University", "MSU", 1755, StudyProfile.LINGUISTICS);
        Student student1 = new Student("Ivanov Oleg Klementyevich", "1", 1, 4.3f);
        System.out.println(universityMSU);
        System.out.println(student1);
    }
}