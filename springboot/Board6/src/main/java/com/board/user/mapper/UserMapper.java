package com.board.user.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.user.domain.UserVo;

@Mapper
public interface UserMapper {

	List<UserVo> getUserList();

	void insertUser(UserVo userVo);

	HashMap<String, Object> getUserView(UserVo userVo);

	void signinUser(UserVo userVo);

	void DeleteUser(UserVo userVo);

	HashMap<String, Object> userUpdate(UserVo userVo);

	void updateUser(UserVo userVo);

	UserVo login(String userid, String passwd);

}
