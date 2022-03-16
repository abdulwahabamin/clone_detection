  RemoteViewsAction(Picasso picasso, Request data, RemoteViews remoteViews, int viewId,
      int errorResId, boolean skipCache, String key) {
    super(picasso, new RemoteViewsTarget(remoteViews, viewId), data, skipCache, false, errorResId,
        null, key);
    this.remoteViews = remoteViews;
    this.viewId = viewId;
  }

