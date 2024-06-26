import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class encoder{
  public static void main (String[] args) throws FileNotFoundException{
    //System.out.println(args[1]);
    File plain1 = new File(args[1]);
    Scanner scipher = new Scanner(plain1);
    String plaintext = "";
    while (scipher.hasNextLine()) {
      plaintext = scipher.nextLine();
    }
    scipher.close();
    //System.out.println("CIPHERTEXT: " + ciphertext);
    //System.out.println("");
    File key = new File(args[2]);
    Scanner skey = new Scanner(key);
    String keytext = "";
    while (skey.hasNextLine()) {
      keytext = skey.nextLine();
    }
    skey.close();
    //System.out.println(keytext);
    if (keytext.length() == 9){
      int[][] key1 = new int[3][3];
      int row = 0;
      int col = 0;
      int k = 0;
      while (k < keytext.length()) {
        key1[row][col] = keytext.charAt(k) - 65;
        col++;
        if (col == 3){
          row++;
          col = 0;
        }
        k++;
      }

      /*for (int i = 0; i < key1.length; i++){
        for (int j = 0; j < key1[i].length; j++){
          System.out.println("key[" + i + "][" + j + "]: " + key1[i][j]);
        }
      }*/
      System.out.print("\nEncoded Message: ");
      if (plaintext.length() > 3){
        for (int i = 0; i < plaintext.length(); i+=3){
          String x = plaintext.substring(i, i+3);
          encoded3(x, key1);
        }
      } else encoded3(plaintext, key1);
      System.out.println("");

    } else if (keytext.length() == 4){
      int[][] key1 = new int[2][2];
      int row = 0;
      int col = 0;
      int k = 0;
      while (k < keytext.length()) {
        key1[row][col] = keytext.charAt(k) - 65;
        col++;
        if (col == 2){
          row++;
          col = 0;
        }
        k++;
      }

      /*for (int i = 0; i < key1.length; i++){
        for (int j = 0; j < key1[i].length; j++){
          System.out.println("key[" + i + "][" + j + "]: " + key1[i][j]);
        }
      }*/

      if (plaintext.length() > 2){
        for (int i = 0; i < plaintext.length(); i+=2){
          String x = plaintext.substring(i, i+2);
          encoded2(x, key1);
        }
      } else encoded2(plaintext, key1);
      System.out.println("");
    }

  }

  public static void encoded3 (String plaintext, int[][] key){
    int[][] mat = new int[1][3];
    int[][] list = new int[1][3];
    for (int i = 0; i < mat[0].length; i++){
      mat[0][i] = plaintext.charAt(i) - 65;
    }
    for (int j = 0; j < list[0].length; j++){
      for (int k = 0; k < key[0].length; k++){
        list[0][j] = list[0][j] + key[j][k] * mat[0][k];
      }
    }
    for (int n = 0; n < list[0].length; n++){
      System.out.print((char)((list[0][n] % 26) + 65));
    }
  }

  public static void encoded2 (String plaintext, int[][] key){
    int[][] mat = new int[1][2];
    int[][] list = new int[1][2];
    for (int i = 0; i < mat[0].length; i++){
      mat[0][i] = plaintext.charAt(i) - 65;
    }
    for (int j = 0; j < list[0].length; j++){
      for (int k = 0; k < key[0].length; k++){
        list[0][j] = list[0][j] + key[j][k] * mat[0][k];
      }
    }
    for (int n = 0; n < list[0].length; n++){
      System.out.print((char)((list[0][n] % 26) + 65));
    }
  }
}
