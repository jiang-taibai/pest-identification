package com.jsjds.service.impl;

import com.jsjds.service.FileOperationService;
import com.jsjds.utils.ResponseWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.util.*;

/**
 * @author Yang Jiabin
 * @time 2021/6/27 20:03
 * @desc
 */
@Service
public class FileOperationServiceImpl implements FileOperationService {

    //路径配置
    @Value("${pest-image-path.prefix}")
    private String pathProperties; // = "C:\\src\\Pests Identification\\" + "imgs"+ File.separator + "pests images" + File.separator

    @Override
public ResponseWrapper updateFolderByStateMap(Map<String, List<String>> stateMap, String speciesId) {
    boolean result = false;

    //当前害虫目录路径
    String pathDir = pathProperties + File.separator + "imgs" + File.separator + "pests images" + File.separator + speciesId;
    //用于标记
    HashMap<String, Boolean> hashMap = new HashMap<>();
    for (Map.Entry<String, List<String>> item : stateMap.entrySet()) {
        //标记文件夹已经存在
        hashMap.put(item.getKey(), true);
        System.out.println(item.getKey());
        //当前害虫下分类的路径
        File fileItem = new File(pathDir + sep + item.getKey());

        //文件夹不存在创建文件夹
        if (!fileItem.exists()) {
            System.out.println(fileItem.toString() + "不存在");
            fileItem.mkdirs();
        }

        // 更改这里
        updateFileByList(item.getValue(), pathProperties, item.getKey(), pathDir);
    }

    File fileDir = new File(pathDir);
    if (!fileDir.exists()) {
        System.out.println(fileDir + "不存在");
    }

    //获取该目录下所有文件
    String[] dirs = fileDir.list();

    //删除多余的类和多余的元素
    for (String dir : dirs) {
        if (!hashMap.containsKey(dir)) {
            deleteDir(pathDir + sep + dir);
        } else {
            List<String> dirList = stateMap.get(dir);
            HashMap<String, Boolean> vis = new HashMap<>();
            for (String item : dirList) {
                String[] strList = item.replaceAll("\\\\", "/").split("/");
                vis.put(strList[strList.length - 1], true);
            }
            String[] files = new File(pathDir + sep + dir).list();
            for (String file : files) {
                if (!vis.containsKey(file)) {
                    deleteAnyone(pathDir + sep + dir + sep + file);
                }
            }
        }
    }


    return ResponseWrapper.markSuccess(result);
}

    /**
     * 单个文件夹执行操作
     *
     * @param imgList
     * @param pathDir
     * @param dirName
     */
    private void updateFileByList(List<String> imgList, String pathDir, String dirName, String pestDir) {
        for (String item : imgList) {
            // 如果不包含这个分类目录的名称，就说明是其他目录过来的
            if (!item.contains(sep + dirName + sep)) {
                String[] strList = item.replaceAll("\\\\", "/").split("/");
                String startPath = pathDir + File.separator + item;
                startPath = startPath.replace("\\\\", "\\");
                String endPath = pestDir + sep + dirName;
                moveFile(startPath, endPath);
            }
        }
    }


    /**
     * 移动文件
     *
     * @param startPath 源文件的路径
     * @param endPath   目的目录路径
     * @return
     */
    @Override
    public boolean moveFile(String startPath, String endPath) {
        System.out.println("startPath = " + startPath);
        System.out.println("endPath = " + endPath);
        boolean result = false;
        //源文件的路径
        File startFile = new File(startPath);
        //目的目录路径
        File endDirection = new File(endPath);

        if (!startFile.exists()) {
            System.out.println(startPath + "不存在");
            return result;
        }

        //如果目的目录路径不存在，则进行创建
        if (!endDirection.exists()) {
            endDirection.mkdirs();
        }

        // 目的文件路径=目的目录路径+源文件名称
        File endFile = new File(endDirection + File.separator + startFile.getName());

        try {
            //调用File类的核心方法renameTo
            if (startFile.renameTo(endFile)) {
                result = true;
                System.out.println("文件移动成功！目标路径：{" + endFile.getAbsolutePath() + "}");
            } else {
                System.out.println("文件移动失败！起始路径：{" + startFile.getAbsolutePath() + "}");
            }
        } catch (Exception e) {
            System.out.println("文件移动出现异常！起始路径：{" + startFile.getAbsolutePath() + "}");
        }
        return result;
    }


