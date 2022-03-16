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
                        view.showSnack("没有�?置信�?��?��?，无法打开实景天气�?");
                    }
                })
                .request();
    }

