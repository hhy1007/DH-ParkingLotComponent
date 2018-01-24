/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.image;

/**
 * @Class Name IImageService
 * @Author zhangli
 * @Create In 2017年12月20日
 */
public interface ImageService {

    /**
     * 根据图像id获取图像数据
     * 
     * @Methods Name getImageData
     * @Create In 2017年12月20日 By zhangli
     * @param imageId
     * @return String
     */
    byte[] getImageData(String imageId);
    

    /**
     * 删除图片
     * @Methods Name deleteFile
     * @Create In 2017年12月20日 By zhangli
     * @param data
     * @return 0-success 非0-failed
     * @throws Exception int
     */
    int deleteFile(String id);

}
