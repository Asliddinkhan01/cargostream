package uz.cargostream.entity.photo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final String PATH = "src/main/resources/photo";

    public Photo savePhoto(MultipartFile file) {
        Photo photo = new Photo();
        String[] split = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
        String name = UUID.randomUUID() + "." + split[split.length - 1];
        photo.setOriginalName(name);
        photo.setUrlName("/img/" + name);
        Path path = Paths.get(PATH + name);
        try {
            Files.copy(file.getInputStream(), path);
            return photoRepository.save(photo);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deletePhoto(UUID photoId) {
        Optional<Photo> optionalPhoto = photoRepository.findById(photoId);

        if (optionalPhoto.isPresent()) {
            Photo photo = optionalPhoto.get();
            photoRepository.deleteById(photoId);
            Path path = Paths.get(PATH + photo.getOriginalName());
            try {
                Files.deleteIfExists(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
