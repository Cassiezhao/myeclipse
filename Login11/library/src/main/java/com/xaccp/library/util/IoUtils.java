package com.xaccp.library.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tao.zeng on 2016/5/13.
 */
public final class IoUtils {

    public static void closeIO(Closeable... closeables) {
        for (Closeable close : closeables) {
            if (close != null) {
                try {
                    close.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static File bytes2File(byte[] data, String outputFile) {
        BufferedOutputStream stream = null;
        File file = null;
        try {
            file = new File(outputFile);
            FileOutputStream fos = new FileOutputStream(file);
            stream = new BufferedOutputStream(fos);
            stream.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeIO(stream);
        }
        return file;
    }

    public static void delete(File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(String fileName) {
        delete(new File(fileName));
    }


    public static byte[] readStreamAsBytesArray(InputStream in)
            throws IOException {
        if (in == null) {
            return new byte[0];
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 8];
        int len;
        while ((len = in.read(buffer)) > -1) {
            output.write(buffer, 0, len);
        }
        output.flush();
        return output.toByteArray();
    }

    public static byte[] readStreamAsBytesArray(InputStream in, int readLength)
            throws IOException {
        if (in == null) {
            return new byte[0];
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 8];
        int len;
        long readed = 0;
        while (readed < readLength && (len = in.read(buffer, 0, Math.min(2048, (int) (readLength - readed)))) > -1) {
            output.write(buffer, 0, len);
            readed += len;
        }
        output.flush();
        return output.toByteArray();
    }
}
