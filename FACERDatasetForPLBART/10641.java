        /**
         * Method that returns if the FileSystemObject is an video file.
         *
         * @param context The current context
         * @param fso The FileSystemObject to check
         * @return boolean If the FileSystemObject is an video file.
         */
        public static boolean isVideo(Context context, FileSystemObject fso) {
            return MimeTypeHelper.getCategory(context, fso).compareTo(MimeTypeCategory.VIDEO) == 0;
        }

