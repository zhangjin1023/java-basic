package http;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpUtil {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = new URL("https://zjnrzj.95516.com/download/20171212/100000000000018/H4c273eda90f0830f5bf28faa1da1594f/100000000000018-20171212-DZ.txt").openStream();
            byte[] byteStream = readInputStream(is);
            File file = new File("D:\\temp\\test.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(byteStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("根据银行所给地址，未找到对账文件。详情咨询银行人员");// 据银行人员介绍，对账文件只保留最近15天的，可能出现正确返回地址却没有文件的情况
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 从输入流中获取数据
     *
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }


}
