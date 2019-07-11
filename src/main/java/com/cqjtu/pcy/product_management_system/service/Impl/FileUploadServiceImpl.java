package com.cqjtu.pcy.product_management_system.service.Impl;

import com.cqjtu.pcy.product_management_system.common.Result;
import com.cqjtu.pcy.product_management_system.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public Result uploadFile(MultipartFile file,String filePath,String serverFilePath, String description) {
        String fileName = UUID.randomUUID()+file.getOriginalFilename();
        try {
            file.transferTo(new File(filePath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false,null,e.toString());
        }
        return new Result(true,serverFilePath+fileName,fileName);
    }
}
