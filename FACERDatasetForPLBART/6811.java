        /**
         * Recursively extract file or directory
         */
        public boolean extract(File archive, String destinationPath) {
            try {
                ZipFile zipfile = new ZipFile(archive);
                int fileCount = zipfile.size();
                for (Enumeration e = zipfile.entries(); e.hasMoreElements();) {
                    ZipEntry entry = (ZipEntry) e.nextElement();
                    unzipEntry(zipfile, entry, destinationPath);
                    isExtracted++;
                    progressDialog.setProgress((isExtracted * 100)/ fileCount);
                }
                return true;
            } catch (Exception e) {
                Log.e(TAG, "Error while extracting file " + archive, e);
                return false;
            }
        }        

