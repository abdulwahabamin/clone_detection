    /**
     * Method that sends a {@link FileSystemObject} with the default registered application
     * by the system, or ask the user for select a registered application.
     *
     * @param ctx The current context
     * @param fsos The file system objects
     * @param onDismissListener The dismiss listener
     */
    public static void sendMultipleFileSystemObject(
            final Context ctx, final List<FileSystemObject> fsos,
            OnDismissListener onDismissListener) {
        try {
            // Create the intent to
            Intent intent = new Intent();
            intent.setAction(android.content.Intent.ACTION_SEND_MULTIPLE);
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
                if (mimeType == null) {
                    sameMimeType = false;
                }
                if (sameMimeType &&
                    (mimeType != null && lastMimeType != null &&
                     mimeType.compareTo(lastMimeType) != 0)) {
                    sameMimeType = false;
                }
                lastMimeType = mimeType;

                // Add the uri
                uris.add(getUriFromFile(ctx, fso));
            }
            if (sameMimeType) {
                intent.setType(lastMimeType);
            } else {
                intent.setType(MimeTypeHelper.ALL_MIME_TYPES);
            }
            intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);

            // Resolve the intent
            resolveIntent(
                    ctx,
                    intent,
                    false,
                    onDismissListener);

        } catch (Exception e) {
            ExceptionUtil.translateException(ctx, e);
        }
    }

