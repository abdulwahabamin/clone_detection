  @Override
  protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    if (dragDismissFraction > 0f) {
      dragDismissDistance = h * dragDismissFraction;
    }
  }

