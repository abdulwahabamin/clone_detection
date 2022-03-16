    /***
     * After the permissions are requested, pass the results from Activity/fragments onRequestPermissionsResult to this function for processing
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @RequiresApi(Build.VERSION_CODES.M)
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (isViewAttached()) {
            String permission_name = "";
            boolean never_ask_again = false;
            granted.clear();

            for (String permission : deniedpermissions) {
                if (getActivity().checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED) {
                    granted.add(permission);
                } else {
                    if (!getActivity().shouldShowRequestPermissionRationale(permission)) {
                        never_ask_again = true;
                    }
                    permission_name += "," + PermissionHelper.getNameFromPermission(permission);
                }
            }

            deniedpermissions.removeAll(granted);

            if (deniedpermissions.size() > 0) {
                permission_name = permission_name.substring(1);
                if (!never_ask_again) {
                    getRequestAgainAlertDialog(getActivity(), permission_name,requestCode);
                } else {
                    goToSettingsAlertDialog(getActivity(), permission_name,requestCode);
                }
            } else {
                getListener().onPermissionGranted(requestCode);
            }
        }
    }

