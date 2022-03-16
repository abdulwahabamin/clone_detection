	/**
	 * @param key In this case the file name (used as the mapping id).
	 * @return bitmap The cached bitmap or null if it could not be located.
	 * 
	 * As the name suggests, this method attemps to obtain a bitmap stored
	 * in one of the caches. First it checks the hard cache for the key.
	 * If a key is found, it moves the cached bitmap to the head of the cache
	 * so it gets moved to the soft cache last.
	 * 
	 * If the hard cache doesn't contain the bitmap, it checks the soft cache
	 * for the cached bitmap. If neither of the caches contain the bitmap, this
	 * returns null.
	 */
	private Bitmap getBitmapFromCache(String key){
		synchronized(mHardBitmapCache) {
			Bitmap bitmap = mHardBitmapCache.get(key);
			if(bitmap != null){
				// Put bitmap on top of cache so it's purged last.
				mHardBitmapCache.remove(key);
				mHardBitmapCache.put(key, bitmap);
				return bitmap;
			}
		}
		
		SoftReference<Bitmap> bitmapRef = mSoftBitmapCache.get(key);
		if(bitmapRef != null){
			Bitmap bitmap = bitmapRef.get();
			if(bitmap != null){
				return bitmap;
			} else {
				// Must have been collected by the Garbage Collector 
				// so we remove the bucket from the cache.
				mSoftBitmapCache.remove(key);
			}
		}
		
		// Could not locate the bitmap in any of the caches, so we return null.
		return null;
	}

