package com.ofdbox.convertor.test.img;

import com.ofdbox.convertor.img.Ofd2Img;
import com.ofdbox.core.OFD;
import com.ofdbox.core.OFDReader;
import com.ofdbox.convertor.test.utils.PathUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImgConverterTest {
    protected static final String basePath = PathUtils.getClassPath(ImgConverterTest.class);

    @Test
    public void toImg() throws IOException {

        OFDReader reader = new OFDReader();
        reader.getConfig().setValid(false);
        OFD ofd = reader.read(new File(basePath+"发票.ofd"));
        OFD ofd1 = reader.read(new File(basePath+"旋转测试.ofd"));
        OFD ofd2 = reader.read(new File(basePath+"font/0000000005.ofd"));

        Ofd2Img ofd2Img = new Ofd2Img();
        ofd2Img.getConfig().setDrawBoundary(false);

//        BufferedImage image = ofd2Img.toImage(ofd.getDocuments().get(0).getPages().get(0), 20);
//        BufferedImage image1 = ofd2Img.toImage(ofd1.getDocuments().get(0).getPages().get(0), 20);
        BufferedImage image2 = ofd2Img.toImage(ofd2.getDocuments().get(0).getPages().get(0), 20);
//        ImageIO.write(image, "JPEG", new FileOutputStream(new File(basePath,"发票.jpg")));
//        ImageIO.write(image1, "JPEG", new FileOutputStream(new File(basePath,"旋转测试.jpg")));
        ImageIO.write(image2, "JPEG", new FileOutputStream(new File(basePath,"0000000005.jpg")));

    }
}
