public class StateSpace {

    private  StateSpace stateSpace;
    private Integer[] table;
    private int score;
    private String searchType;
    private int depth;

    StateSpace(Integer[] table, StateSpace parentStateSpace) {
        this.table = table.clone();
        this.stateSpace = parentStateSpace;
    }
    public void setDepth(int depth) {
        this.depth = depth;

    }public int getDepth() {
        return this.depth;
    }

    public void setScore(int value) {
        this.score = value;
    }
    public int getScore() {
        return this.score;
    }

    public void setSearchType(String value) {
        this.searchType = value;
    }
    public String getSearchType() {
        return this.searchType;
    }

    public Integer[] getTable() {
        return table;
    }

    public StateSpace getStateSpace(){
        return this.stateSpace;
    }
}