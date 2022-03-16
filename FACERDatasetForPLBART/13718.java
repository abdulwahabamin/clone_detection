        @Override
        public int compare(File f1, File f2) {
            if (f1.isDirectory() && f2.isDirectory()) { // Both are directories
                return f1.getName().compareToIgnoreCase(f2.getName());
            } else {
                if (f1.isDirectory())       // Only f1 is directory, f2 is file
                    return -1;
                else if (f2.isDirectory())  // Only f2 is directory, f1 is file
                    return 1;
                else                        // Both are files
                    return f1.getName().compareToIgnoreCase(f2.getName());
            }
        }

