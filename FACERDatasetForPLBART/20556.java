  static String getLogIdsForHunter(BitmapHunter hunter, String prefix) {
    StringBuilder builder = new StringBuilder(prefix);
    Action action = hunter.getAction();
    if (action != null) {
      builder.append(action.request.logId());
    }
    List<Action> actions = hunter.getActions();
    if (actions != null) {
      for (int i = 0, count = actions.size(); i < count; i++) {
        if (i > 0 || action != null) builder.append(", ");
        builder.append(actions.get(i).request.logId());
      }
    }
    return builder.toString();
  }

