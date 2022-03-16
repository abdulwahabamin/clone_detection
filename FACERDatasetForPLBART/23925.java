    private void share(File file, CharSequence playlistName) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        intent.putExtra(Intent.EXTRA_SUBJECT, playlistName);
        intent.setType(MusicUtils.AUDIO_X_MPEGURL);

        Intent chooser = Intent.createChooser(intent, context.getString(R.string.share_via));
        chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(chooser);
    }

