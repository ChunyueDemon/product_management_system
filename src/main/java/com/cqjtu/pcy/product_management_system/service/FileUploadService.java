package com.cqjtu.pcy.product_management_system.service;

import com.cqjtu.pcy.product_management_system.common.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    Result uploadFile(MultipartFile file,String filePath,String serverFilePath,String description);
}
