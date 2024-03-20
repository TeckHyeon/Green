package com.bitc.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {

	private String drivers = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/testdb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	private String uid = "testuser";
	private String upw = "1234";

	public BoardDao() {
		try {
			Class.forName(drivers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BoardDto> selectBoardList() {
		ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM t_board where deleted_yn = 'N' ";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int idx = rs.getInt("idx");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String creatorId = rs.getString("creator_Id");
				String createdDate = rs.getString("created_date");
				String updateId = rs.getString("update_id");
				String updatedDate = rs.getString("updated_date");
				int hitCnt = rs.getInt("hit_cnt");
				String passwd = rs.getString("passwd");

				BoardDto item = new BoardDto();
				item.setIdx(idx);
				item.setTitle(title);
				item.setContents(contents);
				item.setCreatorId(creatorId);
				item.setCreatedDate(createdDate);
				item.setUpdateId(updateId);
				item.setUpdatedDate(updatedDate);
				item.setHitCnt(hitCnt);
				item.setPasswd(passwd);

				boardList.add(item);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return boardList;
	}

	public int boardInsert(BoardDto board) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "INSERT INTO t_board (title, contents, creator_id, created_date) values (?,?,?,NOW()) ";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContents());
			pstmt.setString(3, board.getCreatorId());

			result = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return result;
	}

	public int boardSelect(BoardDto board) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT idx, title, creator_id, hit_cnt, contents FROM t_board where idx = ? AND deleted_yn = 'N' ";

		String sqlCount = "UPDATE t_board SET hit_cnt = hit_cnt + 1 WHERE idx = ? AND deleted_yn = 'N' ";

		PreparedStatement pstmtCount = null;

		try {
			pstmtCount = conn.prepareStatement(sqlCount);
			pstmtCount.setInt(1, board.getIdx());
			pstmtCount.executeUpdate();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getIdx());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int idx = rs.getInt("idx");
				String title = rs.getString("title");
				String userId = rs.getString("creator_id");
				int hitcnt = rs.getInt("hit_cnt");
				String contents = rs.getString("contents");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (pstmtCount != null) {
					pstmtCount.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return result;
	}
}
