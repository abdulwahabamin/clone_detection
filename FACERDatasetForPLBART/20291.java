  public void continueDispatching() {

    dispatchingQueue.continueDispatching();
    if (service instanceof PicassoExecutorService) {
      ((PicassoExecutorService) service).resume();
    }
  }

