    public static boolean writeWorldReadableProperty(Context context, String key, String value) {
        if (AndroidHelper.isSecondaryUser(context)) {
            // Not allowed
            return false;
        }
        Properties props = new Properties();
        FileReader reader = null;
        FileWriter writer = null;
        try {
            File dst = getWorldReadablePropertiesFile(context);
            if (!dst.exists()) {
                dst.createNewFile();
                dst.setWritable(true, true);
                dst.setReadable(true, false);
                dst.setExecutable(false);
            }
            reader = new FileReader(dst);
            props.load(reader);
            try {
                props.load(new FileReader(dst));
            } catch (IOException ex) {
                return false;
            }
            props.put(key, value);
            writer = new FileWriter(dst);
            props.store(writer, null);
            return true;

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
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    // Ignore
                }
            }
        }
        return false;
    }

