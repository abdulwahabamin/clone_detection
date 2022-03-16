	/**
	 * Returns <code>true</code> if this Result contains no elements, which is the case for service calls that would have returned a
	 * <code>PaginatedResult</code> but fail.
	 *
	 * @return <code>true</code> if this result contains no elements
	 */
	public boolean isEmpty() {
		return pageResults == null || pageResults.isEmpty();
	}

