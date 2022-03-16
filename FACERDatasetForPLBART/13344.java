    /**
     * Method that returns the name without the extension of a file system object.
     *
     * @param name The name of file system object
     * @return The name without the extension of the file system object.
     */
    public static String getName(String name) {
       String ext = getExtension(name);
       if (ext == null) return name;
       return name.substring(0, name.length() - ext.length() - 1);
    }

