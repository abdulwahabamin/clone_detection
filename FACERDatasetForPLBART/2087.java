    private List<File> listFiles(File path, Context context) {
        ArrayList<File> listFiles = new ArrayList<>();
        if (!listFiles.isEmpty()) {
            listFiles.clear();
        }
        if (path.exists() && path.canRead()) {
            listFiles.addAll(Arrays.asList(path.listFiles()));
        } else {
            Toast.makeText(context, context.getString(R.string.cant_read_folder), Toast.LENGTH_SHORT).show();
        }
        return listFiles;
    }

