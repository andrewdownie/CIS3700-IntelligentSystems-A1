import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class PuzzleAgent extends SearchAgent{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(ReadFile(args[0]));
		

	}

	@Override
	void showSolution() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void showTree() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void insertFringe(Node nd, LinkedList<Node> ll) {
		// TODO Auto-generated method stub
		
	}
	
	
	private static String ReadFile(String filePath){
		String fileContents = "";
		
		try {
			fileContents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Error reading file: " + filePath + ", exiting...");
			e.printStackTrace();
			System.exit(0);
		}
		
		return fileContents;
	}

}
