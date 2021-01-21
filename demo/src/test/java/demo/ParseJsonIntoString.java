package demo;

//import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.codehaus.jackson.JsonNode;
//import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import com.github.opendevl.JFlat;

public class ParseJsonIntoString {

	public static void main(String[] args) throws Exception {
		JSONParser jsonparser=new JSONParser();
		FileReader reader=new FileReader(".\\jsonfiles\\student.json");
		Object obj=jsonparser.parse(reader);
		JSONObject studentjsonobj=(JSONObject)obj;
		
		String file=".\\jsonfiles\\student.json";
		String json= readFileAsString(file);
		ObjectMapper mapper=new ObjectMapper();
		ObjectNode node=(ObjectNode)mapper.readTree(json);
		JsonNode arrayNode=node.get("students");
		ArrayList<String> students=mapper.readValue(arrayNode.traverse(), new TypeReference<ArrayList<String>>(){});
		System.out.println("The Student details with subject details are being converted into a list of string:");
		System.out.println(students);
		
		
		JSONArray arr=(JSONArray) studentjsonobj.get("students");
		System.out.println();
		System.out.println("Student mark list are being converted into list of object:");
		for(int i=0;i<arr.size();i++) {
			JSONObject students1=(JSONObject) arr.get(i);
			String sname=(String) students1.get("name");
			String rno=(String) students1.get("rollno");
			String sem1mark1=(String) students1.get("sem1_sub1_mark");
			String sem1mark2=(String) students1.get("sem1_sub2_mark");
			String sem1mark3=(String) students1.get("sem1_sub3_mark");
			String sem1tot=(String) students1.get("sem1_tot");
			String sem1grade=(String) students1.get("sem1_grade");
			String sem2mark1=(String) students1.get("sem2_sub1_mark");
			String sem2mark2=(String) students1.get("sem2_sub2_mark");
			String sem2mark3=(String) students1.get("sem2_sub3_mark");
			String sem2tot=(String) students1.get("sem2_tot");
			String sem2grade=(String) students1.get("sem2_grade");
			String sem3mark1=(String) students1.get("sem3_sub1_mark");
			String sem3mark2=(String) students1.get("sem3_sub2_mark");
			String sem3mark3=(String) students1.get("sem3_sub3_mark");
			String sem3tot=(String) students1.get("sem3_tot");
			String sem3grade=(String) students1.get("sem3_grade");
			
			System.out.println("student name is:"+sname);
			System.out.println("student rollno is:"+rno);
			System.out.println("semester 1, subject 1 mark is:"+sem1mark1);
			System.out.println("semester 1, subject 2 mark is:"+sem1mark2);
			System.out.println("semester 1, subject 3 mark is:"+sem1mark3);
			System.out.println("semester 1 total mark is:"+sem1tot);
			System.out.println("semester 1 grade is:"+sem1grade);
			System.out.println("semester 2, subject 1 mark is:"+sem2mark1);
			System.out.println("semester 2, subject 2 mark is:"+sem2mark2);
			System.out.println("semester 2, subject 3 mark is:"+sem2mark3);
			System.out.println("semester 2 total mark is:"+sem2tot);
			System.out.println("semester 2 grade is:"+sem2grade);
			System.out.println("semester 3, subject 1 mark is:"+sem3mark1);
			System.out.println("semester 3, subject 2 mark is:"+sem3mark2);
			System.out.println("semester 3, subject 3 mark is:"+sem3mark3);
			System.out.println("semester 3 total mark is:"+sem3tot);
			System.out.println("semester 3 grade is:"+sem3grade);
		}
		System.out.println("All the details are exported to the csv/excel file.......");
		String str=new String(Files.readAllBytes(Paths.get(".\\jsonfiles\\student.json")));
		JFlat flatMe=new JFlat(str);
		flatMe.json2Sheet().headerSeparator("_").getJsonAsSheet();
		flatMe.write2csv(".\\xmlfiles\\input.csv");
	} 

	private static String readFileAsString(String file) throws IOException {
		// TODO Auto-generated method stub
		return new String(Files.readAllBytes(Paths.get(file)));
	}

}
