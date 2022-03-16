        CalculateSizeTask(File file,
                          ContentResolver contentResolver,
                          FileViewFragment.OnCalculateSizeCompleted listener) {
            this.listener = listener;
            this.file = file;
            resolver = contentResolver;
        }

