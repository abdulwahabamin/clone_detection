    @Override
    public void locate() {
        if (hasAutoLocate()) {
            view.showSnack("已添加自动定�?");
            return;
        }

        PermissionReq.with(view.getActivity())
                .permissions(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                .result(new PermissionReq.Result() {
                    @Override
                    public void onGranted() {
                        LocationManager.get().start();
                        view.showProgress(view.getContext().getString(R.string.locating));
                    }

                    @Override
                    public void onDenied() {
                        view.showSnack("没有�?置信�?��?��?，无法获�?�当�?�?置�?");
                    }
                })
                .request();
    }

