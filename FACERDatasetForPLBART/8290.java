    private static Uri getResultUriForFileFromIntent(Context context, File src, Intent intent) {
        // Try to find the preferred uri scheme
        Uri result = MediaHelper.fileToContentUri(context, src);
        if (result == null) {
            result = Uri.fromFile(src);
        }

        if (Intent.ACTION_PICK.equals(intent.getAction()) && intent.getData() != null) {
            String scheme = intent.getData().getScheme();
            if (scheme != null) {
                result = result.buildUpon().scheme(scheme).build();
            }
        }

        return result;
    }

