package studentservices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import studentmodel.studentmodel;




public class studentservice {
		private Connection conn;
		
		public studentservice(Connection conn) {
			super();
			this.conn = conn;
		}

		public boolean addstudent(studentmodel st) {
			boolean f = false;
			try {
				String sql = "insert into student (Rollno,name,email,branch) value(?,?,?,?)";
				PreparedStatement pmst = conn.prepareStatement(sql);
				pmst.setString(1, st.getRollno());
				pmst.setString(2, st.getName());
				pmst.setString(3, st.getEmail());
				pmst.setString(4, st.getBranch());
				int i = pmst.executeUpdate();
				if(i>0) {
					f = true;
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return f;
			
		}

		public List<studentmodel> getallstu(){
			List<studentmodel> std = new ArrayList<studentmodel>();
			studentmodel s = null;
			try {
				String sql = "select * from student";
				PreparedStatement pmst = conn.prepareStatement(sql);
				ResultSet rs = pmst.executeQuery();
				while (rs.next()) {
					s = new studentmodel();
//					rs.getInt(1);
					s.setRollno(rs.getString(2));
					s.setName(rs.getString(3));
					s.setEmail(rs.getString(4));
					s.setBranch(rs.getString(5));
					std.add(s);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return std;
		}
		
		public boolean deletestu(String Rollno) {
			boolean f = false;
			try {
				String sql = "delete from student where Rollno = ?";
				PreparedStatement pmst = conn.prepareStatement(sql);
				pmst.setString(1, Rollno);
				int i = pmst.executeUpdate();
				if(i==1) {
					f = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return f;
		}

		public boolean updatestu(studentmodel sm) {
			boolean f = false;
			try {
				String sql = "update student set name = ?,email = ?,branch =? where Rollno=?";
				PreparedStatement pmst = conn.prepareStatement(sql);
				pmst.setString(1, sm.getName());
				pmst.setString(2, sm.getEmail());
				pmst.setString(3, sm.getBranch());
				pmst.setString(4, sm.getRollno());
				int i = pmst.executeUpdate();
				if(i==1) {
					f = true;
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return f;
		}
			public studentmodel getbystu(String Rollno) {
				studentmodel s = null;
				try {
					String sql = "select * from student where Rollno =?";
					PreparedStatement pmst = conn.prepareStatement(sql);
					pmst.setString(1, Rollno);
					ResultSet rs = pmst.executeQuery();
					while(rs.next()) {
						s= new studentmodel();
						s.setRollno(rs.getString(1));
						s.setName(rs.getString(2));
						s.setEmail(rs.getString(3));
						s.setBranch(rs.getString(4));
						
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return s;
				
			}
		
	}
