public class Labyrinth {
   private Cell[][] labyrinth;

    public Labyrinth(Cell[][] labyrinth){
        this.labyrinth = labyrinth;
    }
    public void spawn2Teleports(int positionX1,int positionY1,int positionX2, int positionY2){
        labyrinth[positionX1][positionY1].doCellTeleport();
        labyrinth[positionX2][positionY2].doCellTeleport();
    }
    public Cell getCell(int x,int y){
            return labyrinth[x][y];
    }

    public void setStart(int x,int y){
        labyrinth[x][y].doStart();
    }

    public Cell getStart(){
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                if (labyrinth[i][j].getType() == Cell.Type.START){
                    return labyrinth[i][j];
                }
            }
        }
        return null;
    }
    public int[] getStartCoordinates(){
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
    }
    public void setFinish(int x,int y){
        labyrinth[x][y].doFinish();
    }
    public Cell getFinish(){
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[i].length; j++) {
                if (labyrinth[i][j].getType() == Cell.Type.FINISH){
                    return labyrinth[i][j];
                }
            }
        }
        return null;
    }
    public int[] getFinishCoordinates(){
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
    }


    public Cell[][] getLabyrinth(){
        return labyrinth;
    }
    public void waveAlgorithm(Cell startCell){
       // Cell[] upCell = startCell.getPosition();
        //

    }


}
