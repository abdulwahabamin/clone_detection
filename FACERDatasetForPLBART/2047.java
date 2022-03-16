  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    setViews();
    directoryItemAdapter = new DirectoryItemAdapter(this, R.layout.layout_list_item);
    listView.setAdapter(directoryItemAdapter);
  }

