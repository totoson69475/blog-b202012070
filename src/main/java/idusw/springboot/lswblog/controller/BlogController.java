package idusw.springboot.lswblog.controller;

import idusw.springboot.lswblog.model.BlogDto;
import idusw.springboot.lswblog.serivce.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("blogs/")
public class BlogController {
    final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/delete/{idx}")
    public String deleteBlog(@PathVariable Long idx, Model model) {
        // controller가 service에게 요청
        BlogDto dto = BlogDto.builder()
                .idx(idx)
                .build();
        blogService.delete(dto); // repository에게 요청하는 코드가 있을 것임
        // controller가 view에게 처리결과를 전달
        model.addAttribute("attr-name", "attr-value"); // delete 크게 필요없음
        return "redirect:/";
    }
}
