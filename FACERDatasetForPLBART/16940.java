    public static void startNowPlayingActivity(Activity activity) {
        MediaControllerCompat controller = MediaControllerCompat.getMediaController(activity);
        MediaMetadataCompat metadata = controller.getMetadata();

        Intent intent = new Intent(activity, NowPlayingActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        if (metadata != null) {
            intent.putExtra(ActionHelper.EXTRA_CURRENT_MEDIA_DESCRIPTION,
                    metadata.getDescription());
        }
        activity.startActivity(intent);
    }

