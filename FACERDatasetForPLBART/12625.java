    /**
     * Method that creates a {@link LinkedResource} for the list of object to the
     * destination directory
     *
     * @param items The list of the source items
     * @param directory The destination directory
     */
    private static List<LinkedResource> createLinkedResource(
            List<FileSystemObject> items, FileSystemObject directory) {
        List<LinkedResource> resources =
                new ArrayList<LinkedResource>(items.size());
        int cc = items.size();
        for (int i = 0; i < cc; i++) {
            FileSystemObject fso = items.get(i);
            File src = new File(fso.getFullPath());
            File dst = new File(directory.getFullPath(), fso.getName());
            resources.add(new LinkedResource(src, dst));
        }
        return resources;
    }

