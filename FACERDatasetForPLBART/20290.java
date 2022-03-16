  public void interruptDispatching() {

    dispatchingQueue.interruptDispatching();
    if (service instanceof PicassoExecutorService) {
      ((PicassoExecutorService) service).pause();
    }
  }

