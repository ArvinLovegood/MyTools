package com.wzl.tools;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
 
/**
 * 下载网络资源
 * @author liuwenbin
 *
 */
public class DownFileFromUrlUtil {
    /**
     * 下载网络资源
     * @param url 下载的路径
     * @param fileFullName 保存到本地的路径和文件名（注意，文件的后缀要和网络资源的后缀相同）
     * @return 是否下载成功
     * @throws Exception
     */
    public static boolean downFile(String url, String fileFullName) throws Exception {
        URL u = new URL(url);
        byte[] buffer = new byte[1024 * 1024];
        int read;
        BufferedInputStream bin = null;
        try {
            bin = new BufferedInputStream(u.openStream());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        BufferedOutputStream bout = new BufferedOutputStream(
                new FileOutputStream(fileFullName, true));
        while ((read = bin.read(buffer)) > -1) {
            bout.write(buffer, 0, read);
        }
        bin.close();
        bout.flush();
        bout.close();
        return true;
    }
}