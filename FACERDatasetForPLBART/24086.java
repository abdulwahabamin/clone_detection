    public static Intent shareVia(long audioId, String mimeType, Resources resources) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM,
            ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, audioId));
        intent.setType(mimeType);

        return Intent.createChooser(intent, resources.getString(R.string.share_via));
    }

