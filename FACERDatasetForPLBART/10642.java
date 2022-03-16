        /**
         * Method that returns if the File is an image file.
         *
         * @param context The current context
         * @param file The File to check
         * @return boolean If the File is an image file.
         */
        public static boolean isImage(Context context, File file) {
            return MimeTypeHelper.getCategory(context, file).compareTo(MimeTypeCategory.IMAGE) == 0;
        }

