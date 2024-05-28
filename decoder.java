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
    //encoded(plaintext, key1);
  }
}
