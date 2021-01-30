package com.dy.present.present.service;

import com.dy.present.present.Entity.CommentEntity;
import com.dy.present.present.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;

    public void save(CommentEntity commentEntity){
        commentRepository.save(commentEntity);
        log.info("DB 저장 성공!");
    }

    public void deleteByIdx(int idx){
        commentRepository.deleteById(idx);
    }

    public List<CommentEntity> getCommentList(){
        return commentRepository.findAll();
    }
}
