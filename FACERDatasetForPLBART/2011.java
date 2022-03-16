  public DirectoryItemAdapter(Context context, int resource) {
    super(context, resource);
    list = new ArrayList<>();
    this.context = context;
    inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

