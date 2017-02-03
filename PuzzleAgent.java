import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class PuzzleAgent extends SearchAgent{

	public static void main(String[] args) {
		PuzzleAgent agent = new PuzzleAgent();
        agent.solvePuzzle(args[0]);

	}

    void solvePuzzle(String initGoalFilePath){
        problem = new PuzzleProblem();

		ReadBoardFile(initGoalFilePath, problem);

        System.out.println("Starting search...");
        search();
        System.out.println("Search complete.");

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
        char[][] goalBoard = ((Board)problem.goalState).board;

        Board b = (Board)nd.state;
        int hCost = b.calcHeuristic( goalBoard );
        int gCost = nd.depth;
        int fCost = 0;


        fCost = gCost + fCost;

        for(int i = 0; i < ll.size(); i++){
            Node curNode = ll.get(i);
            int curNodeHCost = ((Board)curNode.state).calcHeuristic( goalBoard );
            int curNodeFCost = curNode.depth + curNodeHCost;

            if(fCost < curNodeFCost){
                ll.add(i, nd);
                return;
            }

        }

		ll.add(nd);

        //TODO: sort the fringe...
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
