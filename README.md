# 11-Puzzle Solver
COMP 472: Mini-Project 1

Different search algorithms and heuristic that can be used to solve an 11 puzzle. Adaptation of the popular 8-puzzle

## To Run
You can solve a 11-puzzle by replacing the array in the HeuristicSearch.java class.

```Integer initialTable[] ={1, 0, 3, 7, 5, 2, 6, 4, 9, 10, 11, 8};``` 


There are various examples that can be ran to solve the algorithm. The solutions will appear in the console and output files.
### Example to run the code
```
response ="";<br/>                                                     // Clear output response
response += ("\n\nBest-First Search with h1");<br/>
startTime = System.currentTimeMillis();<br/>                           // Get start time of algorithm
response += ("\nStart time(currentTimeMillis): " + startTime);<br/>             
response += heuristicLibrary.bestFirstSearch(initialTable, "h1");<br/> // Specify search algorithm and heuristic 
endTime = System.currentTimeMillis();<br/>                             // Get end time of algorithm
response += ("\nEnd time(currentTimeMillis): " + endTime);<br/>
response += ("\nTotal time(seconds): " + (endTime-startTime));<br/>
writeToFile("puzzleBFS-h1.txt", response);<br/>                        // Save solution to file
heuristicLibrary.clearLists();<br/>                                    // Clear the algorithms open, closed list
System.out.println(response);<br/>                                     // Print solution to console
```
### Example Solution Output

```
Best-First Search with h1
Start time(currentTimeMillis): 1552887090081
Found Goal state
Solution Path
0 [1, 0, 3, 7, 5, 2, 6, 4, 9, 10, 11, 8]
f [1, 2, 3, 7, 5, 0, 6, 4, 9, 10, 11, 8] DOWN
g [1, 2, 3, 7, 5, 6, 0, 4, 9, 10, 11, 8] RIGHT
d [1, 2, 3, 0, 5, 6, 7, 4, 9, 10, 11, 8] UP_RIGHT
h [1, 2, 3, 4, 5, 6, 7, 0, 9, 10, 11, 8] DOWN
l [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0] DOWN
Nodes visited: 6
End time(currentTimeMillis): 1552887090081
Total time(seconds): 0
```

## Search Algorithms
1. Iterative Deepening Search
2. Breadth-First Search
3. Algorithm A*

## Heuristics:
1. h1: Count the number of values in the incorrect row and column
2. h2: Count the number of values that is not in column it is in or even in the columns before or after.
## Experimental heuristics:
3. h3: Count the number of values in the incorrect row
4. h4: Count the number of values that are not in the row above/below.  Ignore row 2, because it can easily move to either row 1 or 3
5. h3: Count the number of values in the incorrect column
6. h6: Favor nodes where 0 can perform the most moves (Infinite loop)
7. h7: Hamming Distance (Works)
8. h8: Similar to permutation, but this just gives a preference to rows where the 0 is closer to its goal state. (Infinite loop)
9. h9: Permutation


