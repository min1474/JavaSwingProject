package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dto.AdminDTO;
import dto.MemberDTO;
import home.SignUp;

public class MemberDAO {

	String url = "jdbc:mysql://localhost:3306/rest";
	String user = "root";
	String password = "1234";
	String sql;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	// 회원가입
	public void signUp(MemberDTO dto) {

		int idCnt = 0; // 중복되는 아이디의 갯수
		ArrayList userId = new ArrayList(); // DB에 저장되어있는 아이디를 ArrayList에 저장

		try {
			Class.forName("com.mysql.jdbc.Driver");// Exception 에러를 으로 예외처리
			System.out.println("1. 드라이버 셋팅 성공");

			// 2. DB연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. DB연결 성공");

			String id = "select * from member";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(id);

			while (rs.next()) {

				userId.add(rs.getString(2)); // 1번째 값 = id
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; i < userId.size(); i++) {
			if (dto.getId().equals(userId.get(i))) { // 만약 ArrayList에 id입력값과 일치하는 값이 들어있다면
				idCnt++; // cnt 1증가
			}
		}
		if (idCnt > 0) { // cnt가 0보다 크면 중복된 아이디가있기때문에 생성불가능.

			JOptionPane.showMessageDialog(null, "사용중인 아이디입니다.");

		} else // 중복이 없다면 가입 실행

			try {

				// 3. sql문 결정
				sql = "insert into member values(null, ?, ?, ?, ?, ?)";

				ps = con.prepareStatement(sql);
				System.out.println("3. sql문 연결 성공");
				// sql문을 인식하게 만드는 메소드

				ps.setString(1, dto.getId());// 입력받을 때 문자열(스트링)을 인식하게 만듬
				ps.setString(2, dto.getPw());
				ps.setString(3, dto.getName());
				ps.setString(4, dto.getTel());
				ps.setString(5, dto.getEmail());

				// 4. sql문 실행요청
				ps.executeUpdate();
				System.out.println("4. sql문 실행 완료");
				JOptionPane.showMessageDialog(null, "회원 가입 완료되었습니다.");

			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}

////	 회원가입에 대한 메소드
//	public void signUp(MemberDTO dto) {
//		try {
//			// 커넥터 세팅
//			Class.forName("com.mysql.jdbc.Driver");
//			System.out.println("세팅 성공");
//			
//			// DB 연결
//			con = DriverManager.getConnection(url, user, password);
//			System.out.println("연결 성공");
//			
//			sql = "insert into member(id, pw, name, tel, email) values (?,?,?,?,?)";
//			ps = con.prepareStatement(sql);
//
//			ps.setString(1, dto.getId());
//			ps.setString(2, dto.getPw());
//			ps.setString(3, dto.getName());
//			ps.setString(4, dto.getTel());
//			ps.setString(5, dto.getEmail());
//			
//			// 실행 요청
//			ps.executeUpdate();
//			System.out.println("실행완료");
//			
//			// 완료 후 메시지 출력
//			JOptionPane.showMessageDialog(null, "가입 되었습니다.");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// 로그인과 로그인 후 ID 연동을 위한 메소드
	public MemberDTO login(String id) {

		MemberDTO dto = null;

		try {
			// 커넥터 세팅
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("세팅 성공");

			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");

			sql = "select * from member where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			// 실행 요청
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				dto = new MemberDTO();
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setTel(rs.getString(5));
				dto.setEmail(rs.getString(6));
			}
			System.out.println("실행완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	// 회원정보 수정에 대한 메소드
	public void modifyInfo(MemberDTO dto) {

		try {
			// 커넥터 세팅
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("세팅 성공");

			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");

			sql = "update member set pw=?, tel=?, email=? where id=?";
			ps = con.prepareStatement(sql);

//			ps.setString(1, dto.getId());
			ps.setString(1, dto.getPw());
//			ps.setString(3, dto.getName());
			ps.setString(2, dto.getTel());
			ps.setString(3, dto.getEmail());
			ps.setString(4, dto.getId());

			// 실행 요청
			ps.executeUpdate();
			System.out.println("완료");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 1명의 회원에 대한 정보를 가져오는 메소드
	public MemberDTO select(String id) {

		MemberDTO dto = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			sql = "select * from member where id = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {

				dto = new MemberDTO();
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setTel(rs.getString(5));
				dto.setEmail(rs.getString(6));
			}

		} catch (Exception e) {

		}
		return dto;
	}

	// 전체 회원정보를 가져오는 메소드
	public ArrayList<MemberDTO> selectAll() throws Exception {
		// selectAll 에서는 전체 리스트를 넘길것이기 때문에 입력값인 input이 없다.

		// 1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

//		String input = JOptionPane.showInputDialog("아이디 입력");

		// 3.sql문 객체화

		sql = "select * from member";
		PreparedStatement ps = con.prepareStatement(sql);

		// 4. sql문 실행 요청

		ResultSet rs = ps.executeQuery();
		MemberDTO dto = null;
		ArrayList<MemberDTO> list = new ArrayList<>();

		while (rs.next()) {// 커서를 옮겨서 레코드가 있는지 체크

			dto = new MemberDTO();

			String num = rs.getString(1);
			String id = rs.getString(2);
			String name = rs.getString(4);
			String tel = rs.getString(5);
			String email = rs.getString(6);

			dto.setNum(num);
			dto.setId(id);
			dto.setName(name);
			dto.setTel(tel);
			dto.setEmail(email);

			list.add(dto);
		}
		return list;
	}

	// 회원 탈퇴(삭제 메소드)
	public void delete(MemberDTO dto) {

		try {
			// 커넥터 세팅
			Class.forName("com.mysql.jdbc.Driver");

			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("db연결 성공");

			sql = "delete from member where id = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getId());

			// 실행요청
			ps.executeUpdate();

			System.out.println("회원탈퇴처리 완료");

		} catch (Exception e) {

		}

	}

	// 비밀번호를 찾는 메소드
	public MemberDTO findPw(String id, String name, String email, String tel) throws Exception {

		MemberDTO dto;

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);

		sql = "select pw from member where id = ? and name = ? and email = ? and tel = ?";

		ps = con.prepareStatement(sql);

		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, email);
		ps.setString(4, tel);

		rs = ps.executeQuery();

		dto = new MemberDTO();

		while (rs.next()) {

			dto.setPw(rs.getString(1));

		}
		return dto;

	}

	// 특정 아이디가 들어간 관리자들을 전체 검색하는 메소드
	public ArrayList<MemberDTO> selectSomeId(String id) throws Exception {

		// 1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

		sql = "select * from member where id like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + id + "%");

		// 4. sql문 실행 요청

		MemberDTO dtoR = null;
		ArrayList<MemberDTO> list = new ArrayList<>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {// 커서를 옮겨서 레코드가 있는지 체크

			dtoR = new MemberDTO();

			dtoR.setNum(rs.getString(1));
			dtoR.setId(rs.getString(2));
			dtoR.setName(rs.getString(3));
			dtoR.setEmail(rs.getString(4));
			dtoR.setTel(rs.getString(5));

			list.add(dtoR);
		}
		return list;
	}

}
