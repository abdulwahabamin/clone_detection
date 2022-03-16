  void performSubmit(Action action) {
    BitmapHunter hunter = hunterMap.get(action.getKey());
    if (hunter != null) {
      hunter.attach(action);
      return;
    }

    if (service.isShutdown()) {
      if (action.getPicasso().loggingEnabled) {
        log(OWNER_DISPATCHER, VERB_IGNORED, action.request.logId(), "because shut down");
      }
      return;
    }

    hunter = forRequest(context, action.getPicasso(), this, cache, stats, action, downloader);
    hunter.future = service.submit(hunter);
    hunterMap.put(action.getKey(), hunter);
    failedActions.remove(action.getTarget());

    if (action.getPicasso().loggingEnabled) {
      log(OWNER_DISPATCHER, VERB_ENQUEUED, action.request.logId());
    }
  }

