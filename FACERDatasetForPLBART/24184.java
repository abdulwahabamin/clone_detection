    public RepeatingImageButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (attrs != null) {
            myKeyCode = attrs.getAttributeIntValue(XMLNS, KEY_CODE, -1);
        } else {
            myKeyCode = -1;
        }
        setFocusable(true);
        setLongClickable(true);
    }

