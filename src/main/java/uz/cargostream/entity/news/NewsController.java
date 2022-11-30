package uz.cargostream.entity.news;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.entity.news.dto.NewsDto;

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

    @GetMapping("/{uuid}")
    public HttpEntity<?> getNews(@PathVariable UUID uuid) {
        return newsService.getNews(uuid);
    }

    @DeleteMapping("/{uuid}")
    public HttpEntity<?> deleteNews(@PathVariable UUID uuid) {
        return newsService.deleteNews(uuid);
    }




}
