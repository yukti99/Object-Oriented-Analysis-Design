import java.util.*;


public class TicTacToe{
      public enum status{
            X,O,EMPTY;
      }
      private status[][] board = new status[3][3];
      public TicTacToe(){
            for(int i=0;i<3;i++){
                  for(int j=0;j<3;j++){
                        this.board[i][j] = status.EMPTY;
                  }
            }                
      
      } 
      public void move(int x,int y,int player){
            if (this.board[x][y] != status.EMPTY){
                  int p = player+1;
                  System.out.println("Sorry! Player - "+p+", your move is already occupied! YOU ARE DISQUALIFIED..");
                  System.exit(0);
            }
            if (player == 0){
                  this.board[x][y] = status.X;
            }
            else
                  this.board[x][y] = status.O;            
            
            this.printBoard();
      
      } 
      public  String checkRows(){
            String ans="#";
            for(int i=0;i<3;i++){
                  if (this.board[i][0] == status.EMPTY)
                        continue;
                  status s = this.board[i][0];
                  ans = "#";
                  int j=1;
                  while(this.board[i][j]!=status.EMPTY && this.board[i][j] == this.board[j][i]){
                        
                  }
                  for(int j=1;j<3;j++){
                        if (this.board[i][j] != status.EMPTY && this.board[i][j] != s ){
                              System.out.println("hello");
                              ans = "$";
                              break;
                        }
                  }
            }
           return ans;      
      }
      public String checkColumns(){
            String ans="#";
            for(int i=0;i<3;i++){
                  if (this.board[i][0] == status.EMPTY)
                        continue;
                  status s = this.board[i][0];
                  ans = "#";
                  for(int j=1;j<3;j++){
                         if (this.board[i][j] != status.EMPTY && this.board[i][j] != s ){
                              ans = "$";
                              break;
                        }
                  }
            }
            return ans;      
      }
      public String checkDiagonals(){
            String ans="#";
            for(int i=0;i<3;i++){
                  if (this.board[i][0] == status.EMPTY)
                        continue;
                  status s = this.board[i][0];
                  ans = "#";
                  for(int j=1;j<3;j++){
                         if (this.board[i][j] != status.EMPTY && this.board[i][j] != s ){
                        
                              ans = "$";
                              break;
                        }
                  }
            }
            return ans;        
      }
      public int checkWin(){
            if (checkRows()=="#"|| checkColumns()=="#" || checkDiagonals()=="#"){
                  return 1;
            }
            else
                  return 0;            
            
      } 
      public int allPosFull(){
            for(int i=0;i<3;i++){
                  for(int j=0;j<3;j++){
                        if (this.board[i][j] == status.EMPTY){
                              return 0;
                        }
                  }
            } 
            return 1;  
            
      } 
      
      public void printBoard(){
            for(int i=0;i<3;i++){
                  for(int j=0;j<3;j++){
                        System.out.print(this.board[i][j]+"\t");
                  }
                  System.out.println();
            }
            System.out.println();       
            
      } 
      public static void printPos(){
             for(int i=0;i<3;i++){
                  for(int j=0;j<3;j++){
                        System.out.print(i+","+j+"\t");
                  }
                  System.out.println();
            }   
            System.out.println();  
            
      }
      public static void main(String[] args){
            TicTacToe t = new TicTacToe();
            t.printBoard();
            Scanner in = new Scanner(System.in);
            System.out.println("WELCOME TO TIC-TAC-TOE IN JAVA");
            System.out.println("PLAYER - 1 GETS X AND PLAYER-2 GETS O");
            printPos();
            int player = 0;
            String m = "XO";
            int i=3;
            while(true){
                  int p = player+1;
                  System.out.println("Play your move Player - "+p+"\n");
                  System.out.println("Enter the position (x,y) you want to place "+m.charAt(player));
                  System.out.print("Enter x = ");
                  int x = in.nextInt();
                  System.out.print("Enter y = ");
                  int y = in.nextInt();
                  System.out.println();
                  t.move(x,y,player);
                  if (t.checkWin()==1){
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