    /**
     * 判断指定的文件或文件夹删除是否成功
     *
     * @param FileName 文件或文件夹的路径
     * @return true or false 成功返回true，失败返回false
     */
    @Override
    public boolean deleteAnyone(String FileName) {

        File file = new File(FileName);//根据指定的文件名创建File对象


        if (!file.exists()) {  //要删除的文件不存在
            System.out.println("文件" + FileName + "不存在，删除失败！");
            return false;
        } else { //要删除的文件存在

            if (file.isFile()) { //如果目标文件是文件

                return deleteFile(FileName);

            } else {  //如果目标文件是目录
                return deleteDir(FileName);
            }
        }
    }

    @Override
    public boolean fileRenameToUUID(String filePath) {
        File fileDir = new File(filePath);
        boolean result = false;
        if (!fileDir.exists()) {
            System.out.println(filePath + "不存在");
            return result;
        }
        if (!fileDir.isDirectory()) {
            System.out.println(filePath + "不是文件夹");
            return result;
        }

        //获取目录下的所有文件
        File[] files = fileDir.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            UUID uuid = UUID.randomUUID();
            if (fileName.equals(noRename)) {
                System.out.println(fileName + "不用改");
            }

            //如果是文件夹
            if (file.isDirectory()) {
                String oldPath = filePath + File.separator + fileName;
                String newPath = filePath + File.separator + uuid;
                String renameResult = fileRename(oldPath, newPath);
                System.out.println("更新后的文件名：" + renameResult);
            } else {

                String oldPath = filePath + File.separator + fileName;
                String[] sp = fileName.split("\\.");
                String newPath = "";
                if (sp.length == 2) {
                    newPath = filePath + File.separator + uuid + "." + sp[sp.length - 1];
                } else {
                    System.out.println(sp.length);
                    System.out.println("不是文件类型:" + fileName);
                }
                String renameResult = fileRename(oldPath, newPath);
                System.out.println("更新后的文件名：" + renameResult);
            }
        }

        result = true;
        return result;
    }


    @Override
    public String fileRename(String filePath, String newFileName) {
        File startFile = new File(filePath);
        File endFile = new File(newFileName);
        try {
            //调用File类的核心方法renameTo
            if (startFile.renameTo(endFile)) {
                System.out.println("文件修改成功！目标路径：{" + endFile.getAbsolutePath() + "}");
            } else {
                System.out.println("文件修改失败！起始路径：{" + startFile.getAbsolutePath() + "}");
            }
        } catch (Exception e) {
            System.out.println("文件修改出现异常！起始路径：{" + startFile.getAbsolutePath() + "}");
        }
        return newFileName;
    }


    /**
     * 判断指定的文件删除是否成功
     *
     * @param fileName 文件路径
     * @return true or false 成功返回true，失败返回false
     */
    @Override
    public boolean deleteFile(String fileName) {


        File file = new File(fileName);//根据指定的文件名创建File对象

        if (file.exists() && file.isFile()) { //要删除的文件存在且是文件

            if (file.delete()) {
                System.out.println("文件" + fileName + "删除成功！");
                return true;
            } else {
                System.out.println("文件" + fileName + "删除失败！");
                return false;
            }
        } else {

            System.out.println("文件" + fileName + "不存在，删除失败！");
            return false;
        }


    }


    /**
     * 删除指定的目录以及目录下的所有子文件
     *
     * @param dirName is 目录路径
     * @return true or false 成功返回true，失败返回false
     */
    @Override
    public boolean deleteDir(String dirName) {

        if (dirName.endsWith(File.separator))//dirName不以分隔符结尾则自动添加分隔符
            dirName = dirName + File.separator;

        File file = new File(dirName);//根据指定的文件名创建File对象

        if (!file.exists() || (!file.isDirectory())) { //目录不存在或者
            System.out.println("目录删除失败" + dirName + "目录不存在！");
            return false;
        }

        File[] fileArrays = file.listFiles();//列出源文件下所有文件，包括子目录


        for (int i = 0; i < fileArrays.length; i++) {//将源文件下的所有文件逐个删除

            deleteAnyone(fileArrays[i].getAbsolutePath());

        }


        if (file.delete())//删除当前目录
            System.out.println("目录" + dirName + "删除成功！");


        return true;

    }

}
