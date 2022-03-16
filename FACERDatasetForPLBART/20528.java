  StatsSnapshot createSnapshot() {
    return new StatsSnapshot(cache.maxSize(), cache.size(), cacheHits, cacheMisses,
        totalDownloadSize, totalOriginalBitmapSize, totalTransformedBitmapSize, averageDownloadSize,
        averageOriginalBitmapSize, averageTransformedBitmapSize, downloadCount, originalBitmapCount,
        transformedBitmapCount, System.currentTimeMillis());
  }

