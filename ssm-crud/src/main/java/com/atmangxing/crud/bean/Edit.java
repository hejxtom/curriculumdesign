package com.atmangxing.crud.bean;

import org.springframework.web.multipart.MultipartFile;

public class Edit {
    private Integer id;

    private String wordId;

    private String stusId;

    private String edit;

    private String test;

    private Word word;
    private Student student;


    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId == null ? null : wordId.trim();
    }

    public String getStusId() {
        return stusId;
    }

    public void setStusId(String stusId) {
        this.stusId = stusId == null ? null : stusId.trim();
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit == null ? null : edit.trim();
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test == null ? null : test.trim();
    }

	public Edit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Edit(Integer id, String wordId, String stusId, String edit, String test) {
		super();
		this.id = id;
		this.wordId = wordId;
		this.stusId = stusId;
		this.edit = edit;
		this.test = test;
	}

	@Override
	public String toString() {
		return "Edit [id=" + id + ", wordId=" + wordId + ", stusId=" + stusId + ", edit=" + edit + ", test=" + test
				+ "]";
	}
    
}