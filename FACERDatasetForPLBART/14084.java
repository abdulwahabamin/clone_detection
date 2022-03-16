	/**
	 * Returns all children of this element with the given tag name.
	 *
	 * @param name The children's tag name
	 * @return all matching children
	 */
	public List<DomElement> getChildren(String name) {
		List<DomElement> l = new ArrayList<DomElement>();
		NodeList list = e.getElementsByTagName(name);
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			if (node.getParentNode() == e)
				l.add(new DomElement((Element) node));
		}
		return l;
	}

