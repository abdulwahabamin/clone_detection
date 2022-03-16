        /**
         * Method that returns if the File is an video file.
         *
         * @param context The current context
         * @param file The File to check
         * @return boolean If the File is an video file.
         */
        public static boolean isVideo(Context context, File file) {
            return MimeTypeHelper.getCategory(context, file).compareTo(MimeTypeCategory.VIDEO) == 0;
        }

