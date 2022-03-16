        /**
         * Method that returns if the FileSystemObject is an Android app.
         *
         * @param context The current context
         * @param fso The FileSystemObject to check
         * @return boolean If the FileSystemObject is an Android app.
         */
        public static boolean isAndroidApp(Context context, FileSystemObject fso) {
            return MIME_TYPE_APK.equals(MimeTypeHelper.getMimeType(context, fso));
        }

