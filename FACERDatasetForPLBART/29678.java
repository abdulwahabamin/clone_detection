  @OnClick({R.id.toggle_info_button, R.id.toggle_info_layout})
  void toggleInfoLayout() {
    boolean show = toggleArrow(toggleInfoButton);
    if (show) {
      ViewAnimation.expand(expandLayout, new ViewAnimation.AnimListener() {
        @Override
        public void onFinish() {
        }
      });
    } else {
      ViewAnimation.collapse(expandLayout);
    }
  }

