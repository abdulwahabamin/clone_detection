  void enqueueAndSubmit(Action action) {
    Object target = action.getTarget();
    if (target != null) {
      // This will also check we are on the main thread.
      cancelExistingRequest(target);
      targetToAction.put(target, action);
    }
    submit(action);
  }

