	/**
	 * Clear the cache, calling {@link #entryRemoved} on each removed entry.
	 */
	public final void evictAll() {
		trimToSize(-1); // -1 will evict 0-sized elements
	}

