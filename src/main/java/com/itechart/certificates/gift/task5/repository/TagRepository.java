package com.itechart.certificates.gift.task5.repository;

import com.itechart.certificates.gift.task5.repository.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
