  public DispatchingQueue(Handler handler) {
    this.handler = handler;
    this.jobQueue = new ConcurrentLinkedQueue<DispatchJob>();
    this.hunterMap = new ConcurrentHashMap<BitmapHunter, DispatchJob>();
    this.dispatching = true;
  }

