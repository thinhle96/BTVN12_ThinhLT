package topica_itlab4.SpringBasic1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {
	
	public List<Student> readStudentFromCSV(String fileName) throws ParseException{
	List<Student> students = new ArrayList<Student>();
	Path pathToFile = Paths.get(fileName);
	
	try (BufferedReader br = Files.newBufferedReader(pathToFile,
            StandardCharsets.US_ASCII)) {

        // read the first line from the text file
        String line = br.readLine();

        // loop until all lines are read
        while (line != null) {

            // use string.split to load a string array with the values from
            // each line of
            // the file, using a comma as the delimiter
            String[] attributes = line.split(",");
            Student student = createStudent(attributes);
            
            // adding book into ArrayList
            students.add(student);

            // read next line before looping
            // if end of file reached, line would be null
            line = br.readLine();
        }

    } catch (IOException ioe) {
        ioe.printStackTrace();
    }

    return students;
}

	private static Student createStudent(String[] metadata) throws ParseException {
		int id = Integer.parseInt(metadata[0]);
	    String name = metadata[1];
	    String dateOfBirth = metadata[2];
	    String gender = metadata[3];
	
	    // create and return student of this metadata
	    return new Student(id, name, dateOfBirth, gender);
	}

}



