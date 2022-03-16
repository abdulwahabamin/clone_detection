    public void initView() {
        cardView = (CardView) view.findViewById(R.id.item1);
        textView = (TextView) view.findViewById(R.id.lab_textview);
        textView.setText(R.string.nightMode1);
        aSwitch = (Switch) cardView.findViewById(R.id.cb);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(MyApplication.shareFilename2, getActivity().MODE_PRIVATE);
        boolean checked = sharedPreferences.getBoolean("ischecked", false);
        aSwitch.setChecked(checked);
        switchStatus(aSwitch, MyApplication.shareFilename2);


    }

