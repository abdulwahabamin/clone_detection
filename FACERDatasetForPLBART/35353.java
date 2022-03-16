    public void generateTextView(View v) {
        TextView textView = new TextView(getActivity());
        textView.setText("å¤©æ°”æ˜“å?˜ï¼Œæ³¨æ„?å¤©æ°”å?˜åŒ–");
        View[] view = {v.findViewById(R.id.toolbar), v.findViewById(R.id.view), v.findViewById(R.id
                .item_cloths), v.findViewById(R.id.item_sports)};
        int totalHeight = 0;
        for (View aView : view) {
            totalHeight += getViewHeight(aView, true) + DisplayUtil.dip2px(getActivity(), 10);
        }
        int pxHeight = ScreenUtil.getScreenHW2(getActivity())[1] - totalHeight;
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, pxHeight / 2);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(ContextCompat.getColor(getActivity(), R.color.white));
        textView.setLayoutParams(lp);
        action_bar.addView(textView);
    }

