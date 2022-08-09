package kr.co.sanghun.assetmanagement.api.controller;

import kr.co.sanghun.assetmanagement.api.domain.Post;
import kr.co.sanghun.assetmanagement.api.request.PostCreate;
import kr.co.sanghun.assetmanagement.api.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate params) {
        postService.write(params);
        return Map.of();
    }

    @GetMapping("/posts/{postId}")
    public Post get(@PathVariable(name = "postId") Long id) {
        Post post = postService.get(id);
        return post;
    }

    @GetMapping("/posts")
    public List<Post> getList() {
        List<Post> postList = postService.getList();
        return postList;
    }

}
