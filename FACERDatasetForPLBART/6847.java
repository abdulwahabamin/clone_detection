    public CustomAdapter(Context context, MainActivity activ) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        activity = activ;
        fh = new FolderHistory();
        folderHistory = fh.getHistory();
        Log.i("Steps", "CustomAdapterConstructor");
    }

