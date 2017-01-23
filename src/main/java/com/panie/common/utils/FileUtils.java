package com.panie.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件操作工具类 实现文件的创建、删除、复制、压缩、解压以及目录的创建、删除、复制、压缩解压等功能
 */
public class FileUtils extends org.apache.commons.io.FileUtils
{
    
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);
    
    /**
     * 复制单个文件，如果目标文件存在，则不覆盖
     * 
     * @param srcFileName 待复制的文件名
     * @param descFileName 目标文件名
     * @return 如果复制成功，则返回true，否则返回false
     */
    public static boolean copyFileToDirectory(String srcFileName, String descFileName)
    {
        return FileUtils.copyFileToDirectory(srcFileName, descFileName, false);
    }
    
    /**
     * 复制单个文件
     * 
     * @param srcFileName 待复制的文件名
     * @param descFileName 目标文件名
     * @param coverlay 如果目标文件已存在，是否覆盖
     * @return 如果复制成功，则返回true，否则返回false
     */
    public static boolean copyFileToDirectory(String srcFileName, String descFileName, boolean coverlay)
    {
        File srcFile = new File(srcFileName);
        File descFile = new File(descFileName);
        try
        {
            FileUtils.copyFileToDirectory(srcFile, descFile, coverlay);
        }
        catch (IOException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            logger.error(e1.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * 压缩文件或目录
     * 
     * @param srcDirName 压缩的根目录
     * @param fileName 根目录下的待压缩的文件名或文件夹名，其中*或""表示跟目录下的全部文件
     * @param descFileName 目标zip文件
     */
    public static void zipFiles(String srcDirName, String fileName, String descFileName)
    {
        // 判断目录是否存在
        if (srcDirName == null)
        {
            logger.debug("文件压缩失败，目录 " + srcDirName + " 不存在!");
            return;
        }
        File fileDir = new File(srcDirName);
        if (!fileDir.exists() || !fileDir.isDirectory())
        {
            logger.debug("文件压缩失败，目录 " + srcDirName + " 不存在!");
            return;
        }
        String dirPath = fileDir.getAbsolutePath();
        File descFile = new File(descFileName);
        try
        {
            ZipOutputStream zouts = new ZipOutputStream(new FileOutputStream(descFile));
            if ("*".equals(fileName) || "".equals(fileName))
            {
                FileUtils.zipDirectoryToZipFile(dirPath, fileDir, zouts);
            }
            else
            {
                File file = new File(fileDir, fileName);
                if (file.isFile())
                {
                    FileUtils.zipFilesToZipFile(dirPath, file, zouts);
                }
                else
                {
                    FileUtils.zipDirectoryToZipFile(dirPath, file, zouts);
                }
            }
            zouts.close();
        }
        catch (Exception e)
        {
            logger.debug("文件压缩失败：" + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    /**
     * 解压缩ZIP文件，将ZIP文件里的内容解压到descFileName目录下
     * 
     * @param zipFileName 需要解压的ZIP文件
     * @param descFileName 目标文件
     */
    public static boolean unZipFiles(String zipFileName, String descFileName)
    {
        String descFileNames = descFileName;
        if (!descFileNames.endsWith(File.separator))
        {
            descFileNames = descFileNames + File.separator;
        }
        try
        {
            // 根据ZIP文件创建ZipFile对象
            ZipFile zipFile = new ZipFile(zipFileName);
            ZipEntry entry = null;
            String entryName = null;
            String descFileDir = null;
            byte[] buf = new byte[4096];
            int readByte = 0;
            // 获取ZIP文件里所有的entry
            @SuppressWarnings("rawtypes")
            Enumeration enums = zipFile.entries();
            // 遍历所有entry
            while (enums.hasMoreElements())
            {
                entry = (ZipEntry)enums.nextElement();
                // 获得entry的名字
                entryName = entry.getName();
                descFileDir = descFileNames + entryName;
                if (entry.isDirectory())
                {
                    // 如果entry是一个目录，则创建目录
                    new File(descFileDir).mkdirs();
                    continue;
                }
                else
                {
                    // 如果entry是一个文件，则创建父目录
                    new File(descFileDir).getParentFile().mkdirs();
                }
                File file = new File(descFileDir);
                // 打开文件输出流
                OutputStream os = new FileOutputStream(file);
                // 从ZipFile对象中打开entry的输入流
                InputStream is = zipFile.getInputStream(entry);
                while ((readByte = is.read(buf)) != -1)
                {
                    os.write(buf, 0, readByte);
                }
                os.close();
                is.close();
            }
            zipFile.close();
            return true;
        }
        catch (Exception e)
        {
            logger.debug("文件解压失败：" + e.getMessage());
            return false;
        }
    }
    
    /**
     * 将目录压缩到ZIP输出流
     * 
     * @param dirPath 目录路径
     * @param fileDir 文件信息
     * @param zouts 输出流
     */
    public static void zipDirectoryToZipFile(String dirPath, File fileDir, ZipOutputStream zouts)
    {
        if (fileDir.isDirectory())
        {
            File[] files = fileDir.listFiles();
            // 空的文件夹
            if (files !=null && files.length == 0)
            {
                // 目录信息
                ZipEntry entry = new ZipEntry(getEntryName(dirPath, fileDir));
                try
                {
                    zouts.putNextEntry(entry);
                    zouts.closeEntry();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                return;
            }
            
            for (int i = 0; i < files.length; i++)
            {
                if (files[i].isFile())
                {
                    // 如果是文件，则调用文件压缩方法
                    FileUtils.zipFilesToZipFile(dirPath, files[i], zouts);
                }
                else
                {
                    // 如果是目录，则递归调用
                    FileUtils.zipDirectoryToZipFile(dirPath, files[i], zouts);
                }
            }
            
        }
        
    }
    
    /**
     * 将文件压缩到ZIP输出流
     * 
     * @param dirPath 目录路径
     * @param file 文件
     * @param zouts 输出流
     */
    public static void zipFilesToZipFile(String dirPath, File file, ZipOutputStream zouts)
    {
        FileInputStream fin = null;
        ZipEntry entry = null;
        // 创建复制缓冲区
        byte[] buf = new byte[4096];
        int readByte = 0;
        if (file.isFile())
        {
            try
            {
                // 创建一个文件输入流
                fin = new FileInputStream(file);
                // 创建一个ZipEntry
                entry = new ZipEntry(getEntryName(dirPath, file));
                // 存储信息到压缩文件
                zouts.putNextEntry(entry);
                // 复制字节到压缩文件
                while ((readByte = fin.read(buf)) != -1)
                {
                    zouts.write(buf, 0, readByte);
                }
                zouts.closeEntry();
                fin.close();
                System.out.println("添加文件 " + file.getAbsolutePath() + " 到zip文件中!");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        
    }
    
    /**
     * 获取待压缩文件在ZIP文件中entry的名字，即相对于跟目录的相对路径名
     * 
     * @param dirPat 目录名
     * @param file entry文件名
     * @return
     */
    private static String getEntryName(String dirPath, File file)
    {
        String dirPaths = dirPath;
        if (!dirPaths.endsWith(File.separator))
        {
            dirPaths = dirPaths + File.separator;
        }
        String filePath = file.getAbsolutePath();
        // 对于目录，必须在entry名字后面加上"/"，表示它将以目录项存储
        if (file.isDirectory())
        {
            filePath += "/";
        }
        int index = filePath.indexOf(dirPaths);
        
        return filePath.substring(index + dirPaths.length());
    }
}
