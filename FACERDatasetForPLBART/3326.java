        @Override
        protected Boolean doInBackground(Boolean... params) {
            //BLog.e("POINT", "1");
            //IndexerDb.init(SERVICE);
            //Log.e("DB", "DB SIZE: " + IndexerDb.getDb().getSizeOnDisk());
            try {
                wait(1000);
            } catch(Exception e) {}
            Zip.compress(zipfile.getParent(),zipfile.getName(),files);
            return Boolean.TRUE;

        }

