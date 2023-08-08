package com.count.icount.company.model.enums;


public enum UserType {
    ICOUNT("ICOUNT"),
    ICOUNT_MASTER("ICOUNT_MASTER"),
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
