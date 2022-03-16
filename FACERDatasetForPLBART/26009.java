    private static void limitVolume() {
        String dir = getLogPath();
        File dirFile = new File(dir);
        if (!dirFile.exists()) {
            return;
        }

        final File files[] = dirFile.listFiles();
        if (files == null || files.length <= Math.max(0, mBackFileNumLimit)) {
            return;
        }

        int numOfDeletable = 0;
        for (int i = 0, N = files.length; i < N; i++) {
            File file = files[i];
            if (isBakFile(file.getName())) {
                ++numOfDeletable;
            }
        }

        if (numOfDeletable <= 0) {
            // really weird, the naming rule have been changed!
            // this function won't work anymore.
            return;
        }

        // the logs.txt and uncaught_exception.txt may be missing,
        // so just allocate same size as the old.
        File[] deletables = new File[numOfDeletable];
        int i = 0;
        for (File e : files) {
            if (i >= numOfDeletable) {
                // unexpected case.
                break;
            }
            
            if (isBakFile(e.getName())) {
                deletables[i++] = e;
            }
        }

        deleteIfOutOfBound(deletables);
    }

