package com.hackathon.chegg.Models;

public class TestModel {

    private String testTagName;
    private String date;
    private int marksScored;
    private int maxScore;

    TestModel(){}

    public TestModel(String testTagName, String date, int marksScored, int maxScore) {
        this.testTagName = testTagName;
        this.date = date;
        this.marksScored = marksScored;
        this.maxScore = maxScore;
    }

    public String getTestTagName() {
        return testTagName;
    }

    public void setTestTagName(String testTagName) {
        this.testTagName = testTagName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMarksScored() {
        return marksScored;
    }

    public void setMarksScored(int marksScored) {
        this.marksScored = marksScored;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
