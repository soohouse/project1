package kr.co.pr.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.co.pr.board.page.PageVO;


public class BoardDAO implements IBoardDAO {
	
	private DataSource ds;
	
	private BoardDAO() {
		try {
			InitialContext ct = new InitialContext();
			ds = (DataSource) ct.lookup("java:comp/env/jdbc/myOracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	

	@Override
	public void regist(String writer, String title, String content) {
		String sql = "INSERT INTO bbs(board_id, writer, title, content) VALUES(bbs_seq.NEXTVAL,?,?,?)";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public List<BoardVO> listBoard(PageVO paging) {
		List<BoardVO> articles = new ArrayList<>();
		String sql = "SELECT * FROM (SELECT ROWNUM AS rn, tbl.* FROM"
				+ "(SELECT * FROM bbs ORDER BY board_id DESC) tbl)"
				+ "WHERE rn >" +(paging.getPage()-1) * paging.getCountPerPage()
				+ "And rn <= " + (paging.getPage() * paging.getCountPerPage());
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
				ResultSet rs = pstmt.executeQuery(); 
			while(rs.next()) {
				BoardVO vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit")
						);
				articles.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articles;
	}

	@Override
	public BoardVO contentBoard(int bId) {
		BoardVO vo = null;
		String sql = "SELECT * FROM bbs WHERE board_id = ?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, bId);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVO(
						rs.getInt("board_id"),
						rs.getString("writer"),
						rs.getString("title"),
						rs.getString("content").replace("\r\n", "<br>"),
						rs.getTimestamp("reg_date"),
						rs.getInt("hit")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void updateBoard(String title, String content, int bId) {
		String sql = "UPDATE bbs SET title=?, content=? WHERE board_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteBoard(int bId) {
		String sql = "DELETE FROM bbs WHERE board_id=?";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, bId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void upHit(int bId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countArticles() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM bbs";
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	
}
