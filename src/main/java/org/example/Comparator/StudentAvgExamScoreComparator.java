package org.example.Comparator;

import org.example.Student;

public class StudentAvgExamScoreComparator implements StudentComparator {
    @Override
    public int compare(Student s1, Student s2) {

        return Float.compare(s2.getAvgExamScore(), s1.getAvgExamScore());
    }
}
