import java.util.*;

public class HeuristicLibrary {

    final private String[] validMoves = {"UP", "UP_RIGHT", "RIGHT", "DOWN_RIGHT", "DOWN", "DOWN_LEFT", "LEFT", "UP_LEFT"};
    final private Integer[] goalState = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0};
    final private HashMap<String, Integer> moveValue = new HashMap<>();
    final private HashMap<Integer, Character> solutionValue = new HashMap<>();

    private ArrayList<StateSpace> openList = new ArrayList<StateSpace>();
    private ArrayList<StateSpace> closedList = new ArrayList<StateSpace>();

    public void initializeMoveValue(){
        moveValue.put("UP",8);
        moveValue.put("UP_RIGHT",7);
        moveValue.put("RIGHT",6);
        moveValue.put("DOWN_RIGHT",5);
        moveValue.put("DOWN",4);
        moveValue.put("DOWN_LEFT",3);
        moveValue.put("LEFT",2);
        moveValue.put("UP_LEFT",1);
    }

    public void initializeSolutionValue(){
        solutionValue.put(0,'a');
        solutionValue.put(1,'b');
        solutionValue.put(2,'c');
        solutionValue.put(3,'d');
        solutionValue.put(4,'e');
        solutionValue.put(5,'f');
        solutionValue.put(6,'g');
        solutionValue.put(7,'h');
        solutionValue.put(8,'i');
        solutionValue.put(9,'j');
        solutionValue.put(10,'k');
        solutionValue.put(11,'l');
    }

    public boolean containsState(Integer table[], ArrayList<StateSpace> stateSpace){
        for(StateSpace temp: stateSpace){
            if(Arrays.equals(temp.getTable(), table)){
                return true;
            }
        }
        return false;
    }

    public Integer[] UP(Integer table[], int blankPosition) {
        Integer tempTable[] = table.clone();
        Integer[] invalidPositions = {0, 1, 2, 3};

        if(contains(invalidPositions, blankPosition)){
            return null;
        }

        int temp = tempTable[blankPosition-4];
        tempTable[blankPosition] = temp;
        tempTable[blankPosition-4] = 0;
        // System.out.println("UP" + Arrays.toString(tempTable));

        if(containsState(tempTable, openList) == true || containsState(tempTable, closedList) == true){
            return null;
        }
        return tempTable;
    }

    public Integer[] UP_RIGHT(Integer table[], int blankPosition) {
        Integer tempTable[] = table.clone();
        Integer[] invalidPositions = {0, 1, 2, 3, 7, 11};

        if(contains(invalidPositions, blankPosition)){
            return null;
        }

        int temp = tempTable[blankPosition-3];
        tempTable[blankPosition] = temp;
        tempTable[blankPosition-3] = 0;
        // System.out.println("UP_RIGHT" + Arrays.toString(tempTable));

        if(containsState(tempTable, openList) == true || containsState(tempTable, closedList) == true){
            return null;
        }
        return tempTable;
    }

    public Integer[] RIGHT(Integer table[], int blankPosition) {
        Integer tempTable[] = table.clone();
        Integer[] invalidPositions = {3, 7, 11};

        if(contains(invalidPositions, blankPosition)){
            return null;
        }
        int temp = tempTable[blankPosition+1];
        tempTable[blankPosition] = temp;
        tempTable[blankPosition+1] = 0;
        // System.out.println("RIGHT" + Arrays.toString(tempTable));

        if(containsState(tempTable, openList) == true || containsState(tempTable, closedList) == true){
            return null;
        }

        return tempTable;
    }

    public Integer[] DOWN_RIGHT(Integer table[], int blankPosition) {
        Integer tempTable[] = table.clone();
        Integer[] invalidPositions = {3, 7, 8, 9, 10, 11};

        if(contains(invalidPositions, blankPosition)){
            return null;
        }
        int temp = tempTable[blankPosition+5];
        tempTable[blankPosition] = temp;
        tempTable[blankPosition+5] = 0;
        // System.out.println("DOWN_RIGHT" + Arrays.toString(tempTable));

        if(containsState(tempTable, openList) == true || containsState(tempTable, closedList) == true){
            return null;
        }

        return tempTable;
    }

    public Integer[] DOWN(Integer table[], int blankPosition) {
        Integer tempTable[] = table.clone();
        Integer[] invalidPositions = {8, 9, 10, 11};

        if(contains(invalidPositions, blankPosition)){
            return null;
        }
        int temp = tempTable[blankPosition+4];
        tempTable[blankPosition] = temp;
        tempTable[blankPosition+4] = 0;
        // System.out.println("DOWN" + Arrays.toString(tempTable));

        if(containsState(tempTable, openList) == true || containsState(tempTable, closedList) == true){
            return null;
        }

        return tempTable;
    }

    public Integer[] DOWN_LEFT(Integer table[], int blankPosition) {
        Integer tempTable[] = table.clone();
        Integer[] invalidPositions = {0, 4, 8, 9, 10, 11};

        if(contains(invalidPositions, blankPosition)){
            return null;
        }
        int temp = tempTable[blankPosition+3];
        tempTable[blankPosition] = temp;
        tempTable[blankPosition+3] = 0;
        // System.out.println("DOWN_LEFT" + Arrays.toString(tempTable));

        if(containsState(tempTable, openList) == true || containsState(tempTable, closedList) == true){
            return null;
        }

        return tempTable;
    }

    public Integer[] LEFT(Integer table[], int blankPosition) {
        Integer tempTable[] = table.clone();
        Integer[] invalidPositions = {0, 4, 8};

        if(contains(invalidPositions, blankPosition)){
            return null;
        }
        int temp = tempTable[blankPosition-1];
        tempTable[blankPosition] = temp;
        tempTable[blankPosition-1] = 0;
        // System.out.println("LEFT" + Arrays.toString(tempTable));

        if(containsState(tempTable, openList) == true || containsState(tempTable, closedList) == true){
            return null;
        }

        return tempTable;
    }

    public Integer[] UP_LEFT(Integer table[], int blankPosition){
        Integer tempTable[] = table.clone();
        Integer[] invalidPositions = {0, 1, 2, 3, 4, 8};

        if(contains(invalidPositions, blankPosition)){
            return null;
        }
        int temp = tempTable[blankPosition-5];
        tempTable[blankPosition] = temp;
        tempTable[blankPosition-5] = 0;
        // System.out.println("UP_LEFT" + Arrays.toString(tempTable));

        if(containsState(tempTable, openList) == true || containsState(tempTable, closedList) == true){
            return null;
        }

        return tempTable;
    }

    public boolean goalState(Integer table[]){
        return Arrays.equals(table, this.goalState);
    }


    public boolean contains(Integer[] table, int invalidPosition) {
        int index = Arrays.binarySearch(table, invalidPosition);
        return index >= 0;
    }

    public int indexOfBlank(Integer[] table, int blankPosition) {
        int index = Arrays.asList(table).indexOf(blankPosition);
        return index;
    }

    public int heuristicScore(Integer table[], String heuristic){

        int score = -1;

        switch(heuristic){
            case "h1":
                score = heuristic1(table);
                break;
            case "h2":
                score = heuristic2(table);
                break;
            case "h3":
                score = heuristic3(table);
                break;
            case "h4":
                score = heuristic4(table);
                break;
            case "h5":
                score = heuristic5(table);
                break;
            case "h6":
                score = heuristic6(table);
                break;
            case "h7":
                score = heuristic7(table);
                break;
            case "h8":
                score = heuristic8(table);
                break;
            case "h9":
                score = heuristic9(table);
                break;
        }
        return score;
    }

    // Count the number of values in the incorrect row and column
    public int heuristic1(Integer[] table){

        int score =0;

        ArrayList<Integer[]> option = new ArrayList<>();
        option.add(new Integer[]{1, 2, 3, 4, 5, 9});
        option.add(new Integer[]{1, 2, 3, 4, 6, 10});
        option.add(new Integer[]{1, 2, 3, 4, 7, 11});
        option.add(new Integer[]{1, 2, 3, 4, 8, 0});
        option.add(new Integer[]{5, 6, 7, 8, 1, 9});
        option.add(new Integer[]{5, 6, 7, 8, 2, 10});
        option.add(new Integer[]{5, 6, 7, 8, 3, 11});
        option.add(new Integer[]{5, 6, 7, 8, 4, 0});
        option.add(new Integer[]{9, 10, 11, 0, 1, 5});
        option.add(new Integer[]{9, 10, 11, 0, 2, 6});
        option.add(new Integer[]{9, 10, 11, 0, 3, 7});
        option.add(new Integer[]{9, 10, 11, 0, 4, 8});

        for(int count=0; count<table.length; ++count){

            if(table[count] == 0){
                continue;
            }else if(!contains(option.get(count), table[count])){
                ++score;
            }
        }

        return score;
    }

    // Check if value is in column it is in or even the column before and after after. If not, add 1 to score.
    public int heuristic2(Integer[] table){

        int score =0;

        Integer[] column1 = {1, 5, 9};
        Integer[] column2 = {2, 6, 10};
        Integer[] column3 = {3, 7, 11};
        Integer[] column4 = {4, 8, 0};

        for(int count=0; count<table.length; ++count){

            if(table[count] == 0){
                continue;
            }else if(contains(column1, count+1)){
                if(!(contains(column1, table[count]) || contains(column2, table[count]))){
                    ++score;
                }
            }else if(contains(column2, count+1)){
                if(!(contains(column1, table[count]) || contains(column2, table[count]) || contains(column3, table[count]))){
                    ++score;
                }
            }else if(contains(column3, count+1)){
                if(!(contains(column2, table[count]) || contains(column3, table[count]) || contains(column4, table[count]))){
                    ++score;
                }
            }else if(contains(column4, count+1) || count ==11){
                if(!(contains(column3, table[count]) || contains(column4, table[count]))){
                    ++score;
                }
            }
        }

        return score;
    }

    // Count the number of values in the incorrect row
    public int heuristic3(Integer[] table){

        int score =0;

        for(int count=0; count<table.length-1; ++count){

            Integer[] row1 = {1, 2, 3, 4};
            Integer[] row2 = {5, 6, 7, 8};
            Integer[] row3 = {9, 10, 11, 0};
            if(table[count] == 0){
                continue;
            }else if(count < 4){
                if(!contains(row1, table[count])){
                    ++score;
                }
            }else if(count >= 4 && count <= 7){
                if(!contains(row2, table[count])){
                    ++score;
                }
            }else if(count >= 8 && count <= 11){
                if(!contains(row3, table[count])){
                    ++score;
                }
            }
        }

        return score;
    }

    // Count the number of values that are not in the correct row or at least on the row above/below.  Ignore row 2,
    // because it can easily move to either row 1 or 3
    public int heuristic4(Integer[] table){

        int score =0;

        for(int count=0; count<table.length; ++count){

            Integer[] row1 = {1, 2, 3, 4};
            Integer[] row2 = {5, 6, 7, 8};
            Integer[] row3 = {9, 10, 11, 0};
            if(table[count] == 0){
                continue;
            }else if(count < 4){
                if(!(contains(row1, table[count]) || contains(row2, table[count]))){
                    ++score;
                }
            }else if(count >= 8){
                if(!(contains(row2, table[count]) || contains(row3, table[count]))){
                    ++score;
                }
            }
        }

        return score;
    }

    // Check if value is in the wrong column
    public int heuristic5(Integer[] table){

        int score =0;

        for(int count=0; count<table.length; ++count){

            Integer[] column1 = {1, 5, 9};
            Integer[] column2 = {2, 6, 10};
            Integer[] column3 = {3, 7, 11};
            Integer[] column4 = {4, 8, 0};

            if(table[count] == 0){
                continue;
            }else if(contains(column1, count+1)){
                if(!(contains(column1, table[count]))){
                    ++score;
                }
            }else if(contains(column2, count+1)){
                if(!(contains(column2, table[count]))){
                    ++score;
                }
            }else if(contains(column3, count+1)){
                if(!(contains(column3, table[count]))){
                    ++score;
                }
            }else if(contains(column4, count+1) || count == 11){
                if(!(contains(column4, table[count]))){
                    ++score;
                }
            }
        }

        return score;
    }

    // Favor nodes where 0 can perform the most moves
    public int heuristic6(Integer[] table) {
        Integer[] tempTable = table.clone();
        int index = indexOfBlank(tempTable, 0);
        int score =0;
        switch(index){
            case 0:
            case 8:
            case 3:
            case 11:
                score = 3;
                break;
            case 1:
            case 2:
            case 4:
            case 7:
            case 9:
            case 10:
                score = 2;
                break;
            case 5:
            case 6:
                score = 1;
                break;
        }

        return score;
    }

    // Hamming distance
    public int heuristic7(Integer[] table){

        int score =0;

        for(int count=0; count<table.length; ++count){

            if(table[count]== 0){
                continue;
            }
            if(table[count]!= goalState[count]) {
                ++score;
            }
        }
        return score;
    }

    // Similar to permutation, but this just gives a preference to rows where the 0 is closer to its goal state.
    public int heuristic8(Integer[] table) {
        Integer[] tempTable = table.clone();
        List<Integer> tempList = Arrays.asList(table);
        Collections.reverse(tempList);
        tempTable = tempList.toArray(tempTable);
        int score = indexOfBlank(tempTable, 0);

        return score;
    }

    // Permutation
    public int heuristic9(Integer[] table) {
        int score = 0;
        for(int count=0; count<table.length; ++count){
            if(table[count]!=0) {
                int initial = table[count];

                for(int count2=count+1; count2<table.length; ++count2){
                    if(initial>table[count2] && table[count2]!=0){
                        score+=1;
                    }
                }
            }
        }
        return score;
    }

    public void insertBestFirstSearchArrayListOrder(StateSpace stateSpace, int score, String searchType) {

        StateSpace tempStateSpace = stateSpace;
        tempStateSpace.setScore(score);
        tempStateSpace.setSearchType(searchType);

        if(openList.size()==0){
            openList.add(tempStateSpace);
            return;
        }

        for(int count = 0; count<openList.size(); ++count){
            if(score <= openList.get(count).getScore()){
                if(score < openList.get(count).getScore()) {
                    openList.add(count, tempStateSpace);
                    break;
                }else if(score == openList.get(count).getScore()) {
                    if(moveValue.get(searchType) > moveValue.get(openList.get(count).getSearchType())){
                        openList.add(count, tempStateSpace);
                        break;
                    }else{
                        continue;
                    }
                }
            }
            if((count+1)==openList.size()){
                openList.add(tempStateSpace);
                break;
            }
        }
    }

    public String getSolutionPath(StateSpace finalStateSpace){

        String solution = "";

        initializeSolutionValue();

        solution+="\nFound Goal state";
        solution+="\nSolution Path";

        ArrayList<String> solutionPath = new ArrayList();
        StateSpace parent = finalStateSpace;

        while(true){

            if(parent.getStateSpace() == null){
                break;
            }
            solutionPath.add(0, solutionValue.get(indexOfBlank(parent.getTable(), 0)) + " " + Arrays.toString(parent.getTable()) + " " + parent.getSearchType());
            parent = parent.getStateSpace();
        }

        solutionPath.add(0, "0 " + Arrays.toString(parent.getTable()));

        for(String sp : solutionPath){
            solution+=("\n" + sp);
        }
        return solution;
    }

    public StateSpace createStateSpace(Integer[] table, int depth, String searchType, StateSpace parentState){
        StateSpace stateSpace = new StateSpace(table, parentState);
        stateSpace.setDepth(depth);
        stateSpace.setSearchType(searchType);

        return stateSpace;
    }

    public Integer[] performMove(String move, Integer originalTable[], int blankPosition){

        Integer[] table;

        switch(move){
            case "UP":
                table = UP(originalTable, blankPosition);
                return table;
            case "UP_RIGHT":
                table = UP_RIGHT(originalTable, blankPosition);
                return table;
            case "RIGHT":
                table = RIGHT(originalTable, blankPosition);
                return table;
            case "DOWN_RIGHT":
                table = DOWN_RIGHT(originalTable, blankPosition);
                return table;
            case "DOWN":
                table = DOWN(originalTable, blankPosition);
                return table;
            case "DOWN_LEFT":
                table = DOWN_LEFT(originalTable, blankPosition);
                return table;
            case "LEFT":
                table = LEFT(originalTable, blankPosition);
                return table;
            case "UP_LEFT":
                table = UP_LEFT(originalTable, blankPosition);
                return table;
        }
        return null;
    }

    public void clearLists(){
        openList.clear();
        closedList.clear();
    }

    public String breadFirstSearch(Integer[] initialTable){

        Boolean state = false;
        int depth;
        Integer parentTable[];
        Integer childTable[];
        String solution = "";
        int nodesVisited = 0;

        openList.add(createStateSpace(initialTable, 0, "", null));

        while (openList.isEmpty() == false && state == false) {

            StateSpace parentState = openList.get(0);
            parentTable = parentState.getTable();
            depth = parentState.getDepth()+1;
            openList.remove(0);
            ++nodesVisited;

            // System.out.println(Arrays.toString(parentTable));
            // System.out.println("Depth: " + depth);

            int blankPosition = indexOfBlank(parentTable, 0);

            if (goalState(parentTable)) {
                solution =  getSolutionPath(parentState);
                state = true;
            } else {
                closedList.add(parentState);

                for(String move: validMoves){
                    childTable = performMove(move, parentTable, blankPosition);
                    if (!(childTable == null)){
                        openList.add(createStateSpace(childTable, depth, move, parentState));
                    }
                }
            }
        }
        return (solution + "\nNodes visited: " + nodesVisited);
    }

    public String depthFirstSearch(Integer[] initialTable){

        Boolean state = false;
        int depth;
        Integer parentTable[];
        Integer childTable[];
        String solution = "";
        List<String> tempList = Arrays.asList(validMoves);
        Collections.reverse(tempList);
        int nodesVisited = 0;

        openList.add(createStateSpace(initialTable, 0, "", null));

        while (openList.isEmpty() == false && state == false) {

            StateSpace parentState = openList.get(0);
            parentTable = parentState.getTable();
            depth = parentState.getDepth()+1;
            openList.remove(0);
            ++nodesVisited;

            // System.out.println(Arrays.toString(parentTable));
            // System.out.println("Depth: " + depth);

            int blankPosition = indexOfBlank(parentTable, 0);

            if (goalState(parentTable)) {
                solution =  getSolutionPath(parentState);
                state = true;
            } else {

                closedList.add(parentState);

                for(String move: tempList){
                    childTable = performMove(move, parentTable, blankPosition);
                    if (!(childTable == null)){
                        openList.add(0, createStateSpace(childTable, depth, move, parentState));
                    }
                }
            }
        }
        return (solution + "\nNodes visited: " + nodesVisited);
    }

    public String iterativeDeepeningSearch(Integer[] initialTable, int maxIteration){

        Boolean state = false;
        int depth;
        int depthMax=0;
        int maxIterationIndex = 0;
        Integer parentTable[];
        Integer childTable[];
        String solution = "";
        List<String> tempList = Arrays.asList(validMoves);
        Collections.reverse(tempList);

        while(state == false && maxIterationIndex <= maxIteration) {
            openList.clear();
            closedList.clear();
            openList.add(createStateSpace(initialTable, 0, "", null));

            while (openList.isEmpty() == false && state == false) {

                StateSpace parentState = openList.get(0);
                parentTable = parentState.getTable();
                depth = parentState.getDepth() + 1;
                openList.remove(0);

                if (goalState(parentTable)) {
                    solution =  getSolutionPath(parentState);
                    state = true;
                }

                if (depth <= depthMax) {

                    // System.out.println(Arrays.toString(parentTable));
                    // System.out.println("Depth: " + depth);

                    int blankPosition = indexOfBlank(parentTable, 0);

                    closedList.add(parentState);

                    for (String move : tempList) {
                        childTable = performMove(move, parentTable, blankPosition);
                        if (!(childTable == null)) {
                            openList.add(0, createStateSpace(childTable, depth, move, parentState));
                        }
                    }
                }
            }
            ++depthMax;
            ++maxIterationIndex;
        }
        return solution;
    }

    public String bestFirstSearch(Integer[] initialTable, String heuristic){

        Boolean state = false;
        int depth;
        Integer parentTable[];
        Integer childTable[];
        String solution = "";
        int nodesVisited = 0;

        openList.add(createStateSpace(initialTable, 0, "", null));

        initializeMoveValue();

        while (openList.isEmpty() == false && state == false) {

            StateSpace parentState = openList.get(0);
            parentTable = parentState.getTable();
            depth = parentState.getDepth()+1;
            openList.remove(0);
            ++nodesVisited;

            // System.out.println(Arrays.toString(parentTable));
            // System.out.println("Depth: " + depth);

            int blankPosition = indexOfBlank(parentTable, 0);

            if (goalState(parentTable)) {
                solution =  getSolutionPath(parentState);
                state = true;
            } else {

                closedList.add(parentState);

                for(String move: validMoves){
                    childTable = performMove(move, parentTable, blankPosition);
                    if (!(childTable == null)){
                        int heuristicScore = heuristicScore(childTable, heuristic);
                        insertBestFirstSearchArrayListOrder(createStateSpace(childTable, depth, move, parentState), heuristicScore, move);
                    }
                }
            }
        }
        return (solution + "\nNodes visited: " + nodesVisited);
    }

    public String aStarSearch(Integer[] initialTable, String admissibleHeuristic) {

        Boolean state = false;
        int depth;
        Integer parentTable[];
        Integer childTable[];
        String solution = "";
        int nodesVisited = 0;

        openList.add(createStateSpace(initialTable, 0, "", null));

        initializeMoveValue();

        while (openList.isEmpty() == false && state == false) {

            StateSpace parentState = openList.get(0);
            parentTable = parentState.getTable();
            depth = parentState.getDepth() + 1;
            openList.remove(0);
            ++nodesVisited;

            // System.out.println(Arrays.toString(parentTable));
            // System.out.println("Depth: " + depth);

            int blankPosition = indexOfBlank(parentTable, 0);

            if (goalState(parentTable)) {
                solution =  getSolutionPath(parentState);
                state = true;
            } else {

                closedList.add(parentState);

                for (String move : validMoves) {
                    childTable = performMove(move, parentTable, blankPosition);
                    if (!(childTable == null)) {
                        int heuristicScore = heuristicScore(childTable, admissibleHeuristic);
                        insertBestFirstSearchArrayListOrder(createStateSpace(childTable, depth, move, parentState), heuristicScore + depth, move);
                    }
                }
            }
        }
        return (solution + "\nNodes visited: " + nodesVisited);
    }
}