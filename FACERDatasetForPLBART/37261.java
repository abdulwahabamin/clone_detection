    @Override
    public void speech() {
        Weather weather = model.getCurrentWeatherFromCache();
        if (weather == null) {
            return;
        }
        PermissionReq.with(view.getActivity())
                .permissions(Manifest.permission.READ_PHONE_STATE)
                .result(new PermissionReq.Result() {
                    @Override
                    public void onGranted() {
                        String text = Utils.voiceText(view.getContext(), weather.daily_forecast.get(0));
                        mSpeechSynthesizer.speak(text);
                    }

                    @Override
                    public void onDenied() {
                        view.showSnack("没有�?��?，无法播报天气�?");
                    }
                })
                .request();
    }

