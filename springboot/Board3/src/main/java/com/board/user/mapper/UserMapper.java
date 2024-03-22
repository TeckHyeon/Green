package com.board.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.user.domain.UserVo;

@Mapper
public interface UserMapper {

	List<UserVo> viewUser();

	void signinUser(UserVo userVo);

	void DeleteUser(UserVo userVo);

	UserVo userDetail(String userid);

	void updateUser(UserVo userVo);

}









