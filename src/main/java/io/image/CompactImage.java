package io.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 拼接图片
 *
 * @author: zhang_jin[zhang_jin@suixingpay.com]
 * @date: 2017年9月25日 下午10:20:22
 * @version: V1.0
 * @review: zhang_jin[zhang_jin@suixingpay.com]/2017年9月25日 下午10:20:22
 */
public class CompactImage {
    public static void main(String[] args) throws IOException {
        File image1 = new File("F:/img/zhishi.jpg");

        BufferedImage buf = ImageIO.read(image1);
        int width1 = buf.getWidth();
        int height1 = buf.getHeight();

        // 缩小边长
        BufferedImage tag = new BufferedImage(width1 / 2, height1 / 2, BufferedImage.TYPE_INT_RGB);
        // 绘制 缩小  后的图片
        tag.getGraphics().drawImage(buf, 0, 0, width1 / 2, height1 / 2, null);
        //从图片中读取RGB    
        int[] imageArray1 = new int[width1 / 2 * height1 / 2];
        imageArray1 = tag.getRGB(0, 0, width1 / 2, height1 / 2, imageArray1, 0, width1 / 2);


        File image2 = new File("F:/img/zhishi2.jpg");
        BufferedImage buf2 = ImageIO.read(image2);
        int width2 = buf2.getWidth();
        int height2 = buf2.getHeight();
        // 缩小边长
        BufferedImage tag2 = new BufferedImage(width2 / 2, height2 / 2, BufferedImage.TYPE_INT_RGB);
        // 绘制 缩小  后的图片
        tag2.getGraphics().drawImage(buf2, 0, 0, width2 / 2, height2 / 2, null);
        //从图片中读取RGB    
        int[] imageArray2 = new int[width2 / 2 * height2 / 2];
        imageArray2 = tag2.getRGB(0, 0, width2 / 2, height2 / 2, imageArray2, 0, width2 / 2);

        //生成新图片
        BufferedImage imageNew = new BufferedImage(width1 / 2 + width2 / 2, height1 / 2, BufferedImage.TYPE_INT_RGB);
        imageNew.setRGB(0, 0, width1 / 2, height1 / 2, imageArray1, 0, width1 / 2);//设置左半部分的RGB
        imageNew.setRGB(width1 / 2, 0, width2 / 2, height2 / 2, imageArray2, 0, width2 / 2);//设置右半部分的RGB

        File outFile = new File("F:/img/test.jpg");
        ImageIO.write(imageNew, "jpg", outFile);//写图片

    }


}
