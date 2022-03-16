        @Override
        protected Integer doInBackground(Object... params) {
            if (zos == null){
                return error;
            }
            List<File> list = (List<File>) params[0]; 
            for (File file:list){
                try {
                    compressFile(file, "");
                } catch (IOException e) {
                    Log.e(TAG, "Error while compressing", e);
                    return error;
                }
            }
            return success;
        }

