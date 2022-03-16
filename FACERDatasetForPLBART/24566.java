    public ActionCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.action_card_view, this);

        mTextView = (TextView) v.findViewById(R.id.text);
    }

