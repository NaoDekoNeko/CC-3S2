package TicTacToe;

public class TicTacToe {
    private final int TOTALROWS = 3;
    private final int TOTALCOLUMNS = 3;

    public boolean esGanador(char turn,int row1, int col1) {
        int row = row1-1;
        int col = col1-1;
        Cell token = (turn == 'X') ? Cell.CROSS : Cell.NOUGHT;
        return (grid[row][0] == token
                && grid[row][1] == token && grid[row][2] == token
                || grid[0][col] == token
                && grid[1][col] == token && grid[2][col] == token
                || row == col
                && grid[0][0] == token && grid[1][1] == token && grid[2][2] == token
                || row + col == 2
                && grid[0][2] == token && grid[1][1] == token && grid[2][0] == token);
    }

    public enum Cell {
        EMPTY, CROSS, NOUGHT
    }
    protected char turn;
    protected Cell[][] grid;
    public TicTacToe() {
        grid = new Cell[TOTALROWS][TOTALCOLUMNS];
        initBoard();
    }
    private void initBoard() {
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                grid[row][col] = Cell.EMPTY;
            }
        }
        //el turno empieza en X
        turn = 'X';
    }
    public Cell getCell(int row, int column) {
        if (row >= 1 && row <= TOTALROWS && column >= 1 && column <= TOTALCOLUMNS) {
            return grid[row-1][column-1];
        } else {
            return null;
        }
    }
    public char getTurno() {
        return turn;
    }
    public void comprobarInvalido(int row, int col){
        //si está fuera de los límites, lanza excepción
        if (row < 1 || row> TOTALROWS || col < 1 || col >TOTALCOLUMNS){
            throw new RuntimeException();
        }
    }
    public boolean puntoHorizontal(){
        for(int i=0;i<TOTALROWS;i++){
            //se fija si la primer ficha de la fila tiene coincidencia en toda la fila
            if(grid[0][i] != Cell.EMPTY &&
                    grid[1][i] == grid[0][i] &&
                    grid[2][i] == grid[0][i]){
                return true;
            }
        }
        return false;
    }
    public boolean puntoVertical(){
        for(int i=0;i<TOTALCOLUMNS;i++){
            //se fija si la primer ficha de la columna tiene coincidencia en toda la columna
            if(grid[i][0] != Cell.EMPTY &&
                    grid[i][1] == grid[i][0] &&
                    grid[i][2] == grid[i][0]){
                return true;
            }
        }
        return false;
    }
    public boolean puntoDiagIzq(){
        Cell aux = grid[1][1];
        if(aux== Cell.EMPTY) {
            return false;
        }
        boolean auxb = true;
        for(int i=0;i<TOTALROWS;i++){
            if(aux != grid[i][i]){
                auxb = false;
                break;
            }
        }
        return auxb;
    }
    public boolean puntoDiagDer(){
        Cell aux = grid[1][1];
        if(aux== Cell.EMPTY){
            return false;
        }
        boolean auxb = true;
        for(int i=0;i<TOTALROWS;i++){
            if (aux != grid[i][2 - i]) {
                auxb = false;
                break;
            }
        }
        return auxb;
    }
    public boolean tableroLleno(){
        for(int i=0;i<TOTALROWS;i++){
            for(int j=0;j<TOTALCOLUMNS;j++){
                if(grid[i][j] == Cell.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean hayGanador() {
        return puntoHorizontal() ||
                puntoVertical() ||
                puntoDiagIzq() ||
                puntoDiagDer() &&
                !tableroLleno();
    }

    public void jugar(int row, int col) {
        comprobarInvalido(row,col); //si es un movimiento invalido lanza una excepción
        //si está vacía, rellena
        if(grid[row-1][col-1] == Cell.EMPTY){
            grid[row-1][col-1] =  (turn == 'X') ? Cell.CROSS : Cell.NOUGHT;
            turn = (turn == 'X') ? 'O' : 'X';
        }
        //si esta ocupada, no hace nada
    }
}
