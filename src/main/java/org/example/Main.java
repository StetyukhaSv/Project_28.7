package org.example;


import org.example.Comparator.StudentComparator;
import org.example.Comparator.UniversityComparator;
import org.example.Enum.ComparatorEnum;
import org.example.Enum.StudentComparatorEnum;
import org.example.Enum.UniversityComparatorEnum;
import org.example.Xls.XlsReader;
import org.example.Xls.XlsWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws IOException {
//        University universityMSU = new University("1", "Lomonosov Moscow State University", "MSU", 1755, StudyProfile.LINGUISTICS);
//        Student student1 = new Student("Ivanov Oleg Klementyevich", "1", 1, 4.3f);
//        System.out.println(universityMSU);
//        System.out.println(student1);

        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        }
        catch (IOException e) {
            System.err.println("The registrar configuration could not be configured - " + e);
        }

        logger.log(Level.INFO, "The application is running");

        //List<Student> studentINFO = new ArrayList<>(XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx"));
        List<Student> studentINFO = XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = ComparatorEnum.getStudentComparator(StudentComparatorEnum.FULL_NAME);
        studentINFO.sort(studentComparator);
//        studentINFO.stream().sorted(studentComparator).forEach(System.out::println);
//        String studentsJson = JsonUtil.studentListToJson(studentINFO);
//        System.out.println(studentsJson);
//        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
//        System.out.println(studentINFO.size() == studentsFromJson.size());
//        studentINFO.forEach(student -> {
//            String studentJson = JsonUtil.studentToJson(student);
//            System.out.println(studentJson);
//            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
//            System.out.println(studentFromJson);
//        });


        //List<University> universityINFO = new ArrayList<>(XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx"));
        List<University> universityINFO = XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = ComparatorEnum.getUniversityComparator(UniversityComparatorEnum.YEAR_OF_FOUNDATION);
        universityINFO.sort(universityComparator);
//        universityINFO.stream().sorted(universityComparator).forEach(System.out::println);
//        String universityJson = JsonUtil.universityListToJson(universityINFO);
//        System.out.println(universityJson);
//        List<University> universitiesFromJson = JsonUtil.jsonToUniversitiesList(universityJson);
//        System.out.println(universityINFO.size() == universitiesFromJson.size());
//        universityINFO.forEach(university -> {
//             String university_Json = JsonUtil.universityToJson(university);
//            System.out.println(university_Json);
//            University universityFromJson = JsonUtil.jsonToUniversity(university_Json);
//            System.out.println(universityFromJson);
//        });
        List<Statistics> statisticsList = StatisticsUtil.createStatisticsList(studentINFO, universityINFO);
        XlsWriter.statisticsWriter(statisticsList, "statisticsList.xlsx");

        logger.log(Level.INFO, "The application is finished");
    }
}