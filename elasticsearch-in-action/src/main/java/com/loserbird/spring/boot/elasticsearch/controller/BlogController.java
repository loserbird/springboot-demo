package com.loserbird.spring.boot.elasticsearch.controller;

import com.loserbird.spring.boot.elasticsearch.domain.Blog;
import com.loserbird.spring.boot.elasticsearch.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Blog 控制器
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
    private BlogRepository blogRepository;
	
	@GetMapping
	public List<Blog> list(@RequestParam(value="title",required=false,defaultValue="") String title,
                           @RequestParam(value="content",required=false,defaultValue="") String content,
                           @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                           @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize) {
			
		// 数据在 Test 里面先初始化了，这里只管取数据
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		Page<Blog> page = blogRepository.findByTitleLikeOrContentLike(title, content, pageable);
		
		return page.getContent();
	}
 
}