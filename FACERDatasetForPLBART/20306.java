  public void dispatchFailed(BitmapHunter hunter) {

    if (isDispatchingEnabled()) {
      // dispatch directly; avoid object creation overhead
      handler.sendMessage(handler.obtainMessage(Dispatcher.HUNTER_DECODE_FAILED, hunter));
    } else {
      // dispatching is disabled temporally
      FailedDispatchJob job = new FailedDispatchJob(handler, hunter);
      scheduleJob(job);
    }
  }

