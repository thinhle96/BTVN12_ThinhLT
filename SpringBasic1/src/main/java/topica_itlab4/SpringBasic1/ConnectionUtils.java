package topica_itlab4.SpringBasic1;
import java.sql.Connection;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ConnectionUtils {

	public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
		// Sử dụng mySQL
		// Bạn có thể thay thế bởi Database nào đó.
		return MySQLConnUtils.getMySQLConnection();
	}

	//
	// Test Connection ...
	//
	public static void main(String[] args) throws ParseException, SQLException, ClassNotFoundException {
			// TODO Auto-generated method stub
			
			ReadCSV readCSV = new ReadCSV();
			List<Student> students = readCSV.readStudentFromCSV("E:\\Java\\Students.csv");
			
			System.out.println("Get connection ... ");
			
		      // Lấy ra đối tượng Connection kết nối vào database.
		      Connection conn = ConnectionUtils.getMyConnection();
		 
		      System.out.println("Get connection " + conn);
		 
		      System.out.println("Done!");
		      
		      ApplicationContext context = 
		      		new ClassPathXmlApplicationContext("Spring-Module.xml");
		      StudentDAO studentDAO = (StudentDAO) context.getBean("studentDao");
		      for(Student b: students) {
		      Student student = new Student(b.getId(),b.getName(), b.getDateOfBirth(), b.getGender());
		      studentDAO.insert(student);
		
		     
			}
	}
}
