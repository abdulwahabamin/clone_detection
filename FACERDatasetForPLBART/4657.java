        public static Comparator<FileItem> decending(final Comparator<FileItem> other) {
            return new Comparator<FileItem>() {
                public int compare(FileItem o1, FileItem o2) {
                    return -1 * other.compare(o1, o2);
                }
            };
        }

