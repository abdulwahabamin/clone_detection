  private void dispatchDismissCallback() {
    if (callbacks != null && !callbacks.isEmpty()) {
      for (ElasticDragDismissCallback callback : callbacks) {
        callback.onDragDismissed();
      }
    }
  }

