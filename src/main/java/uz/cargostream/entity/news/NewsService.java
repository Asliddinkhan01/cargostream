package uz.cargostream.entity.news;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.news.dto.NewsDto;
import uz.cargostream.entity.photo.PhotoService;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final PhotoService photoService;

    public HttpEntity<?> addNews(NewsDto newsDto, MultipartFile photo) {
        News news = new News();
        news.setText(newsDto.getText());
        news.setTitle(newsDto.getTitle());

        news.setPhoto(photoService.savePhoto(photo));
        newsRepository.save(news);

        return new ResponseEntity<>(new ApiResponse("Successfully added", true), HttpStatus.CREATED);
    }
}
