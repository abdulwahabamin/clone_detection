    @Override
    public void startImageWeather() {
        PermissionReq.with(view.getActivity())
                .permissions(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                .result(new PermissionReq.Result() {
                    @Override
                    public void onGranted() {
                        Intent intent = new Intent(view.getActivity(), ImageWeatherActivity.class);
                        view.getActivity().startActivity(intent);
                    }

                    @Override
                    public void onDenied() {
                        view.showSnack("æ²¡æœ‰ä½?ç½®ä¿¡æ?¯æ?ƒé™?ï¼Œæ— æ³•æ‰“å¼€å®žæ™¯å¤©æ°”ï¼?");
                    }
                })
                .request();
    }

