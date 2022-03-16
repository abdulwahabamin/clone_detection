        /**
         * Method that returns if the FileSystemObject is an image file.
         *
         * @param context The current context
         * @param fso The FileSystemObject to check
         * @return boolean If the FileSystemObject is an image file.
         */
        public static boolean isImage(Context context, FileSystemObject fso) {
            return MimeTypeHelper.getCategory(context, fso).compareTo(MimeTypeCategory.IMAGE) == 0;
        }

