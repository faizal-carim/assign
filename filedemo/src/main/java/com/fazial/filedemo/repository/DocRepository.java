package com.fazial.filedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fazial.filedemo.model.Doc;

public interface DocRepository extends JpaRepository<Doc, Integer> {

}
