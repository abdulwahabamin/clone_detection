  public void interruptDispatching() {
    if (dispatcher == null) {
      throw new NullPointerException("The dispatcher is null");
    }

    dispatcher.interruptDispatching();
  }

