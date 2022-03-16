  public void continueDispatching() {
    if (dispatcher == null) {
      throw new NullPointerException("The dispatcher is null");
    }

    dispatcher.continueDispatching();
  }

