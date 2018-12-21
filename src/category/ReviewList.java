package category;

import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import dao.ReviewDAO;
import dto.ReviewDTO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReviewList extends JFrame {

	JTable reviewTable;
	private JTextField searchTextField;
	private JScrollPane reviewScrolllPane;
	String[] col = { "글번호", "아이디", "제목", "내용", "평점" };
	DefaultTableModel model = new DefaultTableModel(col, 0) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	// 테이블에 데이터가 출력되면 클릭해서 정보를 수정 할수 없게 막는 메소드.

	public ReviewList() {
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);

		setTitle("후기게시판");
		setSize(915, 612);
		setVisible(true);

		getContentPane().setLayout(null);

		reviewTable = new JTable(model);
		reviewTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// mouseClicked 만 사용

				int r = reviewTable.getSelectedRow(); // 선택한 row(행)의 정보를 r에 담음
				String id = (String) reviewTable.getValueAt(r, 1); // 첫번째 column(열) 에 대한 id 정보를 담음
				String title = (String) reviewTable.getValueAt(r, 2);// 두번째 column(열) 에 대한 title 정보를 담음
				String content = (String) reviewTable.getValueAt(r, 3);// 세번째 column(열) 에 대한 content 정보를 담음
				String grade = (String) reviewTable.getValueAt(r, 4);// 네번째 column(열) 에 대한 grade 정보를 담음

				WatchReview watchReview = new WatchReview(id, title, content, grade, null);

			}
		});
		reviewTable.setForeground(Color.GRAY);
		reviewTable.setBackground(Color.WHITE);
		reviewTable.setFont(new Font("굴림", Font.PLAIN, 15));
		reviewTable.setBorder(new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(192, 192, 192)),
				new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(192, 192, 192)),
						new BevelBorder(BevelBorder.LOWERED, null, null, null, null))));

		reviewTable.setBounds(345, 140, 518, 370);
		reviewTable.setRowHeight(40);
		getContentPane().add(reviewTable);

		reviewScrolllPane = new JScrollPane(reviewTable);
		reviewScrolllPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		reviewScrolllPane.setLocation(344, 140);
		reviewScrolllPane.setSize(518, 370);
		getContentPane().add(reviewScrolllPane);

		// 테이블 내용 가운데 정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		TableColumnModel tcm = reviewTable.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		// 특정 열에 지정
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(4).setCellRenderer(dtcr);

		// 전체 열에 지정
		// for(int i = 0 ; i < tcm.getColumnCount() ; i++){
		// tcm.getColumn(i).setCellRenderer(dtcr);
		// 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여
		// 각각의 셀렌더러를 아까 생성한 dtcr에 set해줌
		// }

		reviewTable.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		reviewTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		reviewTable.getColumnModel().getColumn(0).setResizable(false);
		reviewTable.getColumnModel().getColumn(1).setPreferredWidth(5);
		reviewTable.getColumnModel().getColumn(1).setResizable(false);
		reviewTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		reviewTable.getColumnModel().getColumn(2).setResizable(false);
		reviewTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		reviewTable.getColumnModel().getColumn(3).setResizable(false);
		reviewTable.getColumnModel().getColumn(4).setPreferredWidth(1);
		reviewTable.getColumnModel().getColumn(4).setResizable(false);

//	      테이블 로우를 한개만 선택가능하게 한다. 이걸 사용하면 오직 한개의 로우만 선택할 수 있다
		reviewTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JComboBox searchComboBox = new JComboBox();
		searchComboBox.setBackground(Color.WHITE);
		searchComboBox.setForeground(Color.GRAY);
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] { "전체", "제목", "내용", "작성자(id)", "평점순" }));
		searchComboBox.setBounds(424, 520, 100, 34);
		getContentPane().add(searchComboBox);

		searchTextField = new JTextField();
		searchTextField.setBackground(Color.WHITE);
		searchTextField.setBounds(523, 520, 232, 35);
		getContentPane().add(searchTextField);
		searchTextField.setColumns(10);

		JButton searchButton = new JButton("검색");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (searchComboBox.getSelectedItem().equals("전체")) {
					// 전체 검색
					ReviewDAO dao = new ReviewDAO();
					ArrayList<ReviewDTO> list;
					try {
						list = dao.selectAll();

						int count = reviewTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
						for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
							model.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
						}

						for (int i = 0; i < list.size(); i++) {
							ReviewDTO dto = list.get(i);
							model.addRow(new Object[] { dto.getNum(), dto.getId(), dto.getTitle(), dto.getContent(),
									dto.getGrade() });

						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (searchComboBox.getSelectedItem().equals("작성자(id)")) {
					// 작성자로
					ReviewDAO dao = new ReviewDAO();
					ArrayList<ReviewDTO> list;
					try {

						list = dao.selectId(searchTextField.getText());

						int count = reviewTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
						for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
							model.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
						}

						for (int i = 0; i < list.size(); i++) {
							ReviewDTO dto = list.get(i);
							model.addRow(new Object[] { dto.getNum(), dto.getId(), dto.getTitle(), dto.getContent(),
									dto.getGrade() });

						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (searchComboBox.getSelectedItem().equals("제목")) {

					ReviewDAO dao = new ReviewDAO();
					ArrayList<ReviewDTO> list;
					try {

						list = dao.selectTitle(searchTextField.getText());

						int count = reviewTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
						for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
							model.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
						}

						for (int i = 0; i < list.size(); i++) {
							ReviewDTO dto = list.get(i);
							model.addRow(new Object[] { dto.getNum(), dto.getId(), dto.getTitle(), dto.getContent(),
									dto.getGrade() });

						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (searchComboBox.getSelectedItem().equals("내용")) {

					ReviewDAO dao = new ReviewDAO();
					ArrayList<ReviewDTO> list;
					try {

						list = dao.selectContent(searchTextField.getText());

						int count = reviewTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
						for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
							model.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
						}

						for (int i = 0; i < list.size(); i++) {
							ReviewDTO dto = list.get(i);
							model.addRow(new Object[] { dto.getNum(), dto.getId(), dto.getTitle(), dto.getContent(),
									dto.getGrade() });

						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (searchComboBox.getSelectedItem().equals("평점순")) {
					// 작성자로
					ReviewDAO dao = new ReviewDAO();
					ArrayList<ReviewDTO> list;
					try {

						list = dao.selectGrade();

						int count = reviewTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
						for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
							model.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
						}

						for (int i = 0; i < list.size(); i++) {
							ReviewDTO dto = list.get(i);
							model.addRow(new Object[] { dto.getNum(), dto.getId(), dto.getTitle(), dto.getContent(),
									dto.getGrade() });

						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		searchButton.setBackground(Color.WHITE);
		searchButton.setForeground(Color.GRAY);
		searchButton.setBounds(754, 520, 63, 34);
		getContentPane().add(searchButton);

		JLabel reviewListForm = new JLabel("");
		reviewListForm.setForeground(Color.WHITE);
		reviewListForm.setBackground(Color.WHITE);
		reviewListForm.setIcon(new ImageIcon("./img/home/reviewlist.png"));
		reviewListForm.setBounds(0, 0, 900, 572);
		getContentPane().add(reviewListForm);

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙

	}
}
