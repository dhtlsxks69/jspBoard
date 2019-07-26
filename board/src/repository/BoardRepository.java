package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.Reply;
//save() 쓰기, update() 수정, findAll() 전체찾기, findById() 아이디찾기, findByIdAndPw() 아이디와 비밀번호 찾기, delete() 삭제
public class BoardRepository {
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// update(게시물수정)
	public int update(Board b) {

		final String SQL = "UPDATE board SET title = ?, content = ? WHERE id = ?";
		Connection conn = DBConnection.getConnection(); //DB연결
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,b.getTitle());
			pstmt.setString(2,b.getContent());
			pstmt.setInt(3,b.getNum());
			// rs = pstmt.executeQuery(); //select 할 때 쓰임 - 문장을 실행하고 결과를 보여줌
			int result = pstmt.executeUpdate(); // insert, delete, update 할 때 쓰임 - 문장을 실행하고 commit 해줌
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	//delete
	public int delete(int num){
		String sql = "DELETE FROM board WHERE num = ?";
		//Stream 연결 (java <-> DB) 선
		Connection conn = DBConnection.getConnection(); //DB연결
		
		try {
			//query를 적을 수 있게 준비 - 아직 query가 완성되지는 않았음.
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num); //문장완성
			int result = pstmt.executeUpdate(); //commit, rollback을 들고 있음.
			//result == 1이면 정상, 1이 아니면 비정상
			return result;
		} catch (Exception e) {
			e.printStackTrace(); //console창에서 오류 등을 확인할 수 있는 함수
		}
		return -1;
	} //end of delete
	
	//오버로딩
	public int save(Reply r){
		String sql = "INSERT INTO reply(username, boardId, content) VALUES(?,?,?)";
		//Stream 연결 (java <-> DB) 선
		Connection conn = DBConnection.getConnection(); //DB연결
		
		try {
			//query를 적을 수 있게 준비 - 아직 query가 완성되지는 않았음.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getUsername()); //문장완성
			pstmt.setInt(2, r.getBoardId());
			pstmt.setString(3, r.getContent());
			int result = pstmt.executeUpdate(); //commit, rollback을 들고 있음.
			//result == 1이면 정상, 1이 아니면 비정상
			return result;
		} catch (Exception e) {
			e.printStackTrace(); //console창에서 오류 등을 확인할 수 있는 함수
		}
		return -1;
	} //end of save
	
	//write
	public int save(Board b){
		String sql = "INSERT INTO board(username, title, content) VALUES(?,?,?)";
		//Stream 연결 (java <-> DB) 선
		Connection conn = DBConnection.getConnection(); //DB연결
		
		try {
			//query를 적을 수 있게 준비 - 아직 query가 완성되지는 않았음.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getUsername()); //문장완성
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			int result = pstmt.executeUpdate(); //commit, rollback을 들고 있음.
			//result == 1이면 정상, 1이 아니면 비정상
			return result;
		} catch (Exception e) {
			e.printStackTrace(); //console창에서 오류 등을 확인할 수 있는 함수
		}
		return -1;
	} //end of save
	
	//reply 댓글쓰기
		public List<Reply> findByBoardId(int boardId){
			String sql = "SELECT num, username, content, boardId FROM reply WHERE boardId = ?";
			Connection conn = DBConnection.getConnection();
			List<Reply> replys = new ArrayList<>();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardId);
				rs = pstmt.executeQuery(); //문장을 실행하고 결과를 보여줌.
				while (rs.next()){
					Reply r = new Reply();
					r.setNum(rs.getInt("num"));
					r.setUsername(rs.getString("username"));
					r.setContent(rs.getString("content"));
					r.setBoardId(rs.getInt("boardId"));
					replys.add(r);
				}
				return replys;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		} //end of findByBoardId
	
	//list
	public List<Board> findAll(){
		String sql = "SELECT num, title, username FROM board";
		Connection conn = DBConnection.getConnection();
		List<Board> boards = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //문장을 실행하고 결과를 보여줌.
			while (rs.next()){
				Board b = new Board();
				b.setNum(rs.getInt("num"));
				b.setTitle(rs.getString("title"));
				b.setUsername(rs.getString("username"));
				boards.add(b);
			}
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} //end of findAll
	
	//view
	public Board findByNum(int num){
		String sql = "SELECT num, title, username, content FROM board WHERE num = ?";
		Connection conn = DBConnection.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery(); //문장을 실행하고 결과를 보여줌.
			if(rs.next()){
				Board b = new Board();
				b.setNum(rs.getInt("num"));
				b.setTitle(rs.getString("title"));
				b.setUsername(rs.getString("username"));
				b.setContent(rs.getString("content"));
				return b;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} //end of findByNum
}
