	/**
	 * Returns the child element with the given name or <code>null</code> if it doesn't exist.
	 *
	 * @param name The child's name
	 * @return the child element or <code>null</code>
	 */
	public DomElement getChild(String name) {
		NodeList list = e.getElementsByTagName(name);
		if (list.getLength() == 0)
			return null;
		for (int i = 0, j = list.getLength(); i < j; i++) {
			Node item = list.item(i);
			if (item.getParentNode() == e)
				return new DomElement((Element) item);
		}
		return null;
	}

