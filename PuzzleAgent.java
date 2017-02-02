import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class PuzzleAgent extends SearchAgent{

	public static void main(String[] args) {
		PuzzleAgent agent = new PuzzleAgent();
        agent.SolvePuzzle(args[0]);

	}

    void SolvePuzzle(String initGoalFilePath){
        problem = new PuzzleProblem();

        tree = new LinkedList<Node>();
        fringe = new LinkedList<Node>();
        solution = new LinkedList();

		ReadBoardFile(initGoalFilePath, problem);

        fringe.add(new Node(problem.getInitialState()));

        while(fringe.size() > 0){

        }

        //agent.problem.getInitialState().show();
        //agent.problem.getGoalState().show();
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

	private static void ReadBoardFile(String initGoalFilePath, Problem problem){
		String initialStr, goalStr;
		String[] fileContents;

		fileContents = ReadFile(initGoalFilePath);

		initialStr = fileContents[1] + fileContents[2] + fileContents[3];
		initialStr = initialStr.replaceAll(" ", "");

		goalStr = fileContents[5] + fileContents[6] + fileContents[7];
		goalStr = goalStr.replaceAll(" ", "");

        problem.setInitialState(new Board(initialStr));
        problem.setGoalState(new Board(goalStr));

	}


	private static String[] ReadFile(String filePath){
		String fileContents = "";

		try {
			fileContents = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			System.out.println("Error reading file: " + filePath + ", exiting...");
			e.printStackTrace();
			System.exit(1);
		}

		return fileContents.split("\\R+");
	}

}
