  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    //permissions
    ActivityCompat.requestPermissions(MainActivity.this,
                                      new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
    if (getIntent().hasExtra(PATH)) {
      path = getIntent().getStringExtra(PATH);
    }
    setViews();
    horizontalAdapter = new HorizontalAdapter(getCurrentPathButtonsList());
    LinearLayoutManager horizontalLayoutManagaer =
        new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
    horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
    horizontal_recycler_view.setAdapter(horizontalAdapter);
    Drawer result = new DrawerBuilder().withActivity(this)
        .withHasStableIds(true)
        .addDrawerItems(new PrimaryDrawerItem().withName("Music")
                            .withIcon(R.drawable.folder)
                            .withIdentifier(1)
                            .withSelectable(false), new PrimaryDrawerItem().withName("Photos")
                            .withIcon(R.drawable.folder)
                            .withIdentifier(2)
                            .withSelectable(false), new PrimaryDrawerItem().withName("Videos")
                            .withIcon(R.drawable.folder)
                            .withIdentifier(3)
                            .withSelectable(false), new PrimaryDrawerItem().withName("Documents")
                            .withIcon(R.drawable.folder)
                            .withIdentifier(4)
                            .withSelectable(false))
        .withOnDrawerItemClickListener(new OnDrawerItemClickListener() {
          @Override
          public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
            if (drawerItem != null) {
              Intent intent = null;
              if (drawerItem.getIdentifier() == 1) {
                intent = new Intent(MainActivity.this, MainActivity.class);
              }
            }
            return false;
          }
        })
        .withSavedInstance(savedInstanceState)
        .withShowDrawerOnFirstLaunch(true)
        .build();
    directoryItemAdapter = new DirectoryItemAdapter(this, R.layout.layout_list_item);

    listView.setAdapter(directoryItemAdapter);
    tvTitle.setText(path);
  }

