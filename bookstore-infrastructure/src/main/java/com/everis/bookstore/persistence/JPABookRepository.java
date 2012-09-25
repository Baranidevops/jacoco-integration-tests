package com.everis.bookstore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPABookRepository extends JpaRepository<JPABook, Long> {

}
