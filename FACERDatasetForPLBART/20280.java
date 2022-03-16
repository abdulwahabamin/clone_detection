  void performRetry(BitmapHunter hunter) {
    if (hunter.isCancelled()) return;

    if (service.isShutdown()) {
      performError(hunter, false);
      return;
    }

    NetworkInfo networkInfo = null;
    if (scansNetworkChanges) {
      ConnectivityManager connectivityManager = getService(context, CONNECTIVITY_SERVICE);
      networkInfo = connectivityManager.getActiveNetworkInfo();
    }

    boolean hasConnectivity = networkInfo != null && networkInfo.isConnected();
    boolean shouldRetryHunter = hunter.shouldRetry(airplaneMode, networkInfo);
    boolean supportsReplay = hunter.supportsReplay();

    if (!shouldRetryHunter) {
      // Mark for replay only if we observe network info changes and support replay.
      boolean willReplay = scansNetworkChanges && supportsReplay;
      performError(hunter, willReplay);
      if (willReplay) {
        markForReplay(hunter);
      }
      return;
    }

    // If we don't scan for network changes (missing permission) or if we have connectivity, retry.
    if (!scansNetworkChanges || hasConnectivity) {
      if (hunter.getPicasso().loggingEnabled) {
        log(OWNER_DISPATCHER, VERB_RETRYING, getLogIdsForHunter(hunter));
      }
      hunter.future = service.submit(hunter);
      return;
    }

    performError(hunter, supportsReplay);

    if (supportsReplay) {
      markForReplay(hunter);
    }
  }

