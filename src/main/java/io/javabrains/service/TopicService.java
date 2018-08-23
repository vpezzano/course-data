
package io.javabrains.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.model.Topic;
import io.javabrains.repository.TopicRepository;

@Service
public class TopicService {
	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		final Iterable<Topic> itTopics = topicRepository.findAll();
		final List<Topic> topics = new ArrayList<>();
		itTopics.forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		return topicRepository.findById(id).orElse(null);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic) {
		addTopic(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
