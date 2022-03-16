    private void locate() {
        PermissionReq.with(view.getActivity())
                .permissions(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                .result(new PermissionReq.Result() {
                    @Override
                    public void onGranted() {
                        LocationManager.get().addLocationObserver(mLocationObserver);
                        LocationManager.get().start();
                    }

                    @Override
                    public void onDenied() {
                        onLocated(null);
                        view.showSnack("没有�?置信�?��?��?，无法获�?�当�?�?置�?");
                    }
                })
                .request();
    }

