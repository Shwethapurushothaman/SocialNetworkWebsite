package com.socialappbackend.dao;

import java.util.List;

import com.socialappbackend.model.forum;

public interface forumdao {
	public boolean addforum(forum f);
	public boolean updateforum(forum f);
	public boolean deleteforum(forum f);
	public forum getforumbyid(int forumId);
	public List<forum> getallforums();
}
