package uz.cargostream.entity.news;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.entity.news.dto.NewsDto;
import uz.cargostream.entity.news.dto.NewsEditDto;
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
    public HttpEntity<?> getNewsById(@RequestBody NewsUuidDto newsUuidDto) {
        return newsService.getNewsById(newsUuidDto.getNewsId());
    }

    @DeleteMapping
    public HttpEntity<?> deleteNews(@RequestBody NewsUuidDto newsUuidDto) {
        return newsService.deleteNews(newsUuidDto.getNewsId());
    }

    @GetMapping("/getAll")
    public HttpEntity<?> getAllNews() {
        return newsService.getAllNews();
    }

    @PutMapping
    public HttpEntity<?> editNews(@RequestPart("newsDto") NewsEditDto newsDto,
                                  @RequestPart("photo") MultipartFile photo) {
        return newsService.editNews(newsDto, photo);
    }


}
