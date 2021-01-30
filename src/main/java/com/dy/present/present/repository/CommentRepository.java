package com.dy.present.present.repository;

import com.dy.present.present.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<CommentEntity,Integer> {
    public List<CommentEntity> findAll();
}
