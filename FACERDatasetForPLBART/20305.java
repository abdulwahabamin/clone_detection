  public void dispatchComplete(BitmapHunter hunter) {

    if (isDispatchingEnabled()) {
      // dispatch directly; avoid object creation overhead
      handler.sendMessage(handler.obtainMessage(Dispatcher.HUNTER_COMPLETE, hunter));
    } else {
      // dispatching is disabled temporally
      CompleteDispatchJob job = new CompleteDispatchJob(handler, hunter);
      scheduleJob(job);
    }
  }

