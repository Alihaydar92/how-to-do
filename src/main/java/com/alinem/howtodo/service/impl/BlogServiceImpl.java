package com.alinem.howtodo.service.impl;

import com.alinem.howtodo.dto.requestDto.BlogRequestDto;
import com.alinem.howtodo.dto.responseDto.BlogResponseDto;
import com.alinem.howtodo.dto.responseDto.BlogTopicResponseDto;
import com.alinem.howtodo.entity.Blog;
import com.alinem.howtodo.entity.Topic;
import com.alinem.howtodo.repository.BlogRepository;
import com.alinem.howtodo.service.BlogService;
import com.alinem.howtodo.service.TopicService;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
    private  final BlogRepository blogRepository;
    private final TopicService topicService;

    private final ModelMapper modelMapper;

    @Override
    public BlogResponseDto addBlog(BlogRequestDto requestDto) {
        Blog blog= new Blog();
        if (requestDto.getTopicId()==null){
            throw  new IllegalArgumentException("blog at least one topic");
        }
        Topic topic= topicService.getTopicSelf(requestDto.getTopicId());
        blog.setTopic(topic);
        blog.setName(requestDto.getName());
        blog.setStatus(requestDto.isStatus());
        blog.setText(requestDto.getText());

        return modelMapper.map(blogRepository.save(blog), BlogResponseDto.class );

    }




    @Override
    public List<BlogResponseDto> getBlogs() {

        List<BlogResponseDto> list = new ArrayList<>();

       blogRepository.findAll().stream().forEach(obj->{
          list.add(modelMapper.map(obj,BlogResponseDto.class));
      });
        return list;


    }


    @Override
    public BlogResponseDto getBlog(Long id) {
        Blog blog= getBlogSelf(id);
        return modelMapper.map(blog,BlogResponseDto.class);
    }

    @Override
    public Blog getBlogSelf(Long id) {
        return blogRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("cannot find blog with id:" +id));
    }


    @Override
    public BlogResponseDto updateBlog(Long id, BlogRequestDto requestDto) {
        Blog blog= getBlogSelf(id);
        if(requestDto.getTopicId()!=null){
            Topic topic=topicService.getTopicSelf(requestDto.getTopicId());
            blog.setTopic(topic);
        }
        blog.setName(requestDto.getName());
        blog.setStatus(requestDto.isStatus());
        blog.setText(requestDto.getText());
        blogRepository.save(blog);
        return modelMapper.map(blog,BlogResponseDto.class);
    }

    @Override
    public Boolean deleteBlog(Long id) {
        Optional<Blog> blog=blogRepository.findById(id);

        if(blog.isPresent()){
            blogRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<BlogTopicResponseDto> getBlogsByTopicId(Long topicId) {
        List<BlogTopicResponseDto> list = new ArrayList<>();
        System.out.println(topicId);

        blogRepository.findAllByTopicId(topicId).stream().forEach(obj->{
            list.add(modelMapper.map(obj,BlogTopicResponseDto.class));
        });
        System.out.println(list.get(1));
        return list;

    }
}
