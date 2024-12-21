package org.example;


import org.example.Comparator.StudentComparator;
import org.example.Comparator.UniversityComparator;
import org.example.Enum.ComparatorEnum;
import org.example.Enum.StudentComparatorEnum;
import org.example.Enum.UniversityComparatorEnum;
import io.XlsReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        University universityMSU = new University("1", "Lomonosov Moscow State University", "MSU", 1755, StudyProfile.LINGUISTICS);
//        Student student1 = new Student("Ivanov Oleg Klementyevich", "1", 1, 4.3f);
//        System.out.println(universityMSU);
//        System.out.println(student1);

        List<Student> studentINFO = new ArrayList<>(XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx"));
        StudentComparator studentComparator = ComparatorEnum.getStudentComparator(StudentComparatorEnum.FULL_NAME);
        studentINFO.stream().sorted(studentComparator).forEach(System.out::println);

        List<University> universityINFO = new ArrayList<>(XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx"));
        UniversityComparator universityComparator = ComparatorEnum.getUniversityComparator(UniversityComparatorEnum.YEAR_OF_FOUNDATION);
        universityINFO.stream().sorted(universityComparator).forEach(System.out::println);



    }
}