package cz.czechitas.java2webapps.ukol7.service;


import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
        initDB();
    }

    private void initDB() {
        Post post = new Post();
        post.setId(6l);
        post.setSlug("Horáček");
        post.setAuthor("Marek Horáček");
        post.setBody("<div>bla <b>xxxx</b> test test</div>");
        post.setPerex("úvod bla bla");
        post.setPublished(LocalDate.of(2023,8,1));
        post.setTitle("Testovací zápisník 5");
        postRepository.save(post);
    }

    public List<Post> list(){
        Pageable pageable = PageRequest.of(0, 20);
        Page<Post> pagePost = postRepository.findAllByPublishedNotNullAndPublishedBeforeOrderByPublishedDesc(LocalDate.now(), pageable);
        return pagePost.toList();
        //return postRepository.findAll();

    }
    public Post singlePost(String slug){
        return postRepository.findBySlug(slug);
    }

    public void save(PostService postService) {
    }
}
