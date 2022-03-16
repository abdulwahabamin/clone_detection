    private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attrs)
            throws NotFoundException {

        ObjectAnimator anim = new ObjectAnimator();

        loadAnimator(context, attrs, anim);

        TypedArray a =
                context.obtainStyledAttributes(attrs, /*com.android.internal.R.styleable.*/PropertyAnimator);

        String propertyName = a.getString(/*com.android.internal.R.styleable.*/PropertyAnimator_propertyName);

        anim.setPropertyName(propertyName);

        a.recycle();

        return anim;
    }

