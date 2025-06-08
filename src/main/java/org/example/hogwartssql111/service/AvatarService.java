package org.example.hogwartssql111.service;

import org.example.hogwartssql111.model.Avatar;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

public interface AvatarService {

            void uploadAvatar(Long studentId, MultipartFile file) throws IOException;
            
            Avatar getAvatarFromDb(Long studentId);

    byte[] getAvatarFromLocal(Long studentId);


    Collection<Avatar> getAll(Integer pageNumber, Integer pageSize);
}
