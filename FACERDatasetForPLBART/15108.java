	public static <T> PaginatedResult<T> buildPaginatedResult(Result result, ItemFactory<T> factory) {
		if (!result.isSuccessful()) {
			return new PaginatedResult<T>(0, 0, Collections.<T>emptyList());
		}

		DomElement contentElement = result.getContentElement();
		return buildPaginatedResult(contentElement, contentElement, factory);
	}

