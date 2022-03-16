  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_copy_move);
    setViews();
    horizontalAdapter = new HorizontalAdapter(getCurrentPathButtonsList());
    LinearLayoutManager horizontalLayoutManagaer
        = new LinearLayoutManager(CopyMoveActivity.this, LinearLayoutManager.HORIZONTAL, false);
    horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
    horizontal_recycler_view.setAdapter(horizontalAdapter);
    directoryItemAdapter = new DirectoryItemAdapter(this, R.layout.layout_list_item);
    listView.setAdapter(directoryItemAdapter);
    if (getIntent().hasExtra(PATH)) {
      this.path = getIntent().getStringExtra(PATH);
    }
    Toast.makeText(CopyMoveActivity.this, path, Toast.LENGTH_LONG).show();
  }

