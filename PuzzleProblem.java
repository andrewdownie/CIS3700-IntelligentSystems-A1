import java.util.LinkedList;

public class PuzzleProblem extends Problem{

	@Override
	LinkedList getSuccessor(ObjectPlus s) {
        LinkedList<ObjectPlus> successors = new LinkedList<ObjectPlus>();

        Board b = (Board)s;

        Board left, right, up, down;

        left = new Board(b);
        right = new Board(b);
        up = new Board(b);
        down = new Board(b);

        if(left.MoveLeft()){
            successors.add(left);
        }

        if(right.MoveRight()){
            successors.add(right);
        }

        if(up.MoveUp()){
            successors.add(up);
        }

        if(down.MoveDown()){
            successors.add(down);
        }

        //TODO: add to list in order of their heuristic
        

		return successors;
	}

	@Override
	boolean isGoalState(ObjectPlus s) {
        Board b = (Board)s;

        boolean isGoal =  b.IsGoal((Board)goalState);

        System.out.println(isGoal);

		return isGoal;
	}

}
