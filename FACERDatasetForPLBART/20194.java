  Action(Picasso picasso, T target, Request request, boolean skipCache, boolean noFade,
      int errorResId, Drawable errorDrawable, String key) {
    this.picasso = picasso;
    this.request = request;
    this.target = new RequestWeakReference<T>(this, target, picasso.referenceQueue);
    this.skipCache = skipCache;
    this.noFade = noFade;
    this.errorResId = errorResId;
    this.errorDrawable = errorDrawable;
    this.key = key;
  }

