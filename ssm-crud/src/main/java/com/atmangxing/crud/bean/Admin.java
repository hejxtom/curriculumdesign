package com.atmangxing.crud.bean;

public class Admin {
    private Integer sysId;

    private String sysUser;

    private String sysPass;

    private Integer wordId;
    private  Word word;

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Integer getSysId() {
        return sysId;
    }

    public void setSysId(Integer sysId) {
        this.sysId = sysId;
    }

    public String getSysUser() {
        return sysUser;
    }

    public void setSysUser(String sysUser) {
        this.sysUser = sysUser == null ? null : sysUser.trim();
    }

    public String getSysPass() {
        return sysPass;
    }

    public void setSysPass(String sysPass) {
        this.sysPass = sysPass == null ? null : sysPass.trim();
    }

    public Integer getWordId() {
        return wordId;
    }

    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }

    public  Admin(){
        super();
    }

    public Admin(Integer sysId, String sysUser, String sysPass, Integer wordId) {
        this.sysId = sysId;
        this.sysUser = sysUser;
        this.sysPass = sysPass;
        this.wordId = wordId;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "sysId=" + sysId +
                ", sysUser='" + sysUser + '\'' +
                ", sysPass='" + sysPass + '\'' +
                ", wordId=" + wordId +
                ", word=" + word +
                '}';
    }
}