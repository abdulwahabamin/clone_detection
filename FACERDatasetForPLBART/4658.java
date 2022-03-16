        public static Comparator<FileItem> ascending(final Comparator<FileItem> other) {
            return new Comparator<FileItem>() {
                public int compare(FileItem o1, FileItem o2) {
                    return -1 * other.compare(o2, o1);
                }
            };
        }

