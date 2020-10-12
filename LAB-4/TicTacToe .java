import java.util.*;


public class TicTacToe{
      public enum status{
            X,O,EMPTY;
      }
      public static int N = 9;
      private status[] board = new status[9];
      public TicTacToe(){
            // initialising the tic-tac-toe board
            for(int i=0;i<N;i++){
                  this.board[i] = status.EMPTY;
            }                
      
      } 
      public void move(int x,int player){
            if (this.board[x] != status.EMPTY){
                  int p = player+1;
                  System.out.println("Sorry! Player - "+p+", your move is already occupied! YOU ARE DISQUALIFIED..");
                  System.exit(0);
            }
            if (player == 0)
                  this.board[x] = status.X;
            else
                  this.board[x] = status.O;            
            
            this.printBoard();      
      }      
      public String checkWin(){
            String b[]= new String[N];
            for(int i=0;i<N;i++){
                  b[i] = String.valueOf(this.board[i]);
            }
            for(int i=0;i<8;i++){
                  String c = "";
                  switch(i){
                        case 0:
                              c = b[0]+b[1]+b[2];
                              break;
                        case 1:
                              c = b[3]+b[4]+b[5];
                              break;
                        case 2:
                              c = b[6]+b[7]+b[8];
                              break;
                        case 3:
                              c = b[0]+b[3]+b[6];
                              break;
                        case 4:
                              c =  b[1]+b[4]+b[7];
                              break;
                        case 5:
                              c =  b[2]+b[5]+b[8];
                              break;
                        case 6:
                              c = b[0]+b[4]+b[8];
                              break;
                        case 7:
                              c =  b[2]+b[4]+b[6];
                              break;
                  }
                  if (c.equals("XXX"))
                        return "X";
                  else if (c.equals("OOO"))
                        return "O";
            }
            return null;

      }
      
      public int allPosFull(){
            for(int i=0;i<N;i++){                 
                  if (this.board[i] == status.EMPTY)
                        return 0;                     
                 
            } 
            return 1;              
      } 
      
      public void printBoard(){
            System.out.println();
            System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
            System.out.println("|-----------------------|");
            System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
            System.out.println("|-----------------------|");
            System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
            System.out.println();
            
      } 
      public void printPos(){
            System.out.println("\nPOSTIONS TO ENTER YOUR MOVE : \n");
            System.out.println("| " + 0 + "\t|" + 1 + "\t|" + 2 + "\t|");
            System.out.println("|-----------------------|");
            System.out.println("| " + 3 + "\t| " + 4 + "\t| " + 5 + "\t|");
            System.out.println("|-----------------------|");
            System.out.println("| " + 6 + "\t| " + 7 + "\t| " + 8 + "\t|");
            System.out.println();
            
      }
      public static void main(String[] args){
            System.out.println("\n----------------------------WELCOME TO TIC-TAC-TOE IN JAVA----------------------\n");
            System.out.println("\nPLAYER - 1 GETS X AND PLAYER-2 GETS O\n");
            TicTacToe t = new TicTacToe();
            t.printBoard();
            Scanner in = new Scanner(System.in);            
            int player = 0;
            String m = "XO";
            int i=3;

            while(true){
                  int p = player+1;
                  System.out.println("Play your move Player - "+p+"\n");
                  t.printPos();
                  System.out.println("Enter the position you want to place "+m.charAt(player)+" : ");
                  int x = in.nextInt();
                  t.move(x,player);
                  String w = t.checkWin();
                  if (w!=null){
                        if (w == "X")
                              p = 1;
                        else
                              p = 2;
                        System.out.println("Congratulations! Player - "+p+" wins \n");
                        System.exit(0);
                  }
                  else if (t.allPosFull()==1){
                        System.out.println("OOPS it is a TIE!!\n");
                        System.exit(0);
                  }
                  System.out.println();
                  if (player == 1)
                        player = 0;
                  else
                        player = 1;
                  
                  i--; 
            }  
         
           
            
      }

}
