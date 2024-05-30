import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class encoder{
  public static void main (String[] args) throws FileNotFoundException{
    //System.out.println(args[1]);
    File plain = new File(args[1]);
    Scanner splain = new Scanner(plain);
    String plaintext = "";
    while (splain.hasNextLine()) {
      plaintext = splain.nextLine();
    }
    splain.close();
    System.out.println("PLAINTEXT: " + plaintext);
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
    encoded(plaintext, key1);
  }

  public static void encoded (String plaintext, int[][] key){
    int[][] mat = new int[1][3];
    int[] list = new int[0];
    for (int i = 0; i < mat[0].length; i++){
      mat[0][i] = plaintext.charAt(i) - 65;
      System.out.println("mat[0][" + i + "]: " + mat[0][i]);
    }
    for (int j = 0; j < list.length; j++){
      for (int k = 0; k < key[0].length; k++){
        list[j] = list[j] + key[j][k] * mat[0][k]; 
      }
    }
    for (int l = 0; l < list.length; l++){
      System.out.print(list[l]);
    }

    /*for(int i = 0; i < plaintext.length(); i++){
      if (i % key.length == key.length - 1){
        //mat[i-key.length+1][1] = (plaintext.charAt(i-key.length + 1) - 65) * key[i - key.length + 1][i - key.length + 1];
        System.out.println("hi");
      }
    }*/
  }
}
