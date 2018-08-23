
package io.javabrains.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.model.Course;
import io.javabrains.model.Topic;
import io.javabrains.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getAllCoursesByTopicId(String topicId) {
		return courseRepository.findByTopicId(topicId);
	}

	public List<Course> getAllCoursesByTopic(Topic topic) {
		return courseRepository.findByTopic(topic);
	}

	public Course getCourse(String id) {
		return courseRepository.findById(id).orElse(null);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
