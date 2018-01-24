/**
 * Copyright 2017-2025 Evergrande Group.
 */
package com.eg.egsc.scp.parkinglotcomponent.service.image.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eg.egsc.common.component.fastdfs.service.FastdfsService;
import com.eg.egsc.scp.parkinglotcomponent.service.image.ImageService;

/**
 * @Class Name ImageService
 * @Author zhangli
 * @Create In 2017年12月20日
 */
@Service
public class ImageServiceImpl implements ImageService {
    
    @Autowired
    private FastdfsService fastdfsServiceImpl;

    @Override
    public byte[] getImageData(String imageId) {
        return fastdfsServiceImpl.downloadFile(imageId);
    }

    @Override
    public int deleteFile(String id) {
        return fastdfsServiceImpl.deleteFile(id);
    }

}
