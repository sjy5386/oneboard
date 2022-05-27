package com.sysbot32.oneboard.users;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("남성"), FEMALE("여성"), ETC("기타");

    private String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }
}
