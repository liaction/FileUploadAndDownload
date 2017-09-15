package com.liaction.file.servlet;

import java.io.File;
import java.util.UUID;

public class FileUtils {

  // todo 根据实际情况进行修改
  public static final String FILE_PATH =
      "D:" + File.separator + "uploads" + File.separator + "files";
  public static final String FILE_PATH_TEMP =
      "D:" + File.separator + "uploads" + File.separator + "temp";

  public static String getFilePath(String filename, String saveRootPath) {
    int hashcode = filename.hashCode();
    int dir1 = hashcode & 0xf;  //0--15
    int dir2 = (hashcode & 0xf0) >> 4;  //0-15
    String dirPath =
        saveRootPath + File.separator + dir1 + File.separator + dir2;  //upload\2\3  upload\3\5
    File file = new File(dirPath);
    if (!file.exists()) {
      //创建目录
      if (file.mkdirs()) {
        System.out.println("创建成功 : " + file.getAbsolutePath());
      }else {
        System.out.println("创建失败 : " + file.getAbsolutePath());
      }
    }
    return dirPath;
  }

  /**
   * @param filename 文件的原始名称
   * @return uuid+"_"+文件的原始名称
   * @Method: makeFileName
   * @Description: 生成上传文件的文件名，文件名以：uuid+"_"+文件的原始名称
   * @Anthor:孤傲苍狼
   */
  public static String makeFileName(String filename) {  //2.jpg
    //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
    return UUID.randomUUID().toString() + "_" + filename;
  }
}
