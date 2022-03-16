    @SuppressLint("SetTextI18n")
    @Override
    public void onResume() {
        super.onResume();
        isEn = ContentUtil.APP_SETTING_LANG.equals("en") || ContentUtil.APP_SETTING_LANG.equals("sys") && ContentUtil.SYS_LANG.equals("en");
        if (!language.equalsIgnoreCase(ContentUtil.SYS_LANG)) {
            changeLang();
            language = ContentUtil.SYS_LANG;
        }

        if (!hasAni && !TextUtils.isEmpty(sunrise) && !TextUtils.isEmpty(sunset) && !TextUtils.isEmpty(moonRise) && !TextUtils.isEmpty(moonSet)) {
            DateTime now = DateTime.now(DateTimeZone.UTC);
            float a = Float.valueOf(tz);
            float minute = a * 60;
            now = now.plusMinutes(((int) minute));
            currentTime = now.toString("HH:mm");
            sunView.setTimes(sunrise, sunset, currentTime);
            moonView.setTimes(moonRise, moonSet, currentTime);
            hasAni = true;
        }
    }

