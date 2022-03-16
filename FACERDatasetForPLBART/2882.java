    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.file_toolbar);
        setSupportActionBar(toolbar);

        mTable = getSharedPreferences("table", MODE_PRIVATE);
        //断头�?��?��?�设置
        ImageView menus = (ImageView) findViewById(R.id.content_hamburger);
        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        ((DrawerLayout) findViewById(R.id.activity_file)).addView(guillotineMenu);
        mAnimation = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), menus)
                .setStartDelay(250)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .setGuillotineListener(new GuillotineListener() {
                    @Override
                    public void onGuillotineOpened() {
                        mTable.edit().putBoolean("menuOpen", true).apply();
                    }

                    @Override
                    public void onGuillotineClosed() {
                        mTable.edit().putBoolean("menuOpen", false).apply();
                    }
                })
                .build();

        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        findViewById(R.id.file_bottom).setOnClickListener(this);

        LinearLayout image = (LinearLayout) findViewById(R.id.file_image);
        LinearLayout music = (LinearLayout) findViewById(R.id.file_music);
        LinearLayout video = (LinearLayout) findViewById(R.id.file_video);
        LinearLayout word = (LinearLayout) findViewById(R.id.file_word);
        LinearLayout apk = (LinearLayout) findViewById(R.id.file_apk);
        LinearLayout zip = (LinearLayout) findViewById(R.id.file_zip);
        zip.setOnClickListener(this);
        apk.setOnClickListener(this);
        video.setOnClickListener(this);
        music.setOnClickListener(this);
        image.setOnClickListener(this);
        word.setOnClickListener(this);

        //MaterialDesign水波纹效果
        MaterialRippleLayout.on(image).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();
        MaterialRippleLayout.on(apk).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();
        MaterialRippleLayout.on(zip).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();
        MaterialRippleLayout.on(video).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();
        MaterialRippleLayout.on(word).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();
        MaterialRippleLayout.on(music).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();

        LinearLayout clear = (LinearLayout) findViewById(R.id.menu_clear);
        LinearLayout check = (LinearLayout) findViewById(R.id.menu_check);
        LinearLayout about = (LinearLayout) findViewById(R.id.menu_about);
        LinearLayout quit = (LinearLayout) findViewById(R.id.menu_quit);
        RelativeLayout title = (RelativeLayout) findViewById(R.id.menu_title);

        check.setOnClickListener(this);
        clear.setOnClickListener(this);
        about.setOnClickListener(this);
        quit.setOnClickListener(this);
        title.setOnClickListener(this);

        MaterialRippleLayout.on(check).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();
        MaterialRippleLayout.on(clear).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();
        MaterialRippleLayout.on(about).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();
        MaterialRippleLayout.on(quit).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();
        MaterialRippleLayout.on(title).rippleColor(Color.BLACK).rippleOverlay(true).rippleAlpha((float) 0.7).create();

        //底边�?存储空间显示
        getFreeSpace();
        getTotalSpace();

        Fab fab = (Fab) findViewById(R.id.fab);
        View sheetView = findViewById(R.id.fab_sheet);
        View overlay = findViewById(R.id.overlay);
        int sheetColor = getResources().getColor(R.color.textColor2);
        int fabColor = getResources().getColor(R.color.colorAccent);

        // �?始化 material sheet FAB，�?�索按钮
        materialSheetFab = new MaterialSheetFab<>(fab, sheetView, overlay,
                sheetColor, fabColor);
        TextView name_search = (TextView)findViewById(R.id.name_search);
        TextView type_search = (TextView)findViewById(R.id.type_search);
        type_search.setOnClickListener(this);
        name_search.setOnClickListener(this);
        MaterialRippleLayout.on(name_search).rippleColor(R.color.colorAccent).rippleOverlay(true).rippleAlpha((float) 0.7).create();
        MaterialRippleLayout.on(type_search).rippleColor(R.color.colorAccent).rippleOverlay(true).rippleAlpha((float) 0.7).create();
    }

