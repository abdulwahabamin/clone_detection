  public StatsSnapshot(int maxSize, int size, long cacheHits, long cacheMisses,
      long totalDownloadSize, long totalOriginalBitmapSize, long totalTransformedBitmapSize,
      long averageDownloadSize, long averageOriginalBitmapSize, long averageTransformedBitmapSize,
      int downloadCount, int originalBitmapCount, int transformedBitmapCount, long timeStamp) {
    this.maxSize = maxSize;
    this.size = size;
    this.cacheHits = cacheHits;
    this.cacheMisses = cacheMisses;
    this.totalDownloadSize = totalDownloadSize;
    this.totalOriginalBitmapSize = totalOriginalBitmapSize;
    this.totalTransformedBitmapSize = totalTransformedBitmapSize;
    this.averageDownloadSize = averageDownloadSize;
    this.averageOriginalBitmapSize = averageOriginalBitmapSize;
    this.averageTransformedBitmapSize = averageTransformedBitmapSize;
    this.downloadCount = downloadCount;
    this.originalBitmapCount = originalBitmapCount;
    this.transformedBitmapCount = transformedBitmapCount;
    this.timeStamp = timeStamp;
  }

