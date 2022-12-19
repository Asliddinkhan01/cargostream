package uz.cargostream.entity.news;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.entity.news.dto.NewsDto;
import uz.cargostream.entity.news.dto.NewsEditDto;
import uz.cargostream.entity.news.dto.NewsUuidDto;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("${app.domain}/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @PostMapping
    public HttpEntity<?> addNews(
            @RequestPart("newsDto") @Valid NewsDto newsDto,
            @RequestPart("photo") MultipartFile photo
    ) {
        return newsService.addNews(newsDto, photo);
    }

    @GetMapping("/{newsId}")
    public HttpEntity<?> getNewsById(@PathVariable UUID newsId) {
        return newsService.getNewsById(newsId);
    }

    @DeleteMapping
    public HttpEntity<?> deleteNews( @Valid @RequestBody NewsUuidDto newsUuidDto) {
        return newsService.deleteNews(newsUuidDto.getNewsId());
    }

    @GetMapping("/getAll")
    public HttpEntity<?> getAllNews() {
        return newsService.getAllNews();
    }

    @PutMapping
    public HttpEntity<?> editNews(@RequestPart("newsDto") @Valid NewsEditDto newsDto,
                                  @RequestPart("photo") MultipartFile photo) {
        return newsService.editNews(newsDto, photo);
    }


}
