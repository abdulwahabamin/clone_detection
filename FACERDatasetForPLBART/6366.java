    public static Drawable loadMimeIcon(
            Context context, String mimeType, String authority, String docId, int mode) {
        final Resources res = context.getResources();

        if (Document.MIME_TYPE_DIR.equals(mimeType)) {
            // TODO: eventually move these hacky assets into that package
            if ("com.android.providers.media.documents".equals(authority)
                    && docId.startsWith("album")) {
                return res.getDrawable(R.drawable.ic_doc_album);
            }

            if (mode == DocumentsActivity.State.MODE_GRID) {
                return res.getDrawable(R.drawable.ic_grid_folder);
            } else {
                return res.getDrawable(R.drawable.ic_root_folder);
            }
        }

        return loadMimeIcon(context, mimeType);
    }

