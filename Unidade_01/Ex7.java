package Unidade_01;

// Ex07
public class Ex7 {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        while (true) {
            game.printBoard();
            game.move();
    
            if(game.checkWin()){
                game.printBoard();
                System.out.println("Jogador " + game.currentPlayerSymbol() + " venceu!");
                break;
            }


            if(game.isBoardFull()){
                game.printBoard();
                System.out.println("O jogo terminou em empate!");
                break;
            }

            game.switchPlayer();

        }
    
    }

}


class TicTacToe {
    final byte PLAYER_1_VALUE = 1;
    final byte PLAYER_2_VALUE = -1;


    byte player = PLAYER_1_VALUE;
    byte board[][] = {
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };

    public void move() {
        boolean isValidMove = false;
        
        while(!isValidMove){
            System.out.println("Jogador " + this.currentPlayerSymbol() + " digite a linha (1-3): ");
            int row = Integer.parseInt(System.console().readLine());
            System.out.println("Jogador " + this.currentPlayerSymbol() + " digite a coluna (1-3): ");
            int col = Integer.parseInt(System.console().readLine());


            if(row >= 1 && row <= 3 && col >= 1 && col <= 3 && this.board[row-1][col-1] == 0){
                this.board[row-1][col-1] = this.player;
                isValidMove = true;
            } else {
                this.printBoard();
                System.out.println("Jogada inválida, tente novamente.");
            }
        }
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(isXorO(this.board[i][j]) + (j == 0 || j == 1 ? " | " : " "));
            }
            System.out.println();
            if (i == 1 || i == 0) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    public char currentPlayerSymbol(){
        return this.isXorO(this.player);
    }

    public void switchPlayer() {
        this.player *= -1;
    }

    private char isXorO(byte value) {
        return value == PLAYER_1_VALUE ? 'X' : value == PLAYER_2_VALUE ? 'O' : ' ';
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(this.board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            int rowsSum =  board[i][0] + board[i][1] + board[i][2];
            int colsSum =  board[0][i] + board[1][i] + board[2][i];


            if(Math.abs(rowsSum) == 3 || Math.abs(colsSum) == 3){
                return true;
            }
        }

        int diag1Sum = board[0][0] + board[1][1] + board[2][2];
        int diag2Sum = board[0][2] + board[1][1] + board[2][0];

        
        return Math.abs(diag1Sum) == 3 || Math.abs(diag2Sum) == 3;
    }
}