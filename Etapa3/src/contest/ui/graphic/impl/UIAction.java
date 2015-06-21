package contest.ui.graphic.impl;

public interface UIAction {

	public void execute();
	
	public boolean isEnabled();
	
	public void setEnabled(boolean status);
}
