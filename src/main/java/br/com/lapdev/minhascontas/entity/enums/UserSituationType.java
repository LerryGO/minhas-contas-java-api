package br.com.lapdev.minhascontas.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


public enum UserSituationType {
    ACTIVE("A", "Active"),
    INACTIVE("I", "Inactive"),
    PENDING("P", "Pending");

    private String code;
    private String description;

    UserSituationType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonCreator
    public static UserSituationType fromValue(String code){
        if(code.equalsIgnoreCase("A")){
            return ACTIVE;
        }else if(code.equalsIgnoreCase("I")){
            return INACTIVE;
        }else if(code.equalsIgnoreCase("P")){
            return PENDING;
        }else{
            return null;
        }
    }
}
