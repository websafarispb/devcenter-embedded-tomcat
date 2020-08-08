package generator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BarecodeGenerator {
	
	public List<BufferedImage> bufferedImageList = new ArrayList<BufferedImage>();
	
	public void generateBarcode(String sequence) throws Exception {
		
		String fileNameTemple = "bar.jpg";
        File output = new File(getClass().getClassLoader().getResource(fileNameTemple).getFile());
        BufferedImage code = generateEAN13BarcodeImage(sequence);


        File numbers = new File("numbers.jpg");
     //   BufferedImage num = ImageIO.read(numbers);
        BufferedImage num  = ImageIO.read(getClass().getClassLoader().getResource("numbers.jpg"));

        BufferedImage result = new BufferedImage(code.getWidth()-5, code.getHeight()+30, code.getType());
        int [] codeRGB2 = new int [2500];
        int [] codeRGB  = code.getRGB(0,0,250,100,codeRGB2,0,0);
        result.setRGB(0,0,250,100,codeRGB,0,0);
        
        ImageIO.write(code, "jpg", output);


        bufferedImageList.add(num.getSubimage(125,45,25,30));
        bufferedImageList.add(num.getSubimage(0,0,25,30));
        bufferedImageList.add(num.getSubimage(35,0,25,30));
        bufferedImageList.add(num.getSubimage(65,0,25,30));
        bufferedImageList.add(num.getSubimage(95,0,25,30));
        bufferedImageList.add(num.getSubimage(125,0,25,30));
        bufferedImageList.add(num.getSubimage(0,45,25,30));
        bufferedImageList.add(num.getSubimage(35,45,25,30));
        bufferedImageList.add(num.getSubimage(65,45,25,30));
        bufferedImageList.add(num.getSubimage(95,45,25,30));
       
        char [] chres  = sequence.toCharArray();
        for(int i = 0; i < chres.length; i++){
            System.out.println("write char " + chres[i]);
            makeRasterNumber(bufferedImageList.get(Character.getNumericValue(chres[i])),result, (i*25));
        }




      //  ImageIO.write(result, "jpg", new File("one2.jpg"));
    //    ImageIO.write(result, "jpg", new File("C:\\fox\\devcenter-embedded-tomcat\\src\\main\\webapp\\one.jpg"));
        ImageIO.write(result, "jpg", new File(getClass().getClassLoader().getResource("one.jpg").getFile()));



    }

    public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws Exception {
        Code128Writer barcodeWriter = new Code128Writer();
        BitMatrix bitMatrix =
                barcodeWriter.encode(barcodeText, BarcodeFormat.CODE_128, 256, 100);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
    public static void makeRasterNumber(BufferedImage sourse, BufferedImage distination, int dx){
        for(int x = 0; x < sourse.getWidth(); x++){
            for(int y = 0; y < sourse.getHeight(); y++){
                Color color = new Color(sourse.getRGB(x, y));
                distination.setRGB(x+dx, y+100, color.getRGB());

            }
        }
    }

}
