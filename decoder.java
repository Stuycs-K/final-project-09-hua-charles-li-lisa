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
      System.out.print("\nDecoded Message: ");
      if (ciphertext.length() > 3){
        for (int i = 0; i < ciphertext.length(); i+=3){
          String x = ciphertext.substring(i, i+3);
          decoded3(x, key1);
        }
      } else decoded3(ciphertext, key1);

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
      System.out.print("\nDecoded Message: ");
      if (ciphertext.length() > 2){
        for (int i = 0; i < ciphertext.length(); i+=2){
          String x = ciphertext.substring(i, i+2);
          decoded2(x, key1);
        }
      } else decoded2(ciphertext, key1);
    }

  }

  public static void decoded3 (String ciphertext, int[][] key){
    boolean inverseM = false;
    int[][] mat = new int[1][3];
    for (int i = 0; i < mat[0].length; i++){
      mat[0][i] = ciphertext.charAt(i) - 65;
      //System.out.println("mat[0][" + i + "]: " + mat[0][i]);
    }
    int det = key[0][0]*(key[1][1]*key[2][2] - key[1][2]*key[2][1])
    - key[0][1]*(key[1][0]*key[2][2] - key[1][2]*key[2][0])
    + key[0][2]*(key[1][0]*key[2][1] - key[1][1]*key[2][0]);
    /*det = a(ei-fh)
    - b(di-fg)
    + c(dh-eg)
    */
    //System.out.println("");
    //System.out.println("Det: " + det);
    if (det != 0){
      //System.out.println("There is an inverse.");
      inverseM = true;
    } else {
      //System.out.println("This is singular.");
      inverseM = false;
    }
    //int[][] identity = {1, 0, 0, 0, 1, 0, 0, 0, 1};
    //System.out.println("");
    if (inverseM){
      int[][] cofac = new int[3][3];
      cofac[0][0] = key[1][1]*key[2][2] - key[1][2]*key[2][1];
      cofac[0][1] = -1 * (key[1][0]*key[2][2] - key[1][2]*key[2][0]);
      cofac[0][2] = key[0][1]*key[1][2] - key[0][2]*key[1][1];
      cofac[1][0] = -1 * (key[0][1]*key[2][2] - key[0][2]*key[2][1]);
      cofac[1][1] = key[0][0]*key[2][2] - key[0][2]*key[2][0];
      cofac[1][2] = -1 * (key[0][0]*key[2][1] - key[0][1]*key[2][0]);
      cofac[2][0] = key[1][0]*key[2][1] - key[1][1]*key[2][0];
      cofac[2][1] = -1 * (key[0][0]*key[1][2] - key[0][2]*key[1][0]);
      cofac[2][2] = key[0][0]*key[1][1] - key[0][1]*key[1][0];

      int[][] inverse = new int[3][3];
      inverse[0][0] = cofac[0][0];
      inverse[0][1] = cofac[1][0];
      inverse[0][2] = cofac[0][2];
      inverse[1][0] = cofac[0][1];
      inverse[1][1] = cofac[1][1];
      inverse[1][2] = cofac[2][1];
      inverse[2][0] = cofac[2][0];
      inverse[2][1] = cofac[1][2];
      inverse[2][2] = cofac[2][2];

      for (int i = 0; i < inverse.length; i++){
        for (int j = 0; j < inverse[0].length; j++){
          if (inverse[i][j] < 0){
            inverse[i][j] %= 26;
            inverse[i][j] = 26 + inverse[i][j];
          } else inverse[i][j] %= 26;
          //System.out.println("inverse[" + i + "][" + j + "]: " + inverse[i][j]);
        }
      }

      int midet = 0;
      int a = 2;
      int tmp = (1 * midet) % 26;
      if (det < 0){
        //midet = 26 + det;
        midet = 26 + det;
      } else midet = det % 26;
      while (true){
        if ((a * midet) % 26 == 1){
          midet = a;
          break;
        }
        if (tmp == (a * midet) % 26){
          System.out.println("There is no modular multiplicative inverse.");
          inverseM = false;
          break;
        }
        a++;
      }
      //System.out.println("Midet: " + midet);
      if (inverseM){
        for (int i = 0; i < inverse.length; i++){
          for (int j = 0; j < inverse[0].length; j++){
            inverse[i][j] *= midet;
            inverse[i][j] = inverse[i][j] % 26;
            //System.out.println("inverse[" + i + "][" + j + "]: " + inverse[i][j]);
          }
        }
        //System.out.println("");

        int[][] plain = new int[1][3];
        plain[0][0] = inverse[0][0] * mat[0][0] + inverse[0][1] * mat[0][1] + inverse[0][2] * mat[0][2];
        plain[0][1] = inverse[1][0] * mat[0][0] + inverse[1][1] * mat[0][1] + inverse[1][2] * mat[0][2];
        plain[0][2] = inverse[2][0] * mat[0][0] + inverse[2][1] * mat[0][1] + inverse[2][2] * mat[0][2];
        for (int i = 0; i < plain[0].length; i++){
          plain[0][i] %= 26;
          //System.out.println("plain[0][" + i + "]: " + plain[0][i]);
        }
        for (int i = 0; i < plain[0].length; i++){
          System.out.print((char) (plain[0][i] + 65));
        }
      } else System.out.println("Cannot decode this message.");
    } else System.out.println("Cannot decode this message.");
  }

  public static void decoded2 (String ciphertext, int[][] key){
    boolean inverseM = false;
    int[][] mat = new int[2][1];
    for (int i = 0; i < mat.length; i++){
      mat[i][0] = ciphertext.charAt(i) - 65;
      //System.out.println("mat[" + i + "][0]: " + mat[i][0]);
    }
    int det = key[0][0]*key[1][1] - key[0][1]*key[1][0];
    //det = ad - bc
    //System.out.println("");
    //System.out.println("Det: " + det);
    if (det != 0){
      //System.out.println("There is an inverse.");
      inverseM = true;
    } else {
      //System.out.println("This is singular.");
      inverseM = false;
    }
    //int[][] identity = {1, 0, 0, 0, 1, 0, 0, 0, 1};
    //System.out.println("");
    if (inverseM){
      int[][] adj = new int[2][2];
      adj[0][0] = key[1][1];
      adj[0][1] = -1 * key[0][1];
      adj[1][0] = -1 * key[1][0];
      adj[1][1] = key[0][0];

      for (int i = 0; i < adj.length; i++){
        for (int j = 0; j < adj[0].length; j++){
          if (adj[i][j] < 0){
            adj[i][j] %= 26;
            adj[i][j] = 26 + adj[i][j];
          } else adj[i][j] %= 26;
          //System.out.println("adj[" + i + "][" + j + "]: " + adj[i][j]);
        }
      }
      int[][] inverse = new int[2][2];

      int midet = 0;
      int a = 2;
      int tmp = (1 * midet) % 26;
      if (det < 0){
        //midet = 26 + det;
        midet = 26 + det;
      } else midet = det % 26;
      while (true){
        if ((a * midet) % 26 == 1){
          midet = a;
          break;
        }
        if (tmp == (a * midet) % 26){
          System.out.println("There is no modular multiplicative inverse.");
          inverseM = false;
          break;
        }
        a++;
      }
      //System.out.println("Midet: " + midet);
      if (inverseM){
        for (int i = 0; i < inverse.length; i++){
          for (int j = 0; j < inverse[0].length; j++){
            inverse[i][j] = adj[i][j];
            inverse[i][j] *= midet;
            inverse[i][j] = inverse[i][j] % 26;
            //System.out.println("inverse[" + i + "][" + j + "]: " + inverse[i][j]);
          }
        }
        //System.out.println("");

        int[][] plain = new int[2][1];
        plain[0][0] = inverse[0][0]*mat[0][0] + inverse[0][1]*mat[1][0];
        plain[1][0] = inverse[1][0]*mat[0][0] + inverse[1][1]*mat[1][0];
        for (int i = 0; i < plain.length; i++){
          plain[i][0] %= 26;
          //System.out.println("plain[" + i + "][0]: " + plain[i][0]);
        }
        for (int i = 0; i < plain.length; i++){
          System.out.print((char) (plain[i][0] + 65));
        }
      } else System.out.println("Cannot decode this message.");
    } else System.out.println("Cannot decode this message.");
  }
}
