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

    public void save(CommentEntity commentEntity) {
        String username = commentEntity.getUsername();

        if (username.isEmpty() || username.isBlank() || username.equals(null)) {
            log.info("username을 입력하지 않아 랜덤 유저네임 생성하겠습니다.");
            int random = (int) ((Math.random() * (5 - 1)) + 1);

            switch (random) {
                case 1:
                    username = "지훈이가 윙깅인걸 인정해";
                    break;
                case 2:
                    username = "아이패드 자동완성이 신기한 도연이 귀여워";
                    break;
                case 3:
                    username = "도연아 사랑해 우리같은 친구가 어딨어";
                    break;
                case 4:
                    username = "도연아 졸업축하해";
                    break;
                case 5:
                    username = "영케이 잘생겼다";
                    break;
                default:
                    username = "이도연 귀여워서 지구 뿌쎠!";

            }
            commentEntity.setUsername(username);
        }
        commentRepository.save(commentEntity);
        log.info("DB 저장 성공!");
    }
    public void deleteByIdx(int idx){
        commentRepository.deleteById(idx);
    }

    public List<CommentEntity> getCommentList(){
        return commentRepository.findAllByOrderByIdxDesc();
    }
}
