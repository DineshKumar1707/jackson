package demo;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonData {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonparser=new JSONParser();
		FileReader reader=new FileReader(".\\jsonfiles\\student.json");
		Object obj=jsonparser.parse(reader);
		JSONObject studentjsonobj=(JSONObject)obj;
		
		String sname=(String) studentjsonobj.get("StudentName");
		String semname=(String) studentjsonobj.get("SemesterName");
		
		System.out.println("Student Name:"+sname);
		System.out.println("Semester Name:"+semname);
		
		JSONArray arr=(JSONArray) studentjsonobj.get("sem1");
		
		for(int i=0;i<arr.size();i++) {
			JSONObject sem1=(JSONObject) arr.get(i);
			String sub1=(String) sem1.get("sub1");
			String sub2=(String) sem1.get("sub2");
			String sub3=(String) sem1.get("sub3");
			
			System.out.println("Subjects of"+i+"is........");
			System.out.println("Subject1 Name is"+sub1);
			System.out.println("Subject2 Name is"+sub2);
			System.out.println("Subject3 Name is"+sub3);
		}
	}

 }
