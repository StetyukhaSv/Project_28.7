package org.example;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("studentName")
    String fullName;
    @SerializedName("universityId")
    String universityId;
    @SerializedName("course")
    int currentCourseNumber;
    @SerializedName("score")
    float avgExamScore;

    public Student() {
    }

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;

        return this;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public String toString() {
        return "Student {" +
                "fullName = '" + fullName + '\'' +
                ", universityId = '" + universityId + '\'' +
                ", currentCourseNumber = " + currentCourseNumber +
                ", avgExamScore = " + avgExamScore +
                '}';
    }
}
