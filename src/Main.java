public class Main {
    public static void main(String[] args) {
        Cell[][] Labyrinth9X9 = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i  == 0 | j==0) | (i == 8 | j ==8)) {
                    Labyrinth9X9[i][j] = new Cell(-1, Cell.Type.FULL);
                } else {
                    Labyrinth9X9[i][j] = new Cell(0, Cell.Type.EMPTY);
                }
            }
        }
        Labyrinth labyrinth = new Labyrinth(Labyrinth9X9);
        labyrinth.setStart(1,1);
        labyrinth.setFinish(8,8);
        printThis(labyrinth.getLabyrinth());

        System.out.println("Hello world!");
    }

    public static void printThis(Cell[][] laburinth){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 8){
                    System.out.print(laburinth[i][j].getPosition());
                    System.out.println();
                } else
                    if (laburinth[i][j].getPosition() == -1){
                    System.out.print(laburinth[i][j].getPosition());}
                    else {
                        System.out.print(" "+laburinth[i][j].getPosition());
                    }
            }
        }
    }
}