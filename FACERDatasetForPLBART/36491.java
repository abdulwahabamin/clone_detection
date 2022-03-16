    /**
     * �?�父容器中添加空白View
     */
    private void addBlankView(Context context) {
        View transparentView = new View(context);
        transparentView.setBackgroundColor(Color.TRANSPARENT);
        transparentView.setLayoutParams(new LayoutParams(intervalValue, LayoutParams.WRAP_CONTENT));
        this.addView(transparentView);
    }

