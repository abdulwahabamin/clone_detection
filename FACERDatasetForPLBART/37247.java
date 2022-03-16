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
                        view.showSnack("æ²¡æœ‰ä½?ç½®ä¿¡æ?¯æ?ƒé™?ï¼Œæ— æ³•èŽ·å?–å½“å‰?ä½?ç½®ï¼?");
                    }
                })
                .request();
    }

