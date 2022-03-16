    @Override
    protected void onStart() {
        super.onStart();
        if (MusicUtils.android44OrLater()) {
            Log.w(LOGTAG, "Cannot rescan music on Android 4.4 or later");
        } else {
            Log.i(LOGTAG, "Rescanning music");
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.fromFile(Environment.getExternalStorageDirectory())));
        }
        finish();
    }

