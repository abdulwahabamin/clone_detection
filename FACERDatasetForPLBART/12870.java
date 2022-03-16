    /**
     * Constructor of <code>ColorPickerPreference</code>
     *
     * @param context The current context
     * @param attrs The attributes of the XML tag that is inflating the preference.
     */
    public ColorPickerPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWidgetLayoutResource(R.layout.color_picker_pref_item);
    }

