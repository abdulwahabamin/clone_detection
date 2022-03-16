    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void applyLillipopFunctionality(NotificationCompat.Builder builder) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder
                    .setCategory(Notification.CATEGORY_TRANSPORT)
                    .setVisibility(Notification.VISIBILITY_PUBLIC);
        }
    }

