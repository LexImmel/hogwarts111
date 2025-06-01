package org.example.hogwartssql111.service;

import org.example.hogwartssql111.model.Avatar;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AvatarService {

            void uploadAvatar(Long studentId, MultipartFile file) throws IOException;
            
            Avatar getAvatarFromDb(Long studentId);

    byte[] getAvatarFromLocal(Long studentId);
}
