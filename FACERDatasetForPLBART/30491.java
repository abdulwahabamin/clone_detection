    @Override
    public void changeBack(String condCode) {
        DateTime nowTime = DateTime.now();
        int hourOfDay = nowTime.getHourOfDay();
        if (hourOfDay > 6 && hourOfDay < 19) {
            ivBack.setImageResource(IconUtils.getDayBack(condCode));
        } else {
            ivBack.setImageResource(IconUtils.getNightBack(condCode));
        }
    }

