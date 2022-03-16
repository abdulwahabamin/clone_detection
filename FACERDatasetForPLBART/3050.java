    public FileAdapter(Context context, int resource, List<FileView> objects) {
        super(context, resource, objects);
        this.mainActivity = (MainActivity)context;
        files = objects;
        resourceId = resource;
    }

