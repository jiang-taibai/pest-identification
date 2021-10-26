package com.jsjds.service;

import com.jsjds.utils.ResponseWrapper;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Yang Jiabin
 * @time 2021/6/27 19:52
 * @desc 系统文件操作接口
 */
public interface FileOperationService {

    final static String sep = File.separator;

    //UUId
    final static String noRename = "#preview.jpg";

    /**
     * 根据状态数组更新系统内部文件夹与文件位置
     * @param stateMap 存储状态
     * @return 返回是否移动成功
     */
    public ResponseWrapper updateFolderByStateMap(Map<String , List<String>> stateMap , String speciesId);


    /**
     * 移动文件
     * @param startPath 源文件的路径
     * @param endPath   目的目录路径
     * @return 是否移动成功
     */
    public boolean moveFile(String startPath ,String endPath);


    /**
     * 删除指定的目录以及目录下的所有子文件
     * @param dirName is 目录路径
     * @return true or false 成功返回true，失败返回false
     */
    public boolean deleteDir(String dirName);


    /**
     * 判断指定的文件删除是否成功
     * @param fileName 文件路径
     * @return true or false 成功返回true，失败返回false
     */
    public boolean deleteFile(String fileName);


    /**
     * 判断指定的文件或文件夹删除是否成功
     * @param FileName 文件或文件夹的路径
     * @return true or false 成功返回true，失败返回false
     */
    public boolean deleteAnyone(String FileName);


    /**
     * 修改filePath目录下的文件为UUID
     * @param filePath 文件路径
     * @return 是否修改成功
     */
    public boolean fileRenameToUUID(String filePath);

    /**
     * 修改文件名
     * @param filePath 源文件绝对路径
     * @param newFileName 修改后决对路径
     * @return
     */
    public String fileRename(String filePath, String newFileName);
}
