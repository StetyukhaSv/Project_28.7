package org.example.Enum;

import org.example.Comparator.StudentAvgExamScoreComparator;
import org.example.Comparator.StudentComparator;
import org.example.Comparator.StudentCurrentCourseNumberComparator;
import org.example.Comparator.StudentFullNameComparator;
import org.example.Comparator.StudentUniversityIdComparator;
import org.example.Comparator.UniversityComparator;
import org.example.Comparator.UniversityFullNameComparator;
import org.example.Comparator.UniversityIdComparator;
import org.example.Comparator.UniversityMainProfileComparator;
import org.example.Comparator.UniversityShortNameComparator;
import org.example.Comparator.UniversityYearOfFoundationComparator;

public class ComparatorEnum {
    private ComparatorEnum() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorEnum studentComparatorEnum) {
        if(studentComparatorEnum.equals(StudentComparatorEnum.FULL_NAME)) {
            return new StudentFullNameComparator();
        }
        else if(studentComparatorEnum.equals(StudentComparatorEnum.UNIVERSITY_ID)) {
            return new StudentUniversityIdComparator();
        }
        else if(studentComparatorEnum.equals(StudentComparatorEnum.CURRENT_COURSE_NUMBER)) {
            return new StudentCurrentCourseNumberComparator();
        }
        else {
            return new StudentAvgExamScoreComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorEnum universityComparatorEnum) {
        if(universityComparatorEnum.equals(UniversityComparatorEnum.ID)) {
            return new UniversityIdComparator();
        }
        else if(universityComparatorEnum.equals(UniversityComparatorEnum.FULL_NAME)) {
            return new UniversityFullNameComparator();
        }
        else if(universityComparatorEnum.equals(UniversityComparatorEnum.SHORT_NAME)) {
            return new UniversityShortNameComparator();
        }
        else if(universityComparatorEnum.equals(UniversityComparatorEnum.YEAR_OF_FOUNDATION)) {
            return new UniversityYearOfFoundationComparator();
        }
        else {
            return new UniversityMainProfileComparator();
        }
    }

}
