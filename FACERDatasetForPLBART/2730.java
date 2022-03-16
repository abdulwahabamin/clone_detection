    public static boolean delete(String[] paths)
    {
        for (String path: paths) {
            File f = new File(path);
            if (f.isDirectory()) {
                String[] files = f.list();
                for (int i = 0; i < files.length; i++) {
                    try {
                        delete(new File(f, files[i]).getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            }
            // all sub-items have been deleted, now delete the empty folder
            f.delete();
        }
        return true;
    }

