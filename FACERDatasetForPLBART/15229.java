	/**
	 * Decodes an URL encoded String <code>s</code> using the UTF-8 character encoding.
	 *
	 * @param s an encoded String
	 * @return the decoded String
	 */
	public static String decode(String s) {
		if(s == null)
			return null;
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// utf-8 always available
		}
		return null;
	}

