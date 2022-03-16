	/**
	 * Removes the entry for {@code key} if it exists.
	 * 
	 * @return the previous value mapped by {@code key}.
	 */
	public final V remove(K key) {
		if (key == null) {
			throw new NullPointerException("key == null");
		}

		WeakReference<V> previousValue;
		V previousReferent = null;
		synchronized (this) {
			previousValue = map.remove(key);
			if (previousValue != null) {
				previousReferent = previousValue.get();
				size -= safeSizeOf(key, previousReferent);
			}
		}

		if (previousValue != null) {
			entryRemoved(false, key, previousReferent, null);
		}

		return previousReferent;
	}

