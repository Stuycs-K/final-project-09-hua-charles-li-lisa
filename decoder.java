import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class decoder{
  public static void main (String[] args) throws FileNotFoundException{
    //System.out.println(args[1]);
    File cipher = new File(args[1]);
    Scanner scipher = new Scanner(cipher);
    String ciphertext = "";
    while (scipher.hasNextLine()) {
      ciphertext = scipher.nextLine();
    }
    scipher.close();
    System.out.println("CIPHERTEXT: " + ciphertext);
    System.out.println("");
    File key = new File(args[2]);
    Scanner skey = new Scanner(key);
    String keytext = "";
    while (skey.hasNextLine()) {
      keytext = skey.nextLine();
    }
    skey.close();
    //System.out.println(keytext);

    Scanner skey2 = new Scanner(keytext);
    int[][] key1 = new int[3][3];
    int row = 0;
    int col = 0;
    while (skey2.hasNextInt()) {
      key1[row][col] = skey2.nextInt();
      col++;
      if (col == 3){
        row++;
        col = 0;
      }
    }
    skey2.close();

    for (int i = 0; i < key1.length; i++){
      for (int j = 0; j < key1[i].length; j++){
        System.out.println("key[" + i + "][" + j + "]: " + key1[i][j]);
      }
    }
    System.out.println("");
    decoded(ciphertext, key1);
  }


  public static void decoded (String ciphertext, int[][] key){
    int[][] mat = new int[1][3];
    for (int i = 0; i < mat[0].length; i++){
      mat[0][i] = ciphertext.charAt(i) - 65;
      System.out.println("mat[0][" + i + "]: " + mat[0][i]);
    }
    int det = key[0][0]*(key[1][1]*key[2][2] - key[1][2]*key[2][1])
            - key[0][1]*(key[1][0]*key[2][2] - key[1][2]*key[2][0])
            + key[0][2]*(key[1][0]*key[2][1] - key[1][1]*key[2][0]);

    System.out.println(det);
    /*int[][] identity = {1, 0, 0, 0, 1, 0, 0, 0, 1};
    int[][] inverse = new int[3][3];
    for (int i = 0; i < key.length; i++){
      for (int j = 0; j < key[0].length; j++){

      }
    }*/
  }
}
