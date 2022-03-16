	/**
	 * Returns the size of the entry for {@code key} and {@code value} in
	 * user-defined units. The default implementation returns 1 so that size is
	 * the number of entries and max size is the maximum number of entries.
	 * 
	 * <p>
	 * An entry's size must not change while it is in the cache.
	 */
	private final int sizeOf(K key, V value) {
		return 1;
	}

