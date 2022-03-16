    public static boolean remove(String s){
        Set<String> files = read();
        boolean removed = files.remove(s);
        try (FileWriter writer = new FileWriter("/sdcard/favorites/favorites.txt", false)) {
            for (String file : files) {
                writer.write(file);
                writer.append('\n');
            }
            writer.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return removed;
    }

