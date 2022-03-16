  public void addListener(ElasticDragDismissCallback listener) {
    if (callbacks == null) {
      callbacks = new ArrayList<>();
    }
    callbacks.add(listener);
  }

