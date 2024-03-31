import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class BufferRead {
    private BufferedReader br;

    private List<String> lines = new ArrayList<>();
    public BufferRead(BufferedReader br){
        this.br = br;
    }
    public BufferedReader getBR(){
        return br;
    }
    public void setBR(BufferedReader br){
        this.br = br;
    }
    public Labyrinth doMagic() throws IOException {
        while (br.ready()) {
            lines.add(br.readLine());
        }
        LinkedList<Object[]> listEnter =  new LinkedList<>();
        LinkedList<Object[]> listOut = new LinkedList<>();

        int matrixWidth = lines.get(0).split(" ").length;
        int matrixHeight = lines.size();
        Cell[][] matrix = new Cell[matrixWidth][matrixHeight];
        Labyrinth labyrinth = new Labyrinth(matrix);

        for (int i = 0; i < matrixHeight; i++) {
            String[] line = lines.get(i).split(" ");

            for (int j = 0; j < matrixWidth; j++) {
                if (line[j].equals("N")){
                    //matrix[j][i]= new Cell(-1, Cell.Type.FULL);
                    labyrinth.setCell(j,i).doCellFull();
                } else if (line[j].equals("E")){
                    //matrix[j][i]= new Cell(0, Cell.Type.EMPTY);
                    labyrinth.setCell(j,i).doCellEmpty();
                } else if (line[j].equals("S")){
                    //matrix[j][i]= new Cell(0, Cell.Type.EMPTY);
                    //matrix[j][i].doStart();
                    labyrinth.setCell(j,i);
                    labyrinth.setStart(j,i);
                } else if (line[j].equals("F")){
                    //matrix[j][i]= new Cell(0, Cell.Type.EMPTY);
                    //matrix[j][i].doFinish();
                    labyrinth.setCell(j,i);
                    labyrinth.setFinish(j,i);
                } else {
                   String[] dataTeleport = line[j].split("");
                    if (dataTeleport[0].equals("T")) {
                        if (dataTeleport[2].equals("E")){
                        listEnter.add(new Object[]{j, i, dataTeleport[1], dataTeleport[2]});
                            //matrix[j][i]= new Cell(0, Cell.Type.EMPTY);
                            labyrinth.setCell(j,i).doCellEmpty();
                        }
                        else {
                            listOut.add(new Object[]{j, i, dataTeleport[1], dataTeleport[2]});
                            //matrix[j][i]= new Cell(0, Cell.Type.EMPTY);
                            labyrinth.setCell(j,i).doCellEmpty();
                        }
                    }
                    }

            }
        }
        while (listEnter.size()>0 & listOut.size()>0){
            Object[] teleportEnter = listEnter.pop();
            for (Object[] i : listOut) {
                if (teleportEnter[2].equals(i[2])){
                    Object[] teleportOut = i;
                   //Cell labyrinthTEnter =  matrix[(int) teleportEnter[0]][(int) teleportEnter[1]];
                    //Cell labyrinthTOut =  matrix[(int) teleportOut[0]][(int) teleportOut[1]];
                   labyrinth.SpawnEntryAndExit((int) teleportEnter[0],(int) teleportEnter[1],(int) teleportOut[0],(int) teleportOut[1]);
                   // matrixTEnter.doCellTeleportEnter();
                   //matrixTOut.doCellTeleportExit();
                    //matrixTEnter.setWayToTeleport(matrixTOut);
                    //matrixTOut.setWayToTeleport(matrixTEnter);
                    break;
                }

            }
        }
        return labyrinth;
    }
}
