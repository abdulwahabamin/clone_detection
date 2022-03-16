  void shutdown() {
    service.shutdown();
    dispatcherThread.quit();
    receiver.unregister();
    dispatchingQueue.clear();
  }

