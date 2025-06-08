package org.example.hogwartssql111.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.example.hogwartssql111.exception.NotFoundException;
import org.example.hogwartssql111.model.Avatar;
import org.example.hogwartssql111.model.Student;
import org.example.hogwartssql111.repository.AvatarRepository;
import org.example.hogwartssql111.service.AvatarService;
import org.example.hogwartssql111.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

@Service
public class AvatarServiceImpl  implements AvatarService {

    private final AvatarRepository avatarRepository;
    private final StudentService studentService;
    private static final String DIR_PATH = "avatars";

    public AvatarServiceImpl(AvatarRepository avatarRepository, StudentService studentService) {
        this.avatarRepository = avatarRepository;
        this.studentService = studentService;
    }

    @Override
    public void uploadAvatar(Long studentId, MultipartFile file) throws IOException {
        Path path = Path.of(DIR_PATH);
        if (Files.notExists(path)) {
            Files.createDirectories(path);
        }

        Student student = studentService.getStudent(studentId);

        if (student != null && file != null && !file.isEmpty() && file.getOriginalFilename() != null) {
            String fileExtension = getExtension(file.getOriginalFilename());
            if (StringUtils.isNotBlank(fileExtension)) {
                Path filePath = Path.of(DIR_PATH, student.getName() + "_" + student.getId() + "." + fileExtension);
                file.transferTo(filePath);
                Avatar newAvatar = new Avatar();
                newAvatar.setFilePath(filePath.toString());
                newAvatar.setFileSize(file.getSize());
                newAvatar.setMediaType(file.getContentType());
                newAvatar.setData(file.getBytes());
                newAvatar.setStudent(student);
                avatarRepository.save(newAvatar);
            }
        }
    }

    @Override
    public Avatar getAvatarFromDb(Long studentId) {
        Student student = studentService.getStudent(studentId);
        return avatarRepository.findAvatarByStudent(student).orElseThrow(() -> new NotFoundException("Avatar of student" + student.getName() + " does not exist"));
    }

    @Override
    public byte[] getAvatarFromLocal(Long studentId) {
        Student student = studentService.getStudent(studentId);
        Avatar avatar = avatarRepository.findAvatarByStudent(student).orElseThrow(() -> new NotFoundException("Avatar of student" + student.getName() + " does not exist"));
        String filePath = avatar.getFilePath();
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            return bufferedInputStream.readAllBytes();
        } catch (IOException e) {
            throw new IllegalArgumentException(("Avatar getting error"));
        }
    }

    @Override
    public Collection<Avatar> getAll(Integer pageNumber, Integer pageSize) {
        return List.of();
    }

    private String getExtension(String originalPath) {
        if (StringUtils.isNotBlank(originalPath)) {
            return originalPath.substring(originalPath.lastIndexOf(".") + 1);
        } else return null;
    }
}
