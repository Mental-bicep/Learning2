package com.prac1.entity;

public class SupportTicket {
	String titleString;
	String description;
	String priority;
	public String getTitleString() {
		return titleString;
	}
	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	@Override
	public String toString() {
		return "SupportTicket [titleString=" + titleString + ", description=" + description + ", priority=" + priority
				+ "]";
	}
	
	
}
