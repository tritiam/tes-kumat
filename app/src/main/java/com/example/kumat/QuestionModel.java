package com.example.kumat;

public class QuestionModel {
    private String question, option1, option2, option3, option4;
    private int questionImage, option1Image, option2Image, option3Image, option4Image;
    private int correctAnswer;

    public QuestionModel() {

    }

    public QuestionModel(String question, int questionImage,
                         String option1, int option1Image,
                         String option2, int option2Image,
                         String option3, int option3Image,
                         String option4, int option4Image,
                         int correctAnswer) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.questionImage = questionImage;
        this.option1Image = option1Image;
        this.option2Image = option2Image;
        this.option3Image = option3Image;
        this.option4Image = option4Image;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getQuestionImage() {
        return questionImage;
    }

    public void setQuestionImage(int questionImage) {
        this.questionImage = questionImage;
    }

    public int getOption1Image() {
        return option1Image;
    }

    public void setOption1Image(int option1Image) {
        this.option1Image = option1Image;
    }

    public int getOption2Image() {
        return option2Image;
    }

    public void setOption2Image(int option2Image) {
        this.option2Image = option2Image;
    }

    public int getOption3Image() {
        return option3Image;
    }

    public void setOption3Image(int option3Image) {
        this.option3Image = option3Image;
    }

    public int getOption4Image() {
        return option4Image;
    }

    public void setOption4Image(int option4Image) {
        this.option4Image = option4Image;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
