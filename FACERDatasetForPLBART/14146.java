	public static <T> Collection<T> buildCollection(DomElement element, ItemFactory<T> factory) {
		if (element == null)
			return Collections.emptyList();
		Collection<DomElement> children = element.getChildren();
		Collection<T> items = new ArrayList<T>(children.size());
		for (DomElement child : children) {
			items.add(factory.createItemFromElement(child));
		}
		return items;
	}

