package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.BookingDTO;
import dto.MemberDTO;
import dto.ReviewDTO;
import home.Login;

public class BookingDAO {
	
	String url = "jdbc:mysql://localhost:3306/rest";
	String user = "root";
	String password = "1234";
	String sql;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	//예약시 데이터베이스에 중복방지 sql문
	//테이블 번호,년,월 ,일,시간 중복 x
	//	예3)
	//	CREATE TABLE EMP (
	//	EMP_NO CHAR(20) NOT NULL,
	//	EMP_NAME CHAR(20)     NOT NULL,
	//	SALARY    NUMBER(4)     NOT NULL,
	//	JOB   CHAR(10),
	//	EMAIL    VARCHAR(50),
	//	PRIMARY KEY(EMP_NO,EMP_NAME )
	//	);
	
	//이미 컬럼이 만들어져 있는데 다중 기본키 또는 유니크키 를 설정하려면
	//ALTER TABLE EMP ADD PRIMARY KEY (EMP_NO, EMP_NAME);
	
	//	ALTER TABLE 테이블이름 ADD 필드이름 필드타입 UNIQUE
	//alter table booking add unique(tablenum, year, month, day, hour);



	
	//예약 메소드
	public void bookingInsert(BookingDTO dto) {
			

		try {
			
			Class.forName("com.mysql.jdbc.Driver");// Exception 에러를 으로 예외처리
			System.out.println("1. 드라이버 셋팅 성공");

			// 2. DB연결
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. DB연결 성공");

			// 3. sql문 결정
			String sql = "insert into booking values(null,?,?,?,?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);
			System.out.println("3. sql문 연결 성공");
			// sql문을 인식하게 만드는 메소드
			

			ps.setString(1, dto.getTableNum());
			ps.setString(2, dto.getId()); 
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getTel());
			ps.setString(5, dto.getPerson());
			ps.setString(6, dto.getYear());
			ps.setString(7, dto.getMonth());
			ps.setString(8, dto.getDay());
			ps.setString(9, dto.getHour());

			// 4. sql문 실행요청
			ps.executeUpdate();
			System.out.println("4. sql문 실행 완료");

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
		//한명의 아이디에 대한 예약 정보를 가져옴	
		public ArrayList<BookingDTO> select(MemberDTO dto) throws Exception{
			

			//1.드라이버 셋팅
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			sql = "select * from booking where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, Login.tosID );

			
			//4. sql문 실행 요청
			
			BookingDTO dtoB = null;
			ArrayList<BookingDTO> list = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
				
				dtoB = new BookingDTO();
				
				dtoB.setTableNum(rs.getString(2));
				dtoB.setId(rs.getString(3));
				dtoB.setName(rs.getString(4));
				dtoB.setTel(rs.getString(5));
				dtoB.setPerson(rs.getString(6));
				dtoB.setYear(rs.getString(7));
				dtoB.setMonth(rs.getString(8));
				dtoB.setDay(rs.getString(9));
				dtoB.setHour(rs.getString(10));
				
				list.add(dtoB);
			}
			
			return list;
		}
		
		//특정 날짜에 대한 예약정보를 검색하는 메소드
		public ArrayList<BookingDTO> selectDateTable1(BookingDTO dto) throws Exception{
			

			//1.드라이버 셋팅
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			sql = "select tablenum, id, name, tel, person, hour from booking where tablenum = 1 and year = ? and month = ? and day= ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getYear());
			ps.setString(2, dto.getMonth());
			ps.setString(3, dto.getDay());
			// SQL where절에 대한 검색 조건을 위해 넘겨받은 dto정보

			
			//4. sql문 실행 요청
			
			BookingDTO dtoB = null;
			ArrayList<BookingDTO> list = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
				
				dtoB = new BookingDTO();
			
				dtoB.setId(rs.getString(2));
				dtoB.setName(rs.getString(3));
				dtoB.setTel(rs.getString(4));
				dtoB.setPerson(rs.getString(5));
				dtoB.setHour(rs.getString(6));

				
				list.add(dtoB);
			}
			
