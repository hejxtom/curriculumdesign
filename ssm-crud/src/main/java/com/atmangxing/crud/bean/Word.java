package com.atmangxing.crud.bean;

public class Word {
    private Integer wordId;

    private String wordName;

    private Integer classId;

    private Class aClass;

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName == null ? null : wordName.trim();
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Word(Integer wordId, String wordName, Integer classId) {
        this.wordId = wordId;
        this.wordName = wordName;
        this.classId = classId;
    }

    public  Word(){
        super();
    }

    @Override
    public String toString() {
        return "Word{" +
                "wordId=" + wordId +
                ", wordName='" + wordName + '\'' +
                ", classId=" + classId +
                ", aClass=" + aClass +
                '}';
    }
}