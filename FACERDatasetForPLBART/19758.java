	/**
	 * Returns the value for {@code key} if it exists in the cache or can be
	 * created by {@code #create}. If a value was returned, it is moved to the
	 * head of the queue. This returns null if a value is not cached and cannot
	 * be created.
	 */
	public final V get(Context context, K key) {
		if (key == null) {
			//throw new NullPointerException("key == null");
			return null;
		}

		WeakReference<V> mapValue;
		V mapReferent = null;
		synchronized (this) {
			mapValue = map.get(key);
			if (mapValue != null) {
				mapReferent = mapValue.get();
			}
			if (mapReferent != null) {
				hitCount++;
				return mapReferent;
			}
			if (mapValue != null) {
				size -= safeSizeOf(key, null);
			}
			map.remove(key);
			missCount++;
		}

		/*
		 * Attempt to create a value. This may take a long time, and the map may
		 * be different when create() returns. If a conflicting value was added
		 * to the map while create() was working, we leave that value in the map
		 * and release the created value.
		 */

		V createdReferent = create(context, key);
		if (createdReferent == null) {
			return null;
		}

		synchronized (this) {
			createCount++;
			mapValue = map.put(key, new WeakReference<V>(createdReferent));
			mapReferent = mapValue.get();

			if (mapValue != null && mapReferent != null) {
				// There was a conflict so undo that last put
				map.put(key, mapValue);
			} else {
				size += safeSizeOf(key, createdReferent);
			}
		}

		if (mapValue != null && mapReferent != null) {
			entryRemoved(false, key, createdReferent, mapReferent);
			return mapReferent;
		} else {
			trimToSize(maxSize);
			return createdReferent;
		}
	}

