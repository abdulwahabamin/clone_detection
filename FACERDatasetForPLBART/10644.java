        /**
         * Method that returns if the File is an audio file.
         *
         * @param context The current context
         * @param file The File to check
         * @return boolean If the File is an audio file.
         */
        public static boolean isAudio(Context context, File file) {
            return MimeTypeHelper.getCategory(context, file).compareTo(MimeTypeCategory.AUDIO) == 0;
        }

