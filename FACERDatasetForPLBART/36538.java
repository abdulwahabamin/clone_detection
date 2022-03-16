    /**
     * 显示进度对�?框
     *
     * @author �?�?宇 2016-7-21 下�?�11:51:42
     */
    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("加载中...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

