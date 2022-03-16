    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_setting_back:
                onBackPressed();
                break;
            case R.id.rv_control:
                startActivity(new Intent(this, ControlCityActivity.class));
                break;
            case R.id.rv_system_language:
                SpUtils.putString(this, "language", "sys");
                ContentUtil.APP_SETTING_LANG = "sys";
                chooseView(tvSys, ivSys);
                unChooseView(tvChinese, ivChinese);
                unChooseView(tvEnglish, ivEnglish);
                changeLang();
                break;
            case R.id.rv_chinese_language:
                SpUtils.putString(this, "language", "zh");
                ContentUtil.APP_SETTING_LANG = "zh";
                chooseView(tvChinese, ivChinese);
                unChooseView(tvSys, ivSys);
                unChooseView(tvEnglish, ivEnglish);
                changeLang();
                break;
            case R.id.rv_english_language:
                SpUtils.putString(this, "language", "en");
                ContentUtil.APP_SETTING_LANG = "en";
                chooseView(tvEnglish, ivEnglish);
                unChooseView(tvSys, ivSys);
                unChooseView(tvChinese, ivChinese);
                changeLang();
                break;
            case R.id.rv_she:
                ContentUtil.UNIT_CHANGE = true;
                SpUtils.putString(this, "unit", "she");
                ContentUtil.APP_SETTING_UNIT = "she";
                chooseView(tvShe, ivShe);
                unChooseView(tvHua, ivHua);
                break;
            case R.id.rv_hua:
                ContentUtil.UNIT_CHANGE = true;
                ContentUtil.APP_SETTING_UNIT = "hua";
                SpUtils.putString(this, "unit", "hua");
                chooseView(tvHua, ivHua);
                unChooseView(tvShe, ivShe);
                break;
            case R.id.rv_small:
                SpUtils.putString(this, "size", "small");
                chooseView(tvSmall, ivSmall);
                unChooseView(tvMid, ivMid);
                unChooseView(tvLarge, ivLarge);
                if (preSize.equalsIgnoreCase("mid")) {
                    midSmall(tvList);
                } else if (preSize.equalsIgnoreCase("large")) {
                    largeSmall(tvList);
                }
                ContentUtil.APP_PRI_TESI = preSize;
                preSize = "small";
                ContentUtil.APP_SETTING_TESI = "small";
                break;
            case R.id.rv_mid:
                SpUtils.putString(this, "size", "mid");
                chooseView(tvMid, ivMid);
                unChooseView(tvSmall, ivSmall);
                unChooseView(tvLarge, ivLarge);
                if (preSize.equalsIgnoreCase("small")) {
                    smallMid(tvList);
                } else if (preSize.equalsIgnoreCase("large")) {
                    largeMid(tvList);
                }
                ContentUtil.APP_PRI_TESI = preSize;
                preSize = "mid";
                ContentUtil.APP_SETTING_TESI = "mid";
                break;
            case R.id.rv_large:
                SpUtils.putString(this, "size", "large");
                chooseView(tvLarge, ivLarge);
                unChooseView(tvSmall, ivSmall);
                unChooseView(tvMid, ivMid);
                if (preSize.equalsIgnoreCase("small")) {
                    smallLarge(tvList);
                } else if (preSize.equalsIgnoreCase("mid")) {
                    midLarge(tvList);
                }
                ContentUtil.APP_PRI_TESI = preSize;
                preSize = "large";
                ContentUtil.APP_SETTING_TESI = "large";
                break;
            case R.id.rv_about:
                startActivity(new Intent(this, AboutActivity.class));
                break;
        }

    }

