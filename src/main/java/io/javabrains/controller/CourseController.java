package io.javabrains.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.model.Course;
import io.javabrains.model.Topic;
import io.javabrains.service.CourseService;
import io.javabrains.service.TopicService;

@RestController
@RequestMapping("/courseapiapp")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {
		return courseService.getAllCoursesByTopicId(topicId);
	}

	@RequestMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		// When I add a course to a topic, the topic should already exist
		Topic topic = topicService.getTopic(topicId);
		if (topic != null) {
			course.setTopic(topic);
			courseService.addCourse(course);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		Topic topic = topicService.getTopic(topicId);
		if (topic != null) {
			course.setTopic(topic);
			courseService.updateCourse(course);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId) {
		courseService.deleteCourse(courseId);
	}
}
