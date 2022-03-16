    public static LinkedHashMap<String, String> getProperties(Context context, String path) {
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
        File f = new File(path);
        LinkedHashMap<String, String> props = new LinkedHashMap<>();
        String name = f.getName();

        props.put("Name", name);

        if (f.isDirectory()) {
            props.put("Type", "folder");
        } else {
            props.put("Type", getMimeType(name));
        }

        try {
            props.put("Location", f.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        props.put("Size", Formatter.formatShortFileSize(context, f.length()));

        props.put("Modified", dateFormat.format(f.lastModified()));

        return props;
    }

