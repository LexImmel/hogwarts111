package org.example.hogwartssql111.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.example.hogwartssql111.model.Avatar;
import org.example.hogwartssql111.service.AvatarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/avatars")
public class AvatarController {

    private final AvatarService avatarService;

    @PostMapping(value = "/upload/{studentId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadAvatar(@PathVariable("studentId") Long studentId, @RequestBody MultipartFile file) throws IOException {
        avatarService.uploadAvatar(studentId, file);
    }

    @GetMapping("/from-db")
    public ResponseEntity<byte[]> getAvatarFromDb(@RequestParam("studentId") Long studentId) {
        Avatar avatar = avatarService.getAvatarFromDb(studentId);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.parseMediaType(avatar.getMediaType())).body(avatar.getData());
    }
    @GetMapping(value = "/from-local", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getAvatarFromLocal(@RequestParam("studentId") Long studentId) {
        return avatarService.getAvatarFromLocal(studentId);
    }

    @GetMapping("/avatar-collection")
    @Operation(summary = "get all avatars")
    public ResponseEntity<Collection<Avatar>> getAll(@RequestParam("page") Integer pageNumber,
                                                     @RequestParam("size") Integer pageSize) {
        Collection<Avatar> avatars = avatarService.getAll(pageNumber, pageSize);
        return ResponseEntity.ok(avatars);
    }

}
