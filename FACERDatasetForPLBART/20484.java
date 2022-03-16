  private static int getRequestId() {
    if (isMain()) {
      return nextId++;
    }

    final CountDownLatch latch = new CountDownLatch(1);
    final AtomicInteger id = new AtomicInteger();
    Picasso.HANDLER.post(new Runnable() {
      @Override public void run() {
        id.set(getRequestId());
        latch.countDown();
      }
    });
    try {
      latch.await();
    } catch (final InterruptedException e) {
      Picasso.HANDLER.post(new Runnable() {
        @Override public void run() {
          throw new RuntimeException(e);
        }
      });
    }
    return id.get();
  }

