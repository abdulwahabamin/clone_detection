    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTheme(R.style.DayTheme);
        if (MyApplication.nightMode2()) {
            initNightView(R.layout.night_mode_overlay);
        }

        View view = inflater.inflate(R.layout.fragment_about, container, false);
        TextView tv = (TextView) view.findViewById(R.id.link);
        String textStr = "https://github.com/byhieg/easyweather";
        tv.setAutoLinkMask(Linkify.WEB_URLS);
        tv.setText(textStr);
        Spannable s = (Spannable) tv.getText();
        s.setSpan(new UnderlineSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(ds.linkColor);
                ds.setUnderlineText(false);
            }
        }, 0, textStr.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return view;
    }

