import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;


public class ImgToAscii {
    //Create main variable
    private BufferedImage img;
    private PrintWriter writer;
    private FileWriter fileWriter;

    public ImgToAscii(Image s, String filename){
        try {
            writer = new PrintWriter(fileWriter = new FileWriter(filename, true));
        }catch (IOException ex){}
    }

    public void convertToAscii(String imgname){
        try {
            img = ImageIO.read(new File(imgname));
        }catch (IOException ex){}

        //i+=2 so it will not so high
        for (int i = 0; i < img.getHeight(); i+=2){
            for (int j = 0; j < img.getWidth(); j++){
                Color color = new Color(img.getRGB(j, i));
                double pixval = (((color.getRed() * 0.30) + (color.getBlue() * 0.59) + (color.getGreen() * 0.11)));
                print(strChar(pixval));
            }

            try {
                writer.println("");
                writer.flush();
                fileWriter.flush();
            } catch (Exception ex) {}
        }
    }

    //select chars for every color
    public String strChar(double g) {
        String str = " ";
        if (g >= 240) {
            str = " ";
        } else if (g >= 210) {
            str = ".";
        } else if (g >= 190) {
            str = "*";
        } else if (g >= 170) {
            str = "+";
        } else if (g >= 120) {
            str = "^";
        } else if (g >= 110) {
            str = "&";
        } else if (g >= 80) {
            str = "8";
        } else if (g >= 60) {
            str = "#";
        } else {
            str = "@";
        }
        return str;
    }

    //print that shit
    public void print(String str) {
        try {
            writer.print(str);
            writer.flush();
            fileWriter.flush();
        } catch (Exception ex) {}
    }
}
