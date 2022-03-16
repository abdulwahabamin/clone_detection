	/**
	 * URL Encodes the given String <code>s</code> using the UTF-8 character encoding.
	 *
	 * @param s a String
	 * @return url encoded string
	 */
	public static String encode(String s) {
		if(s == null)
			return null;
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// utf-8 always available
		}
		return null;
	}

