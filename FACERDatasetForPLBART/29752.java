    @Override
    public void onDrag(float elasticOffset, float elasticOffsetPixels,
                       float rawOffset, float rawOffsetPixels) {
      if (elasticOffsetPixels > 0) {
        // dragging downward, fade the status bar in proportion
        activity.getWindow().setStatusBarColor(AppUtil.modifyAlpha(activity.getWindow()
            .getStatusBarColor(), (int) ((1f - rawOffset) * statusBarAlpha)));
      } else if (elasticOffsetPixels == 0) {
        // reset
        activity.getWindow().setStatusBarColor(AppUtil.modifyAlpha(
            activity.getWindow().getStatusBarColor(), statusBarAlpha));
        activity.getWindow().setNavigationBarColor(AppUtil.modifyAlpha(
            activity.getWindow().getNavigationBarColor(), navBarAlpha));
      } else if (fadeNavBar) {
        // dragging upward, fade the appbar_menu bar in proportion
        activity.getWindow().setNavigationBarColor(
            AppUtil.modifyAlpha(activity.getWindow().getNavigationBarColor(),
                (int) ((1f - rawOffset) * navBarAlpha)));
      }
    }

