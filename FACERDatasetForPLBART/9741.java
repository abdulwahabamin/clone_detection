    public static String getWorldReadableProperties(Context context, String key) {
        Properties props = new Properties();
        FileReader reader = null;
        try {
            reader = new FileReader(getWorldReadablePropertiesFile(context));
            props.load(reader);
        } catch (IOException ex) {
            // Ignore
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ex) {
                    // Ignore
                }
            }
        }
        return props.getProperty(key);
    }

