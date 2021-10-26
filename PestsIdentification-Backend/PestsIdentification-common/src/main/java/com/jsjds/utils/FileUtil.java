package com.jsjds.utils;

import java.io.File;

/**
 * <p>创建时间：2021-07-01 20:22</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class FileUtil {

    public static String getRelativeFileName(File baseDir, File file) {
        String absolutePath = file.getAbsolutePath();
        if (baseDir == null) {
            return absolutePath;
        }
        if (baseDir.equals(file)) {
            return absolutePath;
        }
        if (baseDir.getParentFile() == null) {
            return absolutePath.substring(baseDir.getAbsolutePath().length());
        }
        return absolutePath.substring(baseDir.getAbsolutePath().length() + 1);
    }

    /**
     * 修改文件夹的名称
     * @param originalPath 原始文件夹的路径
     * @param newName 文件夹的新名称
     * @return 是否修改成功
     */
    public static File rename(String originalPath, String newName) {
        File resFile = new File(originalPath);
        if (!resFile.exists()) {
            return null;
        }
        String newFilePath = resFile.getParent() + File.separator + newName;
        File newFile = new File(newFilePath);
        if(resFile.renameTo(newFile)) {
            return newFile;
        }
        return null;
    }

}
