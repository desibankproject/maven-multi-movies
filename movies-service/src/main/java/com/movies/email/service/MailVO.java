package com.movies.email.service;

public class MailVO {
	private String content;
	private String subject;
	private String to;
	private String from;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	@Override
	public String toString() {
		return "MailVO [content=" + content + ", subject=" + subject + ", to=" + to + ", from=" + from + "]";
	}
	
	
}
