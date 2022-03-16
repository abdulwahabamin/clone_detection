  @Override void cancel() {
    super.cancel();
    if (callback != null) {
      callback = null;
    }
  }