			return list;
		}
		public ArrayList<BookingDTO> selectDateTable2(BookingDTO dto) throws Exception{
			

			//1.드라이버 셋팅
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			sql = "select tablenum, id, name, tel, person, hour from booking where tablenum = 2 and year = ? and month = ? and day= ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getYear());
			ps.setString(2, dto.getMonth());
			ps.setString(3, dto.getDay());
			// SQL where절에 대한 검색 조건을 위해 넘겨받은 dto정보

			
			//4. sql문 실행 요청
			
			BookingDTO dtoB = null;
			ArrayList<BookingDTO> list = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
				
				dtoB = new BookingDTO();
			
				dtoB.setId(rs.getString(2));
				dtoB.setName(rs.getString(3));
				dtoB.setTel(rs.getString(4));
				dtoB.setPerson(rs.getString(5));
				dtoB.setHour(rs.getString(6));

				
				list.add(dtoB);
			}
			
			return list;
		}
		public ArrayList<BookingDTO> selectDateTable3(BookingDTO dto) throws Exception{
			

			//1.드라이버 셋팅
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			sql = "select tablenum, id, name, tel, person, hour from booking where tablenum = 3 and year = ? and month = ? and day= ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getYear());
			ps.setString(2, dto.getMonth());
			ps.setString(3, dto.getDay());
			// SQL where절에 대한 검색 조건을 위해 넘겨받은 dto정보

			
			//4. sql문 실행 요청
			
			BookingDTO dtoB = null;
			ArrayList<BookingDTO> list = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
				
				dtoB = new BookingDTO();
			
				dtoB.setId(rs.getString(2));
				dtoB.setName(rs.getString(3));
				dtoB.setTel(rs.getString(4));
				dtoB.setPerson(rs.getString(5));
				dtoB.setHour(rs.getString(6));

				
				list.add(dtoB);
			}
			
			return list;
		}
		public ArrayList<BookingDTO> selectDateTable4(BookingDTO dto) throws Exception{
			

			//1.드라이버 셋팅
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);

			sql = "select tablenum, id, name, tel, person, hour from booking where tablenum = 4 and year = ? and month = ? and day= ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getYear());
			ps.setString(2, dto.getMonth());
			ps.setString(3, dto.getDay());
			// SQL where절에 대한 검색 조건을 위해 넘겨받은 dto정보

			
			//4. sql문 실행 요청
			
			BookingDTO dtoB = null;
			ArrayList<BookingDTO> list = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
				
				dtoB = new BookingDTO();
			
				dtoB.setId(rs.getString(2));
				dtoB.setName(rs.getString(3));
				dtoB.setTel(rs.getString(4));
				dtoB.setPerson(rs.getString(5));
				dtoB.setHour(rs.getString(6));

				
				list.add(dtoB);
			}
			
			return list;
		}
		
		
		
		//전체 예약을 가져오기
		public ArrayList<BookingDTO> selectAll() throws Exception{
			
			//1.드라이버 셋팅
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3.sql문 객체화
			
			sql = "select * from booking";
			PreparedStatement ps = con.prepareStatement(sql);

			//4. sql문 실행 요청
			rs = ps.executeQuery();
			BookingDTO dto = null;
			
			ArrayList<BookingDTO> list = new ArrayList<>();
			
			while(rs.next()) {//커서를 옮겨서 레코드가 있는지 체크
				
				dto = new BookingDTO();
				
				dto.setTableNum(rs.getString(2));
				dto.setId(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setTel(rs.getString(5));
				dto.setPerson(rs.getString(6));
				dto.setYear(rs.getString(7));
				dto.setMonth(rs.getString(8));
				dto.setDay(rs.getString(9));
				dto.setHour(rs.getString(10));
				
				list.add(dto);
			}
			return list;
		}
		
		//중복 예약 방지 메소드
		public BookingDTO selecDuplication(BookingDTO dto) throws Exception {
			//1.드라이버 셋팅
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			
			//3.sql문 객체화
			
			sql = "select * from booking where tablenum = ? and year = ? and month = ? and day = ? and hour = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getTableNum());
			ps.setString(2, dto.getYear());
			ps.setString(3, dto.getMonth());
			ps.setString(4, dto.getDay());
			ps.setString(5, dto.getHour());
			
			//4. sql문 실행 요청
			rs = ps.executeQuery();
			
			BookingDTO dtoB = new BookingDTO();
			if (rs.next()) {
				dtoB.setTableNum(rs.getString("tablenum"));
				dtoB.setYear(rs.getString("year"));
				dtoB.setMonth(rs.getString("month"));
				dtoB.setDay(rs.getString("day"));
				dtoB.setHour(rs.getString("hour"));
			}
			
			return dtoB;
		}
		
		
		// 관리자 페이지에서 내가 지정한 고객의 예약증 출력
		public ArrayList<BookingDTO> saveFile(BookingDTO dto_0) {

			ArrayList<BookingDTO> list = new ArrayList<>();
			try {
				// 1.드라이버 셋팅
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);

				// 3.sql문 객체화
				sql = "select * from booking where name = ? and tel = ? and year = ? and month = ? and day = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dto_0.getName());
				ps.setString(2, dto_0.getTel());
				ps.setString(3, dto_0.getYear());
				ps.setString(4, dto_0.getMonth());
				ps.setString(5, dto_0.getDay());

				// 4. sql문 실행 요청
				rs = ps.executeQuery();

				BookingDTO dto = null;
				while (rs.next()) {
					dto = new BookingDTO();

					dto.setTableNum(rs.getString("tablenum"));
					dto.setName(rs.getString("name"));
					dto.setTel(rs.getString("tel"));
					dto.setYear(rs.getString("year"));
					dto.setMonth(rs.getString("month"));
					dto.setDay(rs.getString("day"));
					dto.setHour(rs.getString("hour"));
					dto.setPerson(rs.getString("person"));

					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		

		// 관리자 페이지에서 전체 예약증 출력
		public ArrayList<BookingDTO> saveFileAll() {

			ArrayList<BookingDTO> list = new ArrayList<>();
			try {
				// 1.드라이버 셋팅
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);

				// 3.sql문 객체화
				sql = "select * from booking";
				PreparedStatement ps = con.prepareStatement(sql);

				// 4. sql문 실행 요청
				rs = ps.executeQuery();

				BookingDTO dto = null;
				while (rs.next()) {
					dto = new BookingDTO();

					dto.setTableNum(rs.getString("tablenum"));
					dto.setName(rs.getString("name"));
					dto.setTel(rs.getString("tel"));
					dto.setYear(rs.getString("year"));
					dto.setMonth(rs.getString("month"));
					dto.setDay(rs.getString("day"));
					dto.setHour(rs.getString("hour"));
					dto.setPerson(rs.getString("person"));

					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		
//		---------------------------------------------------------------------
		
		
		// 비회원 예약 페이지에서 예약 조회 버튼 클릭 시 정보 가져오는 메소드
		public BookingDTO searchBookingNonMember(BookingDTO dto) {
			BookingDTO dtoB = null;
			try {
				// 1.드라이버 셋팅
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);

				// 3.sql문 객체화

				sql = "select * from booking where year = ? and month = ? and day = ? and hour = ? and name = ? and tel= ? and id = ''";
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, dto.getYear());
				ps.setString(2, dto.getMonth());
				ps.setString(3, dto.getDay());
				ps.setString(4, dto.getHour());
				ps.setString(5, dto.getName());
				ps.setString(6, dto.getTel());

				// 4. sql문 실행 요청
				rs = ps.executeQuery();

				dtoB = new BookingDTO();
				if (rs.next()) {
					dtoB.setTableNum(rs.getString("tablenum"));
					dtoB.setYear(rs.getString("year"));
					dtoB.setMonth(rs.getString("month"));
					dtoB.setDay(rs.getString("day"));
					dtoB.setHour(rs.getString("hour"));
					dtoB.setName(rs.getString("name"));
					dtoB.setTel(rs.getString("tel"));
					dtoB.setPerson(rs.getString("person"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return dtoB;
		}

		// 비회원 예약증 출력 버튼 클릭할 때 파일 입출력에 사용되는 메소드
		public ArrayList<BookingDTO> saveFileInBookingPageNonMember(BookingDTO dtoB) {

			ArrayList<BookingDTO> list = new ArrayList<>();
			try {
				// 1.드라이버 셋팅
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);

				// 3.sql문 객체화
				sql = "select * from booking where name = ? and tel = ? and year = ? and month = ? and day = ? and hour = ? and id = ''";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dtoB.getName());
				ps.setString(2, dtoB.getTel());
				ps.setString(3, dtoB.getYear());
				ps.setString(4, dtoB.getMonth());
				ps.setString(5, dtoB.getDay());
				ps.setString(6, dtoB.getHour());

				// 4. sql문 실행 요청
				rs = ps.executeQuery();

				BookingDTO dto = null;
				while (rs.next()) {
					dto = new BookingDTO();

					dto.setTableNum(rs.getString("tablenum"));
					dto.setName(rs.getString("name"));
					dto.setTel(rs.getString("tel"));
					dto.setYear(rs.getString("year"));
					dto.setMonth(rs.getString("month"));
					dto.setDay(rs.getString("day"));
					dto.setHour(rs.getString("hour"));
					dto.setPerson(rs.getString("person"));

					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		// 비회원 예약 정보 삭제
		public void deleteInBookingInfoNonMember(BookingDTO dtoB) {
			try {
				// 1.드라이버 셋팅
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);

				// 3.sql문 객체화
				sql = "delete from booking where name = ? and tel = ? and year = ? and month = ? and day = ? and hour = ? and id = ''";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dtoB.getName());
				ps.setString(2, dtoB.getTel());
				ps.setString(3, dtoB.getYear());
				ps.setString(4, dtoB.getMonth());
				ps.setString(5, dtoB.getDay());
				ps.setString(6, dtoB.getHour());

				// 4. sql문 실행 요청
				ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
		//------------------------------------------------------------------
		
		
		// 회원 예약 페이지에서 예약 조회 버튼 클릭 시 정보 가져오는 메소드
		public BookingDTO searchBookingMember(BookingDTO dto) {
			BookingDTO dtoB = null;
			try {
				// 1.드라이버 셋팅
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);

				// 3.sql문 객체화

				sql = "select * from booking where year = ? and month = ? and day = ? and hour = ? and name = ? and tel= ? and id = ?";
				PreparedStatement ps = con.prepareStatement(sql);

				ps.setString(1, dto.getYear());
				ps.setString(2, dto.getMonth());
				ps.setString(3, dto.getDay());
				ps.setString(4, dto.getHour());
				ps.setString(5, dto.getName());
				ps.setString(6, dto.getTel());
				ps.setString(7, dto.getId());

				// 4. sql문 실행 요청
				rs = ps.executeQuery();

				dtoB = new BookingDTO();
				if (rs.next()) {
					dtoB.setId(rs.getString("id"));
					dtoB.setTableNum(rs.getString("tablenum"));
					dtoB.setYear(rs.getString("year"));
					dtoB.setMonth(rs.getString("month"));
					dtoB.setDay(rs.getString("day"));
					dtoB.setHour(rs.getString("hour"));
					dtoB.setName(rs.getString("name"));
					dtoB.setTel(rs.getString("tel"));
					dtoB.setPerson(rs.getString("person"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			return dtoB;
		}

		// 회원 예약 조회 후 예약증 출력 버튼 클릭할 때 파일 입출력에 사용되는 메소드
		public ArrayList<BookingDTO> saveFileInBookingPageMember(BookingDTO dtoB) {

			ArrayList<BookingDTO> list = new ArrayList<>();
			try {
				// 1.드라이버 셋팅
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);

				// 3.sql문 객체화
				sql = "select * from booking where name = ? and tel = ? and year = ? and month = ? and day = ? and hour = ? and id = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dtoB.getName());
				ps.setString(2, dtoB.getTel());
				ps.setString(3, dtoB.getYear());
				ps.setString(4, dtoB.getMonth());
				ps.setString(5, dtoB.getDay());
				ps.setString(6, dtoB.getHour());
				ps.setString(7, dtoB.getId());

				// 4. sql문 실행 요청
				rs = ps.executeQuery();

				BookingDTO dto = null;
				while (rs.next()) {
					dto = new BookingDTO();

					dto.setTableNum(rs.getString("tablenum"));
					dto.setName(rs.getString("name"));
					dto.setTel(rs.getString("tel"));
					dto.setYear(rs.getString("year"));
					dto.setMonth(rs.getString("month"));
					dto.setDay(rs.getString("day"));
					dto.setHour(rs.getString("hour"));
					dto.setPerson(rs.getString("person"));

					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		// 회원 예약 정보 삭제
		public void deleteInBookingInfoMember(BookingDTO dtoB) {
			try {
				// 1.드라이버 셋팅
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, password);

				// 3.sql문 객체화
				sql = "delete from booking where name = ? and tel = ? and year = ? and month = ? and day = ? and hour = ? and id = ?";
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, dtoB.getName());
				ps.setString(2, dtoB.getTel());
				ps.setString(3, dtoB.getYear());
				ps.setString(4, dtoB.getMonth());
				ps.setString(5, dtoB.getDay());
				ps.setString(6, dtoB.getHour());
				ps.setString(7, dtoB.getId());

				// 4. sql문 실행 요청
				ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
