  @Override
  final public void addFooterView(View v) {
    if (mRemoveMode == SLIDE_LEFT || mRemoveMode == SLIDE_RIGHT) {
      throw new RuntimeException("Footers are not supported with TouchListView in conjunction with remove_mode");
    }
  }

