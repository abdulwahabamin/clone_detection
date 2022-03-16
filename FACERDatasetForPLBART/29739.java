  @Override
  public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
    // if we're in a drag gesture and the user reverses up the we should take those events
    if (draggingDown && dy > 0 || draggingUp && dy < 0) {
      dragScale(dy);
      consumed[1] = dy;
    }
  }

