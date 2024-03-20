package com.kdh.dto;

import lombok.Data;

@Data
public class GametalkUserDto {
private int userIdx;
private String userId;
private String userPw;
private String userName;
private String userEmail;
private String userPhone;
private String userCreatedDate;
private String userUpdatedDate;
private String deletedYn;
}
