package com.dy.present.present.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class    CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;
    private String username;
    private String comment;
    private String created_at;


    @Builder
    public CommentEntity(String username, String comment)
    {
        if(username.isEmpty() || username.isBlank() || username.equals(null)){
            log.info("username을 입력하지 않아 랜덤 유저네임 생성하겠습니다.");
            int random = (int) ((Math.random() * (5 - 1)) + 1);

            switch (random) {
                case 1 :
                    this.username = "지훈이가 윙깅인걸 인정해";
                    break;
                case 2 :
                    this.username = "아이패드 자동완성이 신기한 도연이 귀여워";
                    break;
                case 3 :
                    this.username = "도연아 사랑해 우리같은 친구가 어딨어";
                    break;
                case 4 :
                    this.username = "도연아 졸업축하해";
                    break;
                case 5 :
                    this.username = "영케이 잘생겼다";
                    break;
                default:
                    this.username = "이도연 귀여워서 지구 뿌쎠!";
           }

        }
        this.comment = comment;
    }
}


