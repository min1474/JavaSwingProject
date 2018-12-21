package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.ReviewDTO;
import home.Login;

import dto.MemberDTO;


public class ReviewDAO {

	String url = "jdbc:mysql://localhost:3306/rest";
	String user = "root";
	String password = "1234";
	String sql;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	

	public void insert(ReviewDTO dto) {

		try {

			Class.forName("com.mysql.jdbc.Driver");// Exception 에러를 으로 예외처리
			System.out.println("1. 드라이버 셋팅 성공");

			// 2. DB연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. DB연결 성공");

			// 3. sql문 결정
			String sql = "insert into review values(null, ?, ?, ?,?)";

			ps = con.prepareStatement(sql);
			System.out.println("3. sql문 연결 성공");
			// sql문을 인식하게 만드는 메소드

			ps.setString(1, dto.getId());// 입력받을 때 문자열(스트링)을 인식하게 만듬
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getGrade());

			// 4. sql문 실행요청
			ps.executeUpdate();
			System.out.println("4. sql문 실행 완료");

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	//마이페이지에서 로그인한 아이디에 대한 글 정보를 가져옴
	
	public ArrayList<ReviewDTO> select(MemberDTO dto) throws Exception{
		

		//1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		sql = "select * from review where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, Login.tosID );

		
		//4. sql문 실행 요청
		
		ReviewDTO dtoR = null;
		ArrayList<ReviewDTO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
			
			dtoR = new ReviewDTO();
		
			dtoR.setNum(rs.getString(1));
			dtoR.setId(rs.getString(2));
			dtoR.setTitle(rs.getString(3));
			dtoR.setContent(rs.getString(4));
			dtoR.setGrade(rs.getString(5));
			
			list.add(dtoR);
		}
		
		return list;
	}
	
	
	
	//전체 게시글을 가져오기
	public ArrayList<ReviewDTO> selectAll() throws Exception{
		
		//1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		
		//3.sql문 객체화
		
		sql = "select * from review";
		PreparedStatement ps = con.prepareStatement(sql);

		//4. sql문 실행 요청
		ResultSet rs = ps.executeQuery();
		ReviewDTO dto = null;
		ArrayList<ReviewDTO> list = new ArrayList<>();
		
		while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
			
			dto = new ReviewDTO();
			
			String num = rs.getString(1);
			String id= rs.getString(2);
			String title = rs.getString(3);
			String content = rs.getString(4);
			String grade = rs.getString(5);
			
			dto.setNum(num);
			dto.setId(id);
			dto.setGrade(grade);
			dto.setTitle(title);
			dto.setContent(content);
			
			list.add(dto);
		}
		return list;
	}
	
	//작성자로 검색시 해당하는 내용을 테이블로 출력할 수 있는 메소드
	public ArrayList<ReviewDTO> selectId(String id) throws Exception{
		

		//1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		sql = "select * from review where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);

		
		//4. sql문 실행 요청
		
		ReviewDTO dtoR = null;
		ArrayList<ReviewDTO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
			
			dtoR = new ReviewDTO();
		
			dtoR.setNum(rs.getString(1));
			dtoR.setId(rs.getString(2));
			dtoR.setTitle(rs.getString(3));
			dtoR.setContent(rs.getString(4));
			dtoR.setGrade(rs.getString(5));
			
			list.add(dtoR);
		}
		
		return list;
	}
	
	//제목을 검색시 해당하는 단어가 포함된 전체 가져오기
	public ArrayList<ReviewDTO> selectTitle(String title) throws Exception{
		

		//1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		sql = "select * from review where title like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+title+"%");

		
		//4. sql문 실행 요청
		
		ReviewDTO dtoR = null;
		ArrayList<ReviewDTO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
			
			dtoR = new ReviewDTO();
		
			dtoR.setNum(rs.getString(1));
			dtoR.setId(rs.getString(2));
			dtoR.setTitle(rs.getString(3));
			dtoR.setContent(rs.getString(4));
			dtoR.setGrade(rs.getString(5));
			
			list.add(dtoR);
		}
		return list;
	}
	
	//내용을 검색시 해당하는 단어가 포함된 글 전체 가져오기
	public ArrayList<ReviewDTO> selectContent(String content) throws Exception{
		

		//1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		sql = "select * from review where content like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%"+content+"%");

		
		//4. sql문 실행 요청
		
		ReviewDTO dtoR = null;
		ArrayList<ReviewDTO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
			
			dtoR = new ReviewDTO();
		
			dtoR.setNum(rs.getString(1));
			dtoR.setId(rs.getString(2));
			dtoR.setTitle(rs.getString(3));
			dtoR.setContent(rs.getString(4));
			dtoR.setGrade(rs.getString(5));
			
			list.add(dtoR);
		}
		return list;
	}
	
	//평점순 으로 검색시 높은 숫자에서 낮은 숫자로 해당하는 내용을 테이블로 출력할 수 있는 메소드
	public ArrayList<ReviewDTO> selectGrade() throws Exception{
		

		//1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		sql = "select * from review order by grade desc";
		PreparedStatement ps = con.prepareStatement(sql);

		
		//4. sql문 실행 요청
		
		ReviewDTO dtoR = null;
		ArrayList<ReviewDTO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
			
			dtoR = new ReviewDTO();
		
			dtoR.setNum(rs.getString(1));
			dtoR.setId(rs.getString(2));
			dtoR.setTitle(rs.getString(3));
			dtoR.setContent(rs.getString(4));
			dtoR.setGrade(rs.getString(5));
			
			list.add(dtoR);
		}
		
		return list;
	}
	
	// 글정보 수정에 대한 메소드
	public void update(ReviewDTO dto) {
		

		try {
			// 커넥터 세팅
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("세팅 성공");
			
			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
				

			sql = "update review set title=?, content=?, grade=? where num=? and id=?";
			
			ps = con.prepareStatement(sql);
				
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setString(3, dto.getGrade());
			ps.setString(4, dto.getNum());
			ps.setString(5, dto.getId());
			
			// 실행 요청
			ps.executeUpdate();
			System.out.println("완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//글 삭제 메소드
	public void delete(ReviewDTO dto) {

		try {
			// 커넥터 세팅
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("세팅 성공");
			
			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
				

			sql = "delete from review where num=? and id=?";
			
			ps = con.prepareStatement(sql);
				
			ps.setString(1, dto.getNum());
			ps.setString(2, dto.getId());
			
			// 실행 요청
			ps.executeUpdate();
			System.out.println("완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
