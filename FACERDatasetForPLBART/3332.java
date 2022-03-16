        @Override
        protected Boolean doInBackground(Boolean... params) {
            if(files!=null && !files.isEmpty()) {
                for (FileItem file : files) {
                    File renamed = new File(Files.getAvailableIncrementedFilePath(moveToPath+File.separator+file.getName()));
                    file.renameTo(renamed);
                }

            }
            //Indexer.refresh(SERVICE);


            return Boolean.TRUE;

        }

