	public static <T> PaginatedResult<T> buildPaginatedResult(DomElement contentElement, DomElement childElement, ItemFactory<T> factory) {
		Collection<T> items = buildCollection(childElement, factory);

		String totalPagesAttribute = contentElement.getAttribute("totalPages");
		if (totalPagesAttribute == null)
			totalPagesAttribute = contentElement.getAttribute("totalpages");

		int page = Integer.parseInt(contentElement.getAttribute("page"));
		int totalPages = Integer.parseInt(totalPagesAttribute);

		return new PaginatedResult<T>(page, totalPages, items);
	}

