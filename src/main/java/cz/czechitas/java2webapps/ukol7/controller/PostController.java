package cz.czechitas.java2webapps.ukol7.controller;


import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping()
    public ModelAndView seznam() {
        return new ModelAndView("seznam")
                .addObject("seznam", postService.list());
    }

    @GetMapping("/{slug}")
    public Object detail(@PathVariable String slug) {
        return new ModelAndView("detail")
                .addObject("detail", postService.singlePost(slug));
    }

    @GetMapping("/nova")
    public ModelAndView nova() {
        return new ModelAndView("formular")
                .addObject("post", new Post());
    }

    @PostMapping("/nova")
    public String pridat(@ModelAttribute("post") @Valid Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        postService.save(postService);
        return "redirect:/";
    }
}
