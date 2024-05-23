import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class encoder{
  public static void main (String[] args) throws FileNotFoundException{
    
  }

  public static encoded (String plaintext, int[][] key){
    int[][] mat = 0;
    for(i = 0; i < plaintexy.length; i++){
      if (i % key.length = key.length - 1){
        mat[i-key.length+1][1] = (plaintext.charAt(i-key.length + 1) - 65) * key[i - key.length + 1][i - key.length + 1];
      }
    }
  }
}
