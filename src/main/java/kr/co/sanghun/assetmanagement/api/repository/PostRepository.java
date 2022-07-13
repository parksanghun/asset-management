package kr.co.sanghun.assetmanagement.api.repository;

import kr.co.sanghun.assetmanagement.api.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
