    public static Set<String> read() {
        Set<String> files = new HashSet<String>();
        String s = "";
        try (FileReader reader = new FileReader("/sdcard/favorites/favorites.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                if (((char)c) != '\n')
                    s += (char) c;
                else {
                    files.add(s);
                    s = "";
                }
            }
            reader.close();
        } catch (IOException ex) {
        }
        return files;
    }

