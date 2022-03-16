	@Override
	public synchronized final String toString() {
		int accesses = hitCount + missCount;
		int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
		return String
				.format("LruCache[size=%d,mapSize=%d,maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
						size, map.size(), maxSize, hitCount, missCount,
						hitPercent);
	}

