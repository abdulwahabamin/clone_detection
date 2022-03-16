    public void showToast(String text) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this,text,Toast.LENGTH_SHORT);
        mToast.show();

    }

