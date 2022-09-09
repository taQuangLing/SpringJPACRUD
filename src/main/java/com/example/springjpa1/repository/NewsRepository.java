package com.example.springjpa1.repository;

import com.example.springjpa1.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewEntity, Integer> {
    @Query(nativeQuery = true, value = "select * from news where title LIKE %:title%")
    public List<NewEntity> findByTitle(String title);
}
