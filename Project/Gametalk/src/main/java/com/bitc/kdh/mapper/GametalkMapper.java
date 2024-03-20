package com.bitc.kdh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.kdh.dto.GametalkPostDto;
import com.bitc.kdh.dto.GametalkPostFileDto;
import com.bitc.kdh.dto.GametalkUserDto;
import com.bitc.kdh.dto.GametalkfollowDto;

@Mapper
public interface GametalkMapper {

	void signinUser(GametalkUserDto user) throws Exception;

	int selectMemberInfoYn(@Param("userId")String userId, @Param("userPw") String userPw) throws Exception;

	GametalkUserDto selectUser(GametalkUserDto userdto) throws Exception;

	List<GametalkPostDto> viewPost(String userId) throws Exception;

	void createPost(GametalkPostDto posts) throws Exception;

	GametalkUserDto loadUsers(String userId) throws Exception;

	GametalkUserDto myPage(String userName) throws Exception;

	GametalkUserDto profileEdit(String userId) throws Exception;

	void passwordEdit(GametalkUserDto users) throws Exception;

	void infoEdit(GametalkUserDto users) throws Exception;

	void createPostFileList(List<GametalkPostFileDto> list) throws Exception;

	GametalkPostFileDto postFileInfo(@Param("postfileIdx")int postfileIdx, @Param("postIdx") int postIdx);

	List<GametalkPostFileDto> postFileList(int postIdx) throws Exception;

	List<GametalkfollowDto> loadfollow(String userId) throws Exception;

	List<GametalkPostFileDto> viewPostFileList(int postIdx) throws Exception;

}
