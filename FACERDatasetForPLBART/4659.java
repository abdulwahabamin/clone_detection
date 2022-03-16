        public static Comparator<FileItem> getComparator(final PersonComparator... multipleOptions) {
            return new Comparator<FileItem>() {
                public int compare(FileItem o1, FileItem o2) {
                    for (PersonComparator option : multipleOptions) {
                        int result = option.compare(o1, o2);
                        if (result != 0) {
                            return result;
                        }
                    }
                    return 0;
                }
            };
        }

