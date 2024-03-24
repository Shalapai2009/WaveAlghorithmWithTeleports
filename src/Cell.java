public class Cell {

    private int position = 0;
    private Type type;
    private Attendance attendance;
    public Cell(int position,Type type){
    this.position= position;
    this.type = type;
    }
    public int getPosition(){
        return this.position;
    }
    public void setPosition(int position){
        this.position = position;
    }
    public Type getType(){
        return type;
    }
    public void setType(Type type){
        this.type = type;
    }

    public void doCellEmpty(){
        position = 0;
        type = Type.EMPTY;
    }
    public void doCellFull(){
        position = -1;
        type = Type.FULL;

    }
    public void doStart(){
        position = 0;
        type = Type.START;
    }
    public void doFinish(){
        type = Type.FINISH;
    }
    public void doCellTeleport(){
        type = Type.TELEPORT;
    }

    public void makeVisited(){
        attendance = Attendance.VISITED;
    }
    public void makeUnvisited(){
        attendance = Attendance.UNVISITED;
    }
    public static enum Type{
       START,FINISH, EMPTY, FULL, TELEPORT, Teleport1, Teleport2
    }
    public static enum Attendance{
        VISITED, UNVISITED
    }

}
