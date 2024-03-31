import java.util.Deque;

public class Cell {

    private int position = 0;
    private Type type;
    private Attendance attendance = Attendance.UNVISITED;
    private Paint color = Paint.NOTSHADED;
    private Cell wayToTeleport;

    public Cell(int position,Type type){
    this.position = position;
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
        attendance = Attendance.VISITED;
    }
    public void doFinish(){
        type = Type.FINISH;
    }

    public void doShade(){ color = Paint.SHADED;}
    public Paint getColor(){
        return color;
    }
    public void doCellTeleport(){
        type = Type.TELEPORT;
    }
    public void doCellTeleportEnter(){
        type = Type.TeleportEnter;
    }
    public void doCellTeleportExit(){
        type = Type.TeleportExit;
        attendance = Attendance.VISITED;
    }

    public Attendance getAttendance(){
        return attendance;
    }
    public void makeVisited(){
        attendance = Attendance.VISITED;
    }
    public void makeUnvisited(){
        attendance = Attendance.UNVISITED;
    }
    public Cell getWaysToTeleports(){
        return wayToTeleport;
    }
    public void setWayToTeleport(Cell cell){
        wayToTeleport = cell;
    }
    public static enum Type{
       START,FINISH, EMPTY, FULL, TELEPORT, TeleportEnter, TeleportExit
    }
    public static enum Attendance{
        VISITED, UNVISITED
    }
    public static enum Paint{
        NOTSHADED,SHADED
    }

}
