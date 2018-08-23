package io.javabrains.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String>{
}
