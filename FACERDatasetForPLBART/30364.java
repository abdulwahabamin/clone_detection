    @Override
    public void getAlarm(String location) {
        HeWeather.getAlarm(context, location, lang, unit, new HeWeather.OnResultAlarmBeansListener() {
            @Override
            public void onError(Throwable throwable) {
                weatherInterface.getAlarm(null);
                Log.i("sky", "getAlarm onError: " + throwable);
            }

            @Override
            public void onSuccess(AlarmList alarmList) {
                if (Code.OK.getCode().equalsIgnoreCase(alarmList.getStatus())) {
                    weatherInterface.getAlarm(alarmList.getAlarms().get(0));
                    SpUtils.saveBean(context, "alarm", alarmList);
                }
            }

        });
    }

