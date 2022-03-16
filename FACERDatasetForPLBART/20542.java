  @Override void error() {
    Target target = getTarget();
    if (target != null) {
      if (errorResId != 0) {
        target.onBitmapFailed(picasso.context.getResources().getDrawable(errorResId));
      } else {
        target.onBitmapFailed(errorDrawable);
      }
    }
  }

