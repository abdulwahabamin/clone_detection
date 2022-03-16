    private static Intent getFsoSendIntent(final Context ctx, final List<FileSystemObject> fsos) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        // Create an array list of the uris to send
        ArrayList<Uri> uris = new ArrayList<Uri>();

        int cc = fsos.size();
        String lastMimeType = null;
        boolean sameMimeType = true;
        for (int i = 0; i < cc; i++) {
            FileSystemObject fso = fsos.get(i);

            // Folders are not allowed
            if (FileHelper.isDirectory(fso)) continue;

            // Check if we can use a unique mime/type
            String mimeType = MimeTypeHelper.getMimeType(ctx, fso);
            if (lastMimeType != null && !mimeType.equals(lastMimeType)) {
                sameMimeType = false;
            }

            lastMimeType = mimeType;

            // Add the uri
            uris.add(getUriFromFile(ctx, fso));
        }
        if (lastMimeType != null) {
            if (sameMimeType) {
                intent.setType(lastMimeType);
            } else {
                intent.setType(MimeTypeHelper.ALL_MIME_TYPES);
            }
        }
        if (uris.size() == 1) {
            intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_STREAM, uris.get(0));
        } else {
            intent.setAction(Intent.ACTION_SEND_MULTIPLE);
            intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
        }
        return intent;
    }

