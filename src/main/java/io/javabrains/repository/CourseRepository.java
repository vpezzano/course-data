package io.javabrains.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.javabrains.model.Course;
import io.javabrains.model.Topic;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
	/*
	 * Both will work, the first one first identifies the topic object, 
	 * and then the id field of that object, in order to compare to the
	 * argument.
	 */
	List<Course> findByTopicId(String topicId);
	List<Course> findByTopic(Topic topic);
}