import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class PuzzleAgent extends SearchAgent{

	public static void main(String[] args) {
		String[] fileContents = ReadFile(args[0]);
		
		String initialStr, goalStr;
		
		initialStr = fileContents[1] + fileContents[2] + fileContents[3];
		initialStr = initialStr.replaceAll(" ", "");
		
		goalStr = fileContents[5] + fileContents[6] + fileContents[7];
		goalStr = goalStr.replaceAll(" ", "");
		
		System.out.println("Initial board: " + initialStr);
		System.out.println("Goal board: " + goalStr);

		
		Board initial, goal;
		
		initial = new Board(initialStr);
		initial.show();
		
		goal = new Board(goalStr);
		goal.show();
		
		

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
	
	
	
	private static String[] ReadFile(String filePath){
		String fileContents = "";
		
		try {
			fileContents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Error reading file: " + filePath + ", exiting...");
			e.printStackTrace();
			System.exit(0);
		}
		
		return fileContents.split("\\R+");
	}

}
