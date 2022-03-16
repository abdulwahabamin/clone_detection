    public void launch() {
        if (intent != null && from != null && to != null) {
            intent.setClass(from, to);
            intent.putExtras(getBundleData());
            if (options == null) {
                if (requestCode < 0) {
                    from.startActivity(intent);
                } else {
                    from.startActivityForResult(intent, requestCode);
                }
                if (enterAnim > 0 && exitAnim > 0) {
                    from.overridePendingTransition(enterAnim, exitAnim);
                }
            } else {
                if (requestCode < 0) {
                    ActivityCompat.startActivity(from, intent, options.toBundle());
                } else {
                    ActivityCompat.startActivityForResult(from, intent, requestCode, options.toBundle());
                }
            }
        }
    }

