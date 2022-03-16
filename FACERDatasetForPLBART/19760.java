	/**
	 * @param maxSize
	 *            the maximum size of the cache before returning. May be -1 to
	 *            evict even 0-sized elements.
	 */
	private void trimToSize(int maxSize) {
		while (true) {
			K key;
			WeakReference<V> value;
			V referent;
			synchronized (this) {
				if (size < 0 || (map.isEmpty() && size != 0)) {
					size = 0;
					map.clear();
					Log.e(LOG_TAG,
							getClass().getName()
									+ ".sizeOf() is reporting inconsistent results! size: "
									+ size + ", maxSize: " + maxSize);
					break;
				}

				if (size <= maxSize || map.isEmpty()) {
					break;
				}

				Map.Entry<K, WeakReference<V>> toEvict = map.entrySet()
						.iterator().next();
				key = toEvict.getKey();
				value = toEvict.getValue();
				referent = (value != null) ? value.get() : null;
				map.remove(key);
				size -= safeSizeOf(key, referent);
				evictionCount++;
			}

			entryRemoved(true, key, referent, null);
		}
	}

