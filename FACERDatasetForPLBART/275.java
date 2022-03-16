    /**
     * Android 6.0 åŠ¨æ€?ç”³è¯·æŽˆæ?ƒå®šä½?ä¿¡æ?¯æ?ƒé™?ï¼Œå?¦åˆ™æ‰«æ??è“?ç‰™åˆ—è¡¨ä¸ºç©º
     */
    private void requestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    Toast.makeText(this, "ä½¿ç”¨è“?ç‰™éœ€è¦?æŽˆæ?ƒå®šä½?ä¿¡æ?¯", Toast.LENGTH_LONG).show();
                }
                //è¯·æ±‚æ?ƒé™?
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                        REQUEST_ACCESS_COARSE_LOCATION_PERMISSION);
            }
        }
    }

