  @Override
  public void onStopNestedScroll(View child) {
    if (Math.abs(totalDrag) >= dragDismissDistance) {
      dispatchDismissCallback();
    } else { // settle back to natural position
      if (mLastActionEvent == MotionEvent.ACTION_DOWN) {
        // this is a 'defensive cleanup for new gestures',
        // don't animate here
        // see also https://github.com/nickbutcher/plaid/issues/185
        setTranslationY(0f);
        setScaleX(1f);
        setScaleY(1f);
      } else {
        animate()
            .translationY(0f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(200L)
            .setInterpolator(AppUtil.getFastOutSlowInInterpolator(context))
            .setListener(null)
            .start();
      }
      totalDrag = 0;
      draggingDown = draggingUp = false;
      dispatchDragCallback(0f, 0f, 0f, 0f);
    }
  }

