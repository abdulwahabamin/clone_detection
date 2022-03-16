	/**
	 * Returns the attribute value to a given attribute name or <code>null</code> if the attribute doesn't exist.
	 *
	 * @param name The attribute's name
	 * @return Attribute value or <code>null</code>
	 */
	public String getAttribute(String name) {
		return e.hasAttribute(name) ? e.getAttribute(name) : null;
	}

