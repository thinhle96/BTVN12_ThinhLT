package topica_itlab4.SpringBasic1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

public class JdbcStudentDAO implements StudentDAO {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Student students) {
		// TODO Auto-generated method stub
		String sqlCl = "INSERT INTO students (ID, Name, BirthOfDate, Gender) VALUES (?, ?, ?, ?)";
	    
		Connection conn = null;
		
	    try {
	    	conn = dataSource.getConnection();
	    	PreparedStatement preparedStmt = conn.prepareStatement(sqlCl);
		    System.out.println(students);
		    preparedStmt.setInt(1, students.getId());
		    preparedStmt.setString(2, students.getName());
		    preparedStmt.setString(3, students.getDateOfBirth());;
		    preparedStmt.setString(4, students.getGender());
					
		    preparedStmt.executeUpdate();
			
		    preparedStmt.close();
		} catch (SQLException e) {
				throw new RuntimeException(e);
		
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e){}
			}
		}	
	}
}

