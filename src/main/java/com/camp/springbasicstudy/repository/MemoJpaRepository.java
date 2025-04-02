package com.camp.springbasicstudy.repository;

import com.camp.springbasicstudy.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoJpaRepository extends JpaRepository<Memo, Long> {
}
