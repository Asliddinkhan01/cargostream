package uz.cargostream.entity.news;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.news.dto.NewsDto;
import uz.cargostream.entity.photo.PhotoRepository;
import uz.cargostream.entity.photo.PhotoService;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final PhotoService photoService;
    private final PhotoRepository photoRepository;

    public HttpEntity<?> addNews(NewsDto newsDto, MultipartFile photo) {
        News news = new News();
        news.setText(newsDto.getText());
        news.setTitle(newsDto.getTitle());

        news.setPhoto(photoService.savePhoto(photo));
        newsRepository.save(news);

        return new ResponseEntity<>(new ApiResponse("Successfully added", true), HttpStatus.CREATED);
    }

    public HttpEntity<?> getNews(UUID uuid) {
        Optional<News> byId = newsRepository.findById(uuid);
        if (byId.isPresent()) {
            return new ResponseEntity<>(new ApiResponse("Successfully", true), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("News not found", false), HttpStatus.OK);
    }


    public HttpEntity<?> deleteNews(UUID uuid) {
        try {
            newsRepository.deleteById(uuid);
            return new ResponseEntity<>(new ApiResponse("Successfully deleted", true), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("News not found", true), HttpStatus.OK);
        }
    }

//    public HttpEntity<?> editNews(UUID uuid, News news,MultipartFile photo){
//        Optional<News> byId = newsRepository.findById(uuid);
//
//        if (byId.isPresent()){
//            News editNews = byId.get();
//            editNews.setText(news.getText());
//            editNews.setTitle(news.getTitle());
//        }
//    }

}
