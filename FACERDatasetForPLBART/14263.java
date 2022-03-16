	/**
	 * Strips all characters from a String, that might be invalid to be used in file names.
	 * By default <tt>: / \ < > | ? " *</tt> are all replaced by <tt>-</tt>.
	 * Note that this is no guarantee that the returned name will be definately valid.
	 *
	 * @param s the String to clean up
	 * @return the cleaned up String
	 */
	public static String cleanUp(String s) {
		return s.replaceAll("[*:/\\\\?|<>\"]", "-");
	}

