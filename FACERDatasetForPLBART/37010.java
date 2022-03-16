    @Override
    public void locate() {
        if (hasAutoLocate()) {
            view.showSnack("å·²æ·»åŠ è‡ªåŠ¨å®šä½?");
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
                        view.showSnack("æ²¡æœ‰ä½?ç½®ä¿¡æ?¯æ?ƒé™?ï¼Œæ— æ³•èŽ·å?–å½“å‰?ä½?ç½®ï¼?");
                    }
                })
                .request();
    }

