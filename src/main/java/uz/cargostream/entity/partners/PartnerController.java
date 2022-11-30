package uz.cargostream.entity.partners;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${app.domain}/partner")
@RequiredArgsConstructor
public class PartnerController {

    private final PartnerService perterService;
}
