        @Override
        protected Boolean doInBackground(Boolean... params) {
            SERVICE.unzippedfiles=new HashMap<String,Boolean>();
            UnZip.extract(zipfile.getAbsolutePath(), unzipfolder,SERVICE.unzippedfiles);
            return Boolean.TRUE;

        }

