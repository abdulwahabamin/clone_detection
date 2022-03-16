    private void initView() {
        tvList = new ArrayList<>();
        String language = SpUtils.getString(this, "language", "sys");
        String unit = SpUtils.getString(this, "unit", "she");
        String size = SpUtils.getString(this, "size", "mid");
        ImageView ivBack = findViewById(R.id.iv_setting_back);
        RelativeLayout rvControl = findViewById(R.id.rv_control);
        RelativeLayout rvSys = findViewById(R.id.rv_system_language);
        RelativeLayout rvChinese = findViewById(R.id.rv_chinese_language);
        RelativeLayout rvEnglish = findViewById(R.id.rv_english_language);
        RelativeLayout rvShe = findViewById(R.id.rv_she);
        RelativeLayout rvHua = findViewById(R.id.rv_hua);
        RelativeLayout rvSmall = findViewById(R.id.rv_small);
        RelativeLayout rvMid = findViewById(R.id.rv_mid);
        RelativeLayout rvLarge = findViewById(R.id.rv_large);
        RelativeLayout rvAbout = findViewById(R.id.rv_about);
        tvSetTitle = findViewById(R.id.tv_setting_title);
        tvControl = findViewById(R.id.tv_control);
        tvAbout = findViewById(R.id.tv_about);
        tvLangTitle = findViewById(R.id.tv_choose_lang);
        tvUnitTitle = findViewById(R.id.tv_choose_unit);
        tvSizeTitle = findViewById(R.id.tv_choose_size);
        tvSys = findViewById(R.id.tv_sys_right);
        tvChinese = findViewById(R.id.tv_ch_right);
        tvEnglish = findViewById(R.id.tv_en_right);
        tvHua = findViewById(R.id.tv_hua_right);
        tvShe = findViewById(R.id.tv_she_right);
        tvSmall = findViewById(R.id.tv_small_right);
        tvMid = findViewById(R.id.tv_mid_right);
        tvLarge = findViewById(R.id.tv_large_right);
        ivSys = findViewById(R.id.iv_sys_right);
        ivChinese = findViewById(R.id.iv_ch_right);
        ivEnglish = findViewById(R.id.iv_en_right);
        ivHua = findViewById(R.id.iv_hua_right);
        ivShe = findViewById(R.id.iv_she_right);
        ivSmall = findViewById(R.id.iv_small_right);
        ivMid = findViewById(R.id.iv_mid_right);
        ivLarge = findViewById(R.id.iv_large_right);
        tvList.add(tvControl);
        tvList.add(tvAbout);
        tvList.add(tvLangTitle);
        tvList.add(tvUnitTitle);
        tvList.add(tvSizeTitle);
        tvList.add(tvSys);
        tvList.add(tvChinese);
        tvList.add(tvEnglish);
        tvList.add(tvHua);
        tvList.add(tvShe);
        tvList.add(tvSmall);
        tvList.add(tvMid);
        tvList.add(tvLarge);
        rvControl.setOnClickListener(this);
        rvChinese.setOnClickListener(this);
        rvSys.setOnClickListener(this);
        rvEnglish.setOnClickListener(this);
        rvShe.setOnClickListener(this);
        rvHua.setOnClickListener(this);
        rvSmall.setOnClickListener(this);
        rvMid.setOnClickListener(this);
        rvLarge.setOnClickListener(this);
        rvAbout.setOnClickListener(this);
        ivBack.setOnClickListener(this);
        switch (language) {
            case "sys":
                chooseView(tvSys, ivSys);
                unChooseView(tvChinese, ivChinese);
                unChooseView(tvEnglish, ivEnglish);
                break;
            case "zh":
                chooseView(tvChinese, ivChinese);
                unChooseView(tvSys, ivSys);
                unChooseView(tvEnglish, ivEnglish);
                break;
            case "en":
                chooseView(tvEnglish, ivEnglish);
                unChooseView(tvSys, ivSys);
                unChooseView(tvChinese, ivChinese);
                break;
        }
        switch (unit) {
            case "she":
                chooseView(tvShe, ivShe);
                unChooseView(tvHua, ivHua);
                break;
            case "hua":
                chooseView(tvHua, ivHua);
                unChooseView(tvShe, ivShe);
                break;
        }
        switch (size) {
            case "small":
                preSize = "small";
                chooseView(tvSmall, ivSmall);
                unChooseView(tvMid, ivMid);
                unChooseView(tvLarge, ivLarge);
                break;
            case "mid":
                preSize = "mid";
                chooseView(tvMid, ivMid);
                unChooseView(tvSmall, ivSmall);
                unChooseView(tvLarge, ivLarge);
                break;
            case "large":
                preSize = "large";
                chooseView(tvLarge, ivLarge);
                unChooseView(tvSmall, ivSmall);
                unChooseView(tvMid, ivMid);
                break;
        }
        ContentUtil.APP_PRI_TESI = preSize;
    }

