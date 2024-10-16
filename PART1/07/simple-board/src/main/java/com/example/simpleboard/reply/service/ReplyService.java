package com.example.simpleboard.reply.service;

import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.db.ReplyRepository;
import com.example.simpleboard.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;

    public ReplyEntity create(
        ReplyRequest replyRequest
    ){
        var optionalpostEntity = postRepository.findById(replyRequest.getPostId());

        if(optionalpostEntity.isEmpty()) {
            throw new RuntimeException("게시물이 존재하지 않습니다 : " + replyRequest.getPostId());
        }

        var entity = ReplyEntity.builder()
                .post(optionalpostEntity.get())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .status("REGISTERED")
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .repliedAt(LocalDateTime.now())
                .build()
                ;

        return replyRepository.save(entity);
    }

    public List<ReplyEntity> findAllByPostId(Long postId) {
        return replyRepository.findAllByPostIdAndStatusOrderByPostIdDesc(postId, "REGISTERED");
    }
}
