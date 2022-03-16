import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        System.out.println("Enter a file name: ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine() + ".txt";

        System.out.println("Enter the path to file");
        String path = reader.readLine();

        path.replace("\\", "/");



        Image img = new ImageIcon(path).getImage();

        ImgToAscii obj = new ImgToAscii(img, file);
        obj.convertToAscii(path);
    }
}

/*
    P.S. File with Ascii will create in main dir (AsciiArt)
 */