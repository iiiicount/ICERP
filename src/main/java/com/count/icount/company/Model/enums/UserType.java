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
        for(UserType userType : UserType.values()){
            if(userType.hasUserType(value)){
                return userType;
            }
        }

        return null;
    }

    private boolean hasUserType(String type){
        return this.userType.equals(type) || this.userType.equals(type.toUpperCase()) || this.userType.equals(type.toLowerCase());
    }

}
