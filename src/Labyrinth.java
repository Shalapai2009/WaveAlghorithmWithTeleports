import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Labyrinth {
   private Cell[][] labyrinth;
   private Cell start;
    private Cell finish;

    public Labyrinth(Cell[][] labyrinth){
        this.labyrinth = labyrinth;
    }
    public void spawn2Teleports(int positionX1,int positionY1,int positionX2, int positionY2){
        labyrinth[positionX1][positionY1].doCellTeleport();
        labyrinth[positionX2][positionY2].doCellTeleport();
    }
    public Cell getCell(int x,int y){
        try {
            return labyrinth[x][y];
        } catch (Exception e) {
            return null;
        }

    }
    public int[] getCellCoordinates(Cell cell){
        int[] cellCoordinates = new int[2];
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                if (labyrinth[i][j] ==cell){
                    cellCoordinates[0] =i; cellCoordinates[1] =j;
                return cellCoordinates;
                }
            }
        }
        return null;
    }

    public void setStart(int x,int y){

        labyrinth[x][y].doStart();
        start = labyrinth[x][y];
    }

    public Cell getStart(){
        return start;
    }
    /*public int[] getStartCoordinates(){
       int[] startCoordinates =new int[2];
        for (int x = 0; x < labyrinth.length; x++) {
            for (int y = 0; y < labyrinth[x].length; y++) {
                if (labyrinth[x][y].getType() == Cell.Type.START){
                    startCoordinates[0] = x; startCoordinates[1] =y;
                    return startCoordinates;
                }
            }
        }
        return null;
    }*/

    public void setFinish(int x,int y){
        labyrinth[x][y].doFinish();
        finish = labyrinth[x][y];
    }
    public Cell getFinish(){
        return finish;
    }
    /*public int[] getFinishCoordinates(){
        int[] startCoordinates =new int[2];
        for (int x = 0; x < labyrinth.length; x++) {
            for (int y = 0; y < labyrinth[x].length; y++) {
                if (labyrinth[x][y].getType() == Cell.Type.FINISH){
                    startCoordinates[0] = x; startCoordinates[1] =y;
                    return startCoordinates;
                }
            }
        }
        return null;
    }*/


    public Cell[][] getLabyrinth(){
        return labyrinth;
    }
    private void waveAlgorithm(){
        Deque<Cell> deque = new ArrayDeque<>();
        deque.add(start);
        while (deque.size()>0){
            Cell currentCell = deque.pop();
            int[] currentCellCoordinates = getCellCoordinates(currentCell);
            int currentCellX = currentCellCoordinates[0];
            int currentCellY = currentCellCoordinates[1];
            Cell leftCell = getCell(currentCellX-1,currentCellY);
            Cell UpCell = getCell(currentCellX,currentCellY-1);
            Cell RightCell = getCell(currentCellX+1,currentCellY);
            Cell DownCell = getCell(currentCellX,currentCellY+1);
            if (leftCell != null  && (leftCell.getType() != Cell.Type.FULL & leftCell.getAttendance() != Cell.Attendance.VISITED)){
                leftCell.setPosition(currentCell.getPosition()+1);
                leftCell.makeVisited();
                deque.add(leftCell);
            }
            if (UpCell != null  && (UpCell.getType() != Cell.Type.FULL & UpCell.getAttendance() != Cell.Attendance.VISITED)){
                UpCell.setPosition(currentCell.getPosition()+1);
                UpCell.makeVisited();
                deque.add(UpCell);
            }
            if (RightCell != null  && (RightCell.getType() != Cell.Type.FULL & RightCell.getAttendance() != Cell.Attendance.VISITED)){
                RightCell.setPosition(currentCell.getPosition()+1);
                RightCell.makeVisited();
                deque.add(RightCell);
            }
            if (DownCell != null  && (DownCell.getType() != Cell.Type.FULL & DownCell.getAttendance() != Cell.Attendance.VISITED)){
                DownCell.setPosition(currentCell.getPosition()+1);
                DownCell.makeVisited();
                deque.add(DownCell);
            }
       }

    }
    public Deque<Cell> getShortestWay(){
        waveAlgorithm();
        if (finish.getPosition()<=0){
            return null;
        }
        else {
            Deque<Cell> deque = new ArrayDeque<>();
            deque.add(finish);
            while (deque.getLast() != start){
                Cell currentCell = deque.getLast();
                int[] currentCellCoordinates = getCellCoordinates(currentCell);
                int currentCellX = currentCellCoordinates[0];
                int currentCellY = currentCellCoordinates[1];
                Cell leftCell = getCell(currentCellX-1,currentCellY);
                Cell UpCell = getCell(currentCellX,currentCellY-1);
                Cell RightCell = getCell(currentCellX+1,currentCellY);
                Cell DownCell = getCell(currentCellX,currentCellY+1);
                if (leftCell != null && (leftCell.getPosition() == currentCell.getPosition()-1)){
                    deque.add(leftCell);
                    leftCell.doShade();
                }
                if (UpCell != null && (UpCell.getPosition() == currentCell.getPosition()-1)){
                    deque.add(UpCell);
                    UpCell.doShade();
                }
                if (RightCell != null && (RightCell.getPosition() == currentCell.getPosition()-1)){
                    deque.add(RightCell);
                    RightCell.doShade();
                }
                if (DownCell != null && (DownCell.getPosition() == currentCell.getPosition()-1)){
                    deque.add(DownCell);
                    DownCell.doShade();
                }
            }
            return deque;

        }

    }


}
