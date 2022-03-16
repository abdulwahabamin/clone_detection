    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions,grantResults);
        switch(requestCode)
        {
            // requestCode�?�所声明的�?��?获�?��?，在checkSelfPermission时传入
            case Constants.PERMISSION:
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                // 获�?�到�?��?，作相应处�?�（调用定�?SDK应当确�?相关�?��?�?�被授�?�，�?�则�?�能引起定�?失败）
                MyApplication.getmLocationClient().start();
            }
            else
            {
                // 没有获�?�到�?��?，�?�特殊处�?�
                showToast("没有�?��?，定�?失败");
            }
            break;
            default:
                break;
        }
    }

