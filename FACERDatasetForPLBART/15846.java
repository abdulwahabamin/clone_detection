        public void deleteCacheFile(String fileName) {
            File file = new File(Library.FILE_SAVE_LOCATION, fileName);
            if(file.exists()) {
                fileCacheSize -= file.length();
                file.delete();
            }
        }

