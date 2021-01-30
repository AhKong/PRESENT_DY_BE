package com.dy.present.present;

import com.dy.present.present.Entity.CommentEntity;
import com.dy.present.present.repository.CommentRepository;
import com.dy.present.present.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PresentApplicationTests {
    @Autowired
    CommentService service ;

    @Test
    void contextLoads() {
        for(int i = 0; i<10; i++){

            CommentEntity commentEntity = new CommentEntity("","test");
            service.save(commentEntity);
        }

    }
}
