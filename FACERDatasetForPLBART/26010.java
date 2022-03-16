    private static void deleteIfOutOfBound(File[] files) {
        if (files.length <= mBackFileNumLimit) {
            return;
        }

        // sort files by create time(time is on the file name) DESC.
        Comparator<? super File> comparator = new Comparator<File>() {

            @Override
            public int compare(File lhs, File rhs) {
                return rhs.getName().compareTo(lhs.getName());
            }

        };

        Arrays.sort(files, comparator);

        final int filesNum = files.length;

        // delete files from index to size.
        for (int i = mBackFileNumLimit; i < filesNum; ++i) {
            File file = files[i];
            if (!file.delete()) {
                // NOTE here we cannot call MLog, we are to be depended by MLog.
                Log.e("LogToES", "LogToES failed to delete file " + file);
            }
        }
    }

