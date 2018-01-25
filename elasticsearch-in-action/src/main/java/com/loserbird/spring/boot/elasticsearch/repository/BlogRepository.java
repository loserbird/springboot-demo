package com.loserbird.spring.boot.elasticsearch.repository;

import com.loserbird.spring.boot.elasticsearch.domain.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * Blog 存储库.
 */
public interface BlogRepository extends ElasticsearchRepository<Blog, String> {
	/**
	 * 根据用户名分页查询用户列表
	 * @param pageable
	 * @return
	 */
	Page<Blog> findByTitleLikeOrContentLike(String title, String content, Pageable pageable);
}
