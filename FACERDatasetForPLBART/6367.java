    public static Drawable loadMimeIcon(Context context, String mimeType) {
        final Resources res = context.getResources();

        if (Document.MIME_TYPE_DIR.equals(mimeType)) {
            // TODO: return a mipmap, since this is used for grid
            return res.getDrawable(R.drawable.ic_root_folder);
        }

        // Look for exact match first
        Integer resId = sMimeIcons.get(mimeType);
        if (resId != null) {
            return res.getDrawable(resId);
        }

        if (mimeType == null) {
            // TODO: generic icon?
            return null;
        }

        // Otherwise look for partial match
        final String typeOnly = mimeType.split("/")[0];
        if ("audio".equals(typeOnly)) {
            return res.getDrawable(R.drawable.ic_doc_audio);
        } else if ("image".equals(typeOnly)) {
            return res.getDrawable(R.drawable.ic_doc_image);
        } else if ("text".equals(typeOnly)) {
            return res.getDrawable(R.drawable.ic_doc_text);
        } else if ("video".equals(typeOnly)) {
            return res.getDrawable(R.drawable.ic_doc_video);
        } else {
            return res.getDrawable(R.drawable.ic_doc_generic);
        }
    }

