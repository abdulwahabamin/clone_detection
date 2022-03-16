    private static boolean isDetailVisible(int detailId,
                                           RemoteViews remoteViews,
                                           int widgetDetailId,
                                           int widgetDetailIconId,
                                           Set<Integer> enabledDetails) {
        if ((enabledDetails == null) || enabledDetails.contains(detailId)) {
            remoteViews.setViewVisibility(widgetDetailId, View.VISIBLE);
            remoteViews.setViewVisibility(widgetDetailIconId, View.VISIBLE);
            return true;
        }
        remoteViews.setViewVisibility(widgetDetailId, View.GONE);
        remoteViews.setViewVisibility(widgetDetailIconId, View.GONE);
        return false;
    }

