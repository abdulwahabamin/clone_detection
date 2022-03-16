    private void shareFile(Uri uri, String name) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("audio/*");
        share.putExtra(Intent.EXTRA_STREAM, uri);
        getContext().startActivity(Intent.createChooser(share, "Share " + name));
    }

