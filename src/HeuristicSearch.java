import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class HeuristicSearch {

    public static void main(String[] args) {

        Integer initialTable[] ={1, 0, 3, 7, 5, 2, 6, 4, 9, 10, 11, 8};

        HeuristicLibrary heuristicLibrary = new HeuristicLibrary();
        long startTime;
        long endTime;
        String response ="";

        /*
            Heuristics:
                - h1: Count the number of values in the incorrect row and column
                - h2: Count the number of values that is not in column it is in or even in the columns before or after.
            Experimental heuristics:
                - h3: Count the number of values in the incorrect row
                - h4: Count the number of values that are not in the row above/below.  Ignore row 2, because it can easily move to either row 1 or 3
                - h3: Count the number of values in the incorrect column
                - h6: Favor nodes where 0 can perform the most moves (Infinite loop)
                - h7: Hamming Distance (Works)
                - h8: Similar to permutation, but this just gives a preference to rows where the 0 is closer to its goal state. (Infinite loop)
                - h9: Permutation
        */

        /*
        DFS takes too long to complete
        response ="";
        response += ("Depth-First Search");
        startTime = System.currentTimeMillis();
        response += ("\nStart time: " + startTime);
        response += heuristicLibrary.depthFirstSearch(initialTable);
        endTime = System.currentTimeMillis();
        response += ("\nEnd time(seconds): " + endTime);
        response += ("\nTotal time(seconds): " + (endTime-startTime));
        writeToFile("puzzleDFS.txt", response);
        heuristicLibrary.clearLists();
        System.out.println(response);
*/

        response ="";
        response += ("\n\nIterative-Deepening Search");
        startTime = System.currentTimeMillis();
        response += ("\nStart time(currentTimeMillis): " + startTime);
        response += heuristicLibrary.iterativeDeepeningSearch(initialTable, 10);
        endTime = System.currentTimeMillis();
        response += ("\nEnd time(currentTimeMillis): " + endTime);
        response += ("\nTotal time(seconds): " + (endTime-startTime));
        writeToFile("puzzleIFS.txt", response);
        heuristicLibrary.clearLists();
        System.out.println(response);

        response ="";
        response += ("\n\nBreadth-First Search");
        startTime = System.currentTimeMillis();
        response += ("\nStart time(currentTimeMillis): " + startTime);
        response += heuristicLibrary.breadFirstSearch(initialTable);
        endTime = System.currentTimeMillis();
        response += ("\nEnd time(currentTimeMillis): " + endTime);
        response += ("\nTotal time(seconds): " + (endTime-startTime));
        writeToFile("puzzleBFS.txt", response);
        heuristicLibrary.clearLists();
        System.out.println(response);

        response ="";
        response += ("\n\nBest-First Search with h1");
        startTime = System.currentTimeMillis();
        response += ("\nStart time(currentTimeMillis): " + startTime);
        response += heuristicLibrary.bestFirstSearch(initialTable, "h1");
        endTime = System.currentTimeMillis();
        response += ("\nEnd time(currentTimeMillis): " + endTime);
        response += ("\nTotal time(seconds): " + (endTime-startTime));
        writeToFile("puzzleBFS-h1.txt", response);
        heuristicLibrary.clearLists();
        System.out.println(response);

        response ="";
        response += ("\n\nBest-First Search with h2");
        startTime = System.currentTimeMillis();
        response += ("\nStart time(currentTimeMillis): " + startTime);
        response += heuristicLibrary.bestFirstSearch(initialTable, "h2");
        endTime = System.currentTimeMillis();
        response += ("\nEnd time(currentTimeMillis): " + endTime);
        response += ("\nTotal time(seconds): " + (endTime-startTime));
        writeToFile("puzzleBFS-h2.txt", response);
        heuristicLibrary.clearLists();
        System.out.println(response);

        response ="";
        response += ("\n\nAlgorithm A* Search with h1");
        startTime = System.currentTimeMillis();
        response += ("\nStart time(currentTimeMillis): " + startTime);
        response += heuristicLibrary.aStarSearch(initialTable, "h1");
        endTime = System.currentTimeMillis();
        response += ("\nEnd time(currentTimeMillis): " + endTime);
        response += ("\nTotal time(seconds): " + (endTime-startTime));
        writeToFile("puzzleAs-h1.txt", response);
        heuristicLibrary.clearLists();
        System.out.println(response);


        response ="";
        response += ("\n\nAlgorithm A* Search with h2");
        startTime = System.currentTimeMillis();
        response += ("\nStart time(currentTimeMillis): " + startTime);
        response += heuristicLibrary.aStarSearch(initialTable, "h2");
        endTime = System.currentTimeMillis();
        response += ("\nEnd time(currentTimeMillis): " + endTime);
        response += ("\nTotal time(seconds): " + (endTime-startTime));
        writeToFile("puzzleAs-h2.txt", response);
        heuristicLibrary.clearLists();
        System.out.println(response);

        /*
            You can test any of the experimental heuristics with best-first or algorithm a*, by replacing "h2" with h3-h9
            Note: some of the heuristics get stuck in a loop and don't determine the solution quickly.
        */

    }

    public static void writeToFile(String fileName, String output){
        Writer writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "utf-8"));
            writer.write(output);
        }catch (Exception e){
            System.out.println("There was an error writing output to file");
        }finally {
            try{
                writer.close();
            }catch (Exception e2){
                System.out.println("There was an error closing writer");

            }
        }
    }
}