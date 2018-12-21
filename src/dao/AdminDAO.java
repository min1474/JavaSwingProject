package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dto.AdminDTO;


public class AdminDAO {

	String url = "jdbc:mysql://localhost:3306/rest";
	String user = "root";
	String password = "1234";
	String sql;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	// 회원가입
	public void insert(AdminDTO dto) {

		int idCnt = 0; // 중복되는 아이디의 갯수
		ArrayList userId = new ArrayList(); // DB에 저장되어있는 아이디를 ArrayList에 저장

		try {
			Class.forName("com.mysql.jdbc.Driver");// Exception 에러를 으로 예외처리
			System.out.println("1. 드라이버 셋팅 성공");

			// 2. DB연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. DB연결 성공");

			String id = "select * from adminmember";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(id);

			while (rs.next()) {
				userId.add(rs.getString(2)); // 2번째 값 = id
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
				sql = "insert into adminmember values(null, ?, ?, ?, ?, ? , ? ,?)";

				ps = con.prepareStatement(sql);
				System.out.println("3. sql문 연결 성공");
				// sql문을 인식하게 만드는 메소드

				ps.setString(1, dto.getId());// 입력받을 때 문자열(스트링)을 인식하게 만듬

				ps.setString(2, dto.getPw());

				ps.setString(3, dto.getName());

				ps.setString(4, dto.getEmail());

				ps.setString(5, dto.getTel());

				ps.setString(6, dto.getCode());

				ps.setString(7, dto.getAdmin());

				// 4. sql문 실행요청
				ps.executeUpdate();
				System.out.println("4. sql문 실행 완료");

			} catch (Exception e1) {
				e1.printStackTrace();
			}
	}

	// 1명의 회원에 대한 정보를 가져오는 메소드
	public AdminDTO select(String id) {

		AdminDTO dto = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			sql = "select * from adminmember where id = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {

				dto = new AdminDTO();
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setTel(rs.getString(6));
				dto.setCode(rs.getString(7));
				dto.setAdmin(rs.getString(8));
			}

		} catch (Exception e) {

		}
		return dto;
	}

	// 전체 회원정보를 가져오는 메소드
	public ArrayList<AdminDTO> selectAll() throws Exception {
		// selectAll 에서는 전체 리스트를 넘길것이기 때문에 입력값인 input이 없다.

		// 1.드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);

//		String input = JOptionPane.showInputDialog("아이디 입력");

		// 3.sql문 객체화

		sql = "select * from adminmember";
		PreparedStatement ps = con.prepareStatement(sql);

		// 4. sql문 실행 요청

		ResultSet rs = ps.executeQuery();

		AdminDTO dto = null;
		ArrayList<AdminDTO> list = new ArrayList<>();

		while (rs.next()) {// 커서를 옮겨서 레코드가 있는지 체크

			dto = new AdminDTO();

			String num = rs.getString(1);
			String id = rs.getString(2);
			String name = rs.getString(4);
			String email = rs.getString(5);
			String tel = rs.getString(6);

			dto.setNum(num);
			dto.setId(id);
			dto.setName(name);
			dto.setEmail(email);
			dto.setTel(tel);

			list.add(dto);
		}
		return list;
	}

	// 관리자가 일반회원을 관리자로 변경시 기존에 일반회원 테이블에서는 삭제하고 관리자테이블로 가입시키는 삭제 메소드
	public void delete(AdminDTO dto) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			System.out.println("db연결 성공");

			String sql = "delete from member where id = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getId());
			ps.executeUpdate();

		} catch (Exception e) {

		}

	}
	// 관리자 페이지에서 관리자를 삭제할 수 있는 메드
	public void deleteAdminMember(AdminDTO dto) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			System.out.println("db연결 성공");

			String sql = "delete from adminmember where id = ?";
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getId());
			ps.executeUpdate();


		} catch (Exception e) {

		}

	}

	// 로그인과 로그인 후 ID 연동을 위한 메소드
	public AdminDTO login(String id) {

		AdminDTO dto = null;

		try {
			// 커넥터 세팅
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("세팅 성공");

			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");

			sql = "select * from adminmember where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);

			// 실행 요청
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				dto = new AdminDTO();

				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
//				dto.setName(rs.getString(3));
//				dto.setTel(rs.getString(4));
//				dto.setEmail(rs.getString(6));
			}
			System.out.println("실행완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	public AdminDTO findPw(String id, String name, String tel, String code) throws Exception {

		AdminDTO dto;

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);

		sql = "select pw from adminmember where id = ? and name = ? and tel = ? and code = ?";

		ps = con.prepareStatement(sql);

		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, tel);
		ps.setString(4, code);

		rs = ps.executeQuery();

		dto = new AdminDTO();

		while (rs.next()) {

			dto.setPw(rs.getString(1));

		}
		return dto;

	}
	
	// 회원정보 수정에 대한 메소드(전화번호만)
	public void update(AdminDTO dto) {
		
		try {
			// 커넥터 세팅
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("세팅 성공");
			
			// DB 연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");
				

			sql = "update adminmember set pw=?, email = ?, tel = ?  where id=?";
			ps = con.prepareStatement(sql);

			ps.setString(1, dto.getPw());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getTel());
			ps.setString(4, dto.getId());
			
			// 실행 요청
			ps.executeUpdate();
			System.out.println("완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
