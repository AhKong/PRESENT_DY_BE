package com.dy.present.present.controller;

import com.dy.present.present.Entity.CommentEntity;
import com.dy.present.present.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@AllArgsConstructor
public class MainController {
    @Autowired
    private final CommentService commentService;

    @GetMapping("/comment-list")
    public ResponseEntity<List<CommentEntity>> getCommentList(){
        log.info("댓글 리스트 조회 api 호출");
        List<CommentEntity> result = commentService.getCommentList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity<Void> addComment(@RequestBody CommentEntity commentEntity){
        log.info("댓글 등록할 내용 : {}",commentEntity.toString());
        commentService.save(commentEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/comment/idx")
    public ResponseEntity<Void> deleteComment(@PathVariable (name = "idx") int idx){
        log.info("삭제 할 idx : {} ",idx);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
