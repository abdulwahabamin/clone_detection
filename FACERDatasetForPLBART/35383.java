    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions,grantResults);
        switch(requestCode)
        {
            // requestCodeå?³æ‰€å£°æ˜Žçš„æ?ƒé™?èŽ·å?–ç ?ï¼Œåœ¨checkSelfPermissionæ—¶ä¼ å…¥
            case Constants.PERMISSION:
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                // èŽ·å?–åˆ°æ?ƒé™?ï¼Œä½œç›¸åº”å¤„ç?†ï¼ˆè°ƒç”¨å®šä½?SDKåº”å½“ç¡®ä¿?ç›¸å…³æ?ƒé™?å?‡è¢«æŽˆæ?ƒï¼Œå?¦åˆ™å?¯èƒ½å¼•èµ·å®šä½?å¤±è´¥ï¼‰
                MyApplication.getmLocationClient().start();
            }
            else
            {
                // æ²¡æœ‰èŽ·å?–åˆ°æ?ƒé™?ï¼Œå?šç‰¹æ®Šå¤„ç?†
                showToast("æ²¡æœ‰æ?ƒé™?ï¼Œå®šä½?å¤±è´¥");
            }
            break;
            default:
                break;
        }
    }

