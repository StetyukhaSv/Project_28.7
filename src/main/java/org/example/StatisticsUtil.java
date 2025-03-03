package org.example;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatisticsUtil {

    private static final Logger logger = Logger.getLogger(StatisticsUtil.class.getName());
    public static List<Statistics> createStatisticsList (List<Student> students, List<University> universities) {

        logger.log(Level.INFO, "Statistics started");

        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setProfile(profile);

            List<String> profileUniversityId = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());
            statistics.setNumberOfUniversity(profileUniversityId.size());
            statistics.setNameOfUniversity(StringUtils.EMPTY);

            universities.stream()
                    .filter(university -> profileUniversityId.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameOfUniversity -> statistics.setNameOfUniversity(statistics.getNameOfUniversity() + fullNameOfUniversity + ";"));

            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityId.contains(student.getUniversityId()))
                    .collect(Collectors.toList());

            statistics.setNumberOfStudents(profileStudents.size());

            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();

            statistics.setAvgExamScore(0);

            avgExamScore.ifPresent(score -> statistics.setAvgExamScore((float) BigDecimal.valueOf(score).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        logger.log(Level.INFO, "Statistics finished");
        return statisticsList;
    }
}
