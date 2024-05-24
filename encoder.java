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
    System.out.println(plaintext);

    File key = new File(args[2]);
    Scanner skey = new Scanner(key);
    String keytext = "";
    while (skey.hasNextLine()) {
      keytext = skey.nextLine();
    }
    skey.close();
    System.out.println(keytext);

  }

  public static void encoded (String plaintext, int[][] key){
    //int[][] mat = 0;
    for(int i = 0; i < plaintext.length(); i++){
      if (i % key.length == key.length - 1){
        //mat[i-key.length+1][1] = (plaintext.charAt(i-key.length + 1) - 65) * key[i - key.length + 1][i - key.length + 1];
        System.out.println("hi");
      }
    }
  }
}
