    public static void shareTrack(Activity activity, MediaDescriptionCompat description) {
        try {

            Uri uri = Uri.fromFile(new File(description.getMediaUri().toString()));
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("audio/*");
            share.putExtra(Intent.EXTRA_STREAM, uri);
            activity.startActivity(Intent.createChooser(share, "Share Sound File"));
        } catch (Exception e) {
            FireLog.e(TAG, "", e);
        }
    }

