  Stats(Cache cache) {
    this.cache = cache;
    this.statsThread = new HandlerThread(STATS_THREAD_NAME, THREAD_PRIORITY_BACKGROUND);
    this.statsThread.start();
    this.handler = new StatsHandler(statsThread.getLooper(), this);
  }

