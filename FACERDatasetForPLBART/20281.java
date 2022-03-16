  void performComplete(BitmapHunter hunter) {
    if (hunter.getResult() == null) {
      performError(hunter, false);
      return;
    }

    if (!hunter.shouldSkipMemoryCache()) {
      cache.set(hunter.getKey(), hunter.getResult());
    }
    hunterMap.remove(hunter.getKey());
    batch(hunter);
    if (hunter.getPicasso().loggingEnabled) {
      log(OWNER_DISPATCHER, VERB_BATCHED, getLogIdsForHunter(hunter), "for completion");
    }
  }

