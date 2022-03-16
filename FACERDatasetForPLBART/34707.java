    public void showToast(Context context, String string) {
        viewGroup = new ViewGroup(context) {
            @Override
            protected void onLayout(boolean changed, int l, int t, int r, int b) {

            }
        };
        View layout = LayoutInflater.from(context).inflate(R.layout.layout_toast,
                viewGroup,false);
        TextView textView = (TextView) layout.findViewById(R.id.toast_text);
        ImageView img = (ImageView) layout.findViewById(R.id.toast_img);
        textView.setText(string);
        img.setImageResource(R.mipmap.ic_sentiment_dissatisfied_black_24dp);
        if(toast == null){
            toast = new Toast(context);
        }
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

