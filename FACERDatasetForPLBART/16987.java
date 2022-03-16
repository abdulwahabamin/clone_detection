    public static void requestPermission(final Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return;
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale
                    (activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                DialogHelper.showRationalePermissionDialog(activity, new DialogHelper.OnPositiveButtonListener() {
                    @Override
                    public void onPositiveButtonClick() {
                        ActivityCompat.requestPermissions(activity,
                                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                REQUEST_CODE);
                    }
                });
//                Snackbar.make(activity.findViewById(android.R.id.content),
//                        "Please Grant Permissions", Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",
//                        new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                ActivityCompat.requestPermissions(activity,
//                                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                                        REQUEST_CODE);
//                            }
//                        }).show();
            } else {
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        REQUEST_CODE);
            }
        } else {
            //Call whatever you want
        }
    }

