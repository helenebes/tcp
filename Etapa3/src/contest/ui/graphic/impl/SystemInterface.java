package contest.ui.graphic.impl;


import contest.domain.Credentials;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class SystemInterface {

	private Credentials credentials;
	protected Map<String, UIAction> actions;
	
	public SystemInterface() {
		this.actions = new LinkedHashMap<>();
	}
	
	public void addAction(String code, UIAction action) {
		this.actions.put(code, action);
	}
	
	// login (Credential credential) what is credential !!!????
	public void login(Credentials credentials) {
		this.credentials = credentials;
		if (isLoggedIn()) {
			toggleActions();
		}
	}
	
	public void logout() {
		this.credentials = null;
		toggleActions();
	}
	
	public void toggleActions() {
		for (UIAction action : actions.values()) {
			action.setEnabled(!action.isEnabled());
		}
	}
	
	public abstract void createAndShowUI();
	
	public boolean isLoggedIn() {
		return this.credentials != null;
	}
}
