    /**
      * Method that checks whether it is a special android cursor mimetype
      * that we don't support and should filter it all
      *
      * @param mimeType The mime type to be checked
      * @return true if mime type is known, false otherwise
      */
     public static final boolean isAndroidCursorMimeType(String mimeType) {
         return mimeType.startsWith("vnd.android.cursor");
     }

