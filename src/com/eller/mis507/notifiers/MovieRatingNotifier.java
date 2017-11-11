package com.eller.mis507.notifiers;

import com.eller.mis507.entities.User;

public interface MovieRatingNotifier {	
	// subject
	
	// methods to register and unregister observers
	public void register(User obj);
	public void unregister(User obj);

	// method to notify observers of change
	public void notifyObservers();

	// method to get updates from subject
	public Object getUpdate(User obj);

}
