  /** Prints out this {@link StatsSnapshot} with the the provided {@link PrintWriter}. */
  public void dump(PrintWriter writer) {
    writer.println("===============BEGIN PICASSO STATS ===============");
    writer.println("Memory Cache Stats");
    writer.print("  Max Cache Size: ");
    writer.println(maxSize);
    writer.print("  Cache Size: ");
    writer.println(size);
    writer.print("  Cache % Full: ");
    writer.println((int) Math.ceil((float) size / maxSize * 100));
    writer.print("  Cache Hits: ");
    writer.println(cacheHits);
    writer.print("  Cache Misses: ");
    writer.println(cacheMisses);
    writer.println("Network Stats");
    writer.print("  Download Count: ");
    writer.println(downloadCount);
    writer.print("  Total Download Size: ");
    writer.println(totalDownloadSize);
    writer.print("  Average Download Size: ");
    writer.println(averageDownloadSize);
    writer.println("Bitmap Stats");
    writer.print("  Total Bitmaps Decoded: ");
    writer.println(originalBitmapCount);
    writer.print("  Total Bitmap Size: ");
    writer.println(totalOriginalBitmapSize);
    writer.print("  Total Transformed Bitmaps: ");
    writer.println(transformedBitmapCount);
    writer.print("  Total Transformed Bitmap Size: ");
    writer.println(totalTransformedBitmapSize);
    writer.print("  Average Bitmap Size: ");
    writer.println(averageOriginalBitmapSize);
    writer.print("  Average Transformed Bitmap Size: ");
    writer.println(averageTransformedBitmapSize);
    writer.println("===============END PICASSO STATS ===============");
    writer.flush();
  }

