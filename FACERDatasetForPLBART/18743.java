	/*************************************************
	 * Loops through the HTTP client's cookie store 
	 * and returns the value of the "xt" cookie.
	 * 
	 * @return Value of the "xt" cookie.
	 *************************************************/
	private static final String getXtCookieValue() {
		
		for(Cookie cookie : mCookieStore.getCookies()) {
			if(cookie.getName().equals("xt"))
				return cookie.getValue();
		}

		return null;
	}

