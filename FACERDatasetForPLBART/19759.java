	/**
	 * Caches {@code value} for {@code key}. The value is moved to the head of
	 * the queue.
	 * 
	 * @return the previous value mapped by {@code key}.
	 */
	public final V put(K key, V referent) {
		if (key == null || referent == null) {
			throw new NullPointerException("key == null || value == null");
		}
		WeakReference<V> value = new WeakReference<V>(referent);

		WeakReference<V> previousValue;
		V previousReferent = null;
		synchronized (this) {
			putCount++;
			size += safeSizeOf(key, referent);
			previousValue = map.put(key, value);
			if (previousValue != null) {
				previousReferent = previousValue.get();
				size -= safeSizeOf(key, previousReferent);
			}
		}

		if (previousValue != null) {
			entryRemoved(false, key, previousReferent, referent);
		}

		trimToSize(maxSize);

		return previousReferent;
	}

