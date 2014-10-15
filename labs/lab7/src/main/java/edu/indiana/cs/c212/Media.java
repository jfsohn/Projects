package edu.indiana.cs.c212;

public abstract class Media implements MediaItem{
	protected String title;
	protected int lengthInSeconds;
	protected int copyrightYear;
	
	/* (non-Javadoc)
	 * @see edu.indiana.cs.c212.MediaItem#getTitle()
	 */
	public String getTitle() {
		return this.title;
	}
	
	/* (non-Javadoc)
	 * @see edu.indiana.cs.c212.MediaItem#getCopyrightYear()
	 */
	public int getCopyrightYear() {
		return this.copyrightYear;
	}

	/* (non-Javadoc)
	 * @see edu.indiana.cs.c212.MediaItem#getLengthInSeconds()
	 */
	public int getLengthInSeconds() {
		return this.lengthInSeconds;
	}
	
	/* (non-Javadoc)
	 * @see edu.indiana.cs.c212.MediaItem#getLengthInMinutes()
	 */
	public double getLengthInMinutes() {
		return this.getLengthInSeconds()/60.0;
	}
	
	/* (non-Javadoc)
	 * @see edu.indiana.cs.c212.MediaItem#getLengthInHours()
	 */
	public double getLengthInHours(){
		return this.getLengthInMinutes()/60;
	}
}
