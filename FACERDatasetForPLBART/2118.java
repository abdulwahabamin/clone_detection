        @Override
        protected FileModel doInBackground(Void... voids) {
            if (isCancelled()) {
                return null;
            }
            FileUtils.AddToDatabaseCallback callback = new FileUtils.AddToDatabaseCallback() {
                @Override
                public void addToDatabase(FileModel fileModel) {
                    addToContentProvider(resolver,
                            fileModel.getFile().getAbsolutePath(),
                            fileModel.getSizeDirectory());
                }

                @Override
                public boolean isTaskCancelled() {
                    return isCancelled();
                }
            };
            return FileUtils.getDirectorySize(file, callback);
        }

