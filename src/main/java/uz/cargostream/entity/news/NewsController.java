package uz.cargostream.entity.news;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.entity.news.dto.NewsDto;
import uz.cargostream.entity.news.dto.NewsUuidDto;

import java.util.UUID;

@RestController
@RequestMapping("${app.domain}/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @PostMapping
    public HttpEntity<?> addNews(
            @RequestPart("newsDto") NewsDto newsDto,
            @RequestPart("photo") MultipartFile photo
    ) {
        return newsService.addNews(newsDto, photo);
    }

    @GetMapping
    public HttpEntity<?> getNews(@RequestBody NewsUuidDto newsUuidDto) {
        return newsService.getNews(newsUuidDto.getNewsId());
    }

    @DeleteMapping
    public HttpEntity<?> deleteNews(@RequestBody NewsUuidDto newsUuidDto) {
        return newsService.deleteNews(newsUuidDto.getNewsId());
    }


}
