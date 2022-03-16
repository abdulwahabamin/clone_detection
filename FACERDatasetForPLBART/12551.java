    private void cleanupOperation() {
        File cacheDir = new File(getExternalCacheDir(), SecureChoiceClickListener.CACHE_DIR);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.HOUR, -1);
        Date cutoff = calendar.getTime();

        if (!cacheDir.exists()) {
            return;
        }

        // Get list of files
        File[] files = cacheDir.listFiles();

        if (files == null) {
            return;
        }

        // Delete all, won't run if list is empty
        for (File file : files) {
            FileSystemObject fso = FileHelper.createFileSystemObject(file);
            Date lastAccessDate = fso.getLastAccessedTime();
            if (lastAccessDate.before(cutoff)) {
                file.delete();
            }
        }

        // Check again after deletion
        files = cacheDir.listFiles();

        // If no files, cancel alarm
        if (files == null || files.length < 1) {
            cancelAlarm(this);
        }

    }

