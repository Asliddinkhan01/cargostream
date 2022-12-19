package uz.cargostream.entity.news;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.common.ApiResponse;
import uz.cargostream.entity.news.dto.NewsDto;
import uz.cargostream.entity.news.dto.NewsEditDto;
import uz.cargostream.entity.news.projection.NewsProjectionGetAll;
import uz.cargostream.entity.news.projection.NewsProjectionGetById;
import uz.cargostream.entity.photo.PhotoRepository;
import uz.cargostream.entity.photo.PhotoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository newsRepository;
    private final PhotoService photoService;


    public HttpEntity<?> addNews(NewsDto newsDto, MultipartFile photo) {
        News news = new News();
        news.setText_ru(newsDto.getText_ru());
        news.setTitle_ru(newsDto.getTitle_ru());
        news.setText_en(newsDto.getText_en());
        news.setTitle_en(newsDto.getTitle_en());
        news.setPhoto(photoService.savePhoto(photo));
        try {
            newsRepository.save(news);
            return new ResponseEntity<>(new ApiResponse("Successfully added", true), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.CONFLICT);
        }
    }

    public HttpEntity<?> getNewsById(UUID uuid) {
        Optional<NewsProjectionGetById> byId = newsRepository.getNewsById(uuid);
        if (byId.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("News not found", false), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ApiResponse("Success", true, byId), HttpStatus.OK);
    }

    public HttpEntity<?> getAllNews() {
        List<NewsProjectionGetAll> allNews = newsRepository.getAllNews();
        if (allNews.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("News not found", false), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ApiResponse("Success", true, allNews), HttpStatus.OK);
    }


    public HttpEntity<?> deleteNews(UUID uuid) {
        Optional<News> byId = newsRepository.findById(uuid);
        if (byId.isPresent()) {
            photoService.deletePhoto(byId.get().getPhoto().getId());
            newsRepository.deleteById(uuid);
            return new ResponseEntity<>(new ApiResponse("Successfully deleted", true), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.NOT_FOUND);
    }

    public HttpEntity<?> editNews(NewsEditDto newsEditDto, MultipartFile photo) {
        Optional<News> byId = newsRepository.findById(newsEditDto.getNewsId());
        if (byId.isEmpty())
            return new ResponseEntity<>(new ApiResponse("Not found", false), HttpStatus.NOT_FOUND);
        News news = byId.get();
        news.setTitle_ru(newsEditDto.getTitle_ru());
        news.setText_ru(newsEditDto.getText_ru());

        news.setTitle_en(newsEditDto.getTitle_en());
        news.setText_en(newsEditDto.getText_en());
        photoService.deletePhoto(news.getPhoto().getId());
        news.setPhoto(photoService.savePhoto(photo));
        try {
            newsRepository.save(news);
            return new ResponseEntity<>(new ApiResponse("Success", true), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse("Something went wrong", false), HttpStatus.CONFLICT);
        }
    }

}
