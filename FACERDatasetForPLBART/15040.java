	/**
	 * Checks if this element has a child element with the given name.
	 *
	 * @param name The child's name
	 * @return <code>true</code> if this element has a child element with the given name
	 */
	public boolean hasChild(String name) {
		NodeList list = e.getElementsByTagName(name);
		for (int i = 0, j = list.getLength(); i < j; i++) {
			Node item = list.item(i);
			if (item.getParentNode() == e)
				return true;
		}
		return false;
	}

