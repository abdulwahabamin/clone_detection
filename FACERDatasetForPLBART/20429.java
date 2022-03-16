  PicassoDrawable(Context context, Bitmap bitmap, Drawable placeholder,
      Picasso.LoadedFrom loadedFrom, boolean noFade, boolean debugging) {
    super(context.getResources(), bitmap);

    this.debugging = debugging;
    this.density = context.getResources().getDisplayMetrics().density;

    this.loadedFrom = loadedFrom;

    boolean fade = loadedFrom != MEMORY && !noFade;
    if (fade) {
      this.placeholder = placeholder;
      animating = true;
      startTimeMillis = SystemClock.uptimeMillis();
    }
  }

