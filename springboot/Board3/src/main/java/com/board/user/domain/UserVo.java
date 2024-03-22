package com.board.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
	// Field
	@NonNull
	private String userid;
	@NonNull
	private String passwd;
	@NonNull
	private String username;
	private String email;
	private int upoint;
	private String indate;
}
