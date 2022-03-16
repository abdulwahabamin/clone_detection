  private void setupDismissFrameLayout() {
    dismissFrameLayout.addListener(new ElasticDragDismissFrameLayout.SystemChromeFader(this) {
      @Override
      public void onDragDismissed() {
        super.onDragDismissed();
        finishAfterTransition();
      }
    });
  }

