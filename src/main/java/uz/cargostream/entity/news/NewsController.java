package uz.cargostream.entity.news;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import uz.cargostream.entity.news.dto.NewsDto;

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

}
