	/**
	 * Returns the text content of a child node with the given name. If no such child exists or the child
	 * does not have text content, <code>null</code> is returned.
	 *
	 * @param name The child's name
	 * @return the child's text content or <code>null</code>
	 */
	public String getChildText(String name) {
		DomElement child = getChild(name);
		return child != null ? child.getText() : null;
	}

