package com.count.icount.company.Model.enums;

public enum UserType {
    MASTER("MASTER"),
    NORMAL("NORMAL"),
    BLOCKED("BLOCKED");


    private final String userType;
    UserType(String userType){
        this.userType = userType;
    }

    public String getType(){
        return this.userType;
    }

    public static UserType getUserType(String value){
        return UserType.valueOf(value.toUpperCase());
    }

}
