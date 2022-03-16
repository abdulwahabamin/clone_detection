    public static void write(String s) {
        Set<String> files = read();
        files.add(s);
        try (FileWriter writer = new FileWriter("/sdcard/favorites/favorites.txt", false)) {
            for (String file : files) {
                writer.write(file);
                writer.append('\n');
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

