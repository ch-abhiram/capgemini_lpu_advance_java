package com.url.Url_task.repository;




import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.url.Url_task.Entity.UrlMapping;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {

    Optional<UrlMapping> findByShortCode(String shortCode);

    boolean existsByShortCode(String shortCode);

    List<UrlMapping> findByCreatedAtAfter(LocalDateTime date);

    @Query("SELECT u FROM UrlMapping u ORDER BY u.clickCount DESC")
    List<UrlMapping> findTop5ByClickCountDesc(Pageable pageable);
}