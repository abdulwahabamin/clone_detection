    public static String getMimeType(String name) {
        // get mimetype using extension extracted from filename
        String s = name;
        int i = s.lastIndexOf(".") + 1;
        if (i < s.length()) {
            String mimeType = mime.getMimeTypeFromExtension(s.substring(i).toLowerCase());
            return mimeType;
        } else {
            return null;
        }
    }

