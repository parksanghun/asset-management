package kr.co.sanghun.assetmanagement.api.service;

import kr.co.sanghun.assetmanagement.api.domain.Post;
import kr.co.sanghun.assetmanagement.api.repository.PostRepository;
import kr.co.sanghun.assetmanagement.api.request.PostCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void write(PostCreate postCreate) {

        Post post = new Post(postCreate.getTitle(), postCreate.getContent());

        postRepository.save(post);
    }

    public Post get(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다."));
        return post;
    }

    public List<Post> getList() {
        return postRepository.findAll();
    }
}
