package com.bike.marathon.result;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bike.marathon.event.Event;
import com.bike.marathon.user.User;

@Entity
@Table(name = "result", schema = "public")
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EventSeqGenerator")
	@SequenceGenerator(name = "EventSeqGenerator", sequenceName = "event_seq", schema = "public")
	private Long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;


	@Column(name = "start_time")
	private Time startTime;

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
