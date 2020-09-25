package me.yeoseon.hateoastest;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HateoasController {

    @GetMapping("/hateoas")
    public Resource<Hello> hello() {
        Hello hello = new Hello();
        hello.setPrefix("Hey, ");
        hello.setName("Yeoseon");

        // Hateoas를 위한 Link 정보 추가
        Resource<Hello> helloResource = new Resource<>(hello);      // HATEOAS 의 Resource : 추가로 제공되는 Link 정보
        helloResource.add(linkTo(methodOn(HateoasController.class).hello()).withSelfRel());

        return helloResource;
    }
}
