    @Override
    public Resources getResources() {
        // 本地语言设置
        String language = Locale.getDefault().getLanguage();
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (ContentUtil.APP_SETTING_LANG.equals("en")) {
            configuration.locale = Locale.ENGLISH;// 英语
            ContentUtil.SYS_LANG = "en";
        } else {
            if (ContentUtil.APP_SETTING_LANG.equals("sys") && !"zh".equals(language)) {
                configuration.locale = Locale.ENGLISH;// 英语
                ContentUtil.SYS_LANG = "en";
            } else {
                configuration.locale = Locale.SIMPLIFIED_CHINESE;// 简体中文
                ContentUtil.SYS_LANG = "zh";
            }
        }

        switch (ContentUtil.APP_SETTING_TESI) {
            case "small":
                configuration.fontScale = 0.8f;
                break;
            case "mid":
                configuration.fontScale = 1f;
                break;
            case "large":
                configuration.fontScale = 1.1f;
                break;
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;

    }

