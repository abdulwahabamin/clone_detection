        /**
         * Creates a new RangeSeekBar.
         * 
         * @param absoluteMinValue
         *            The minimum value of the selectable range.
         * @param absoluteMaxValue
         *            The maximum value of the selectable range.
         * @param context
         * @throws IllegalArgumentException
         *             Will be thrown if min/max value type is not one of Long, Double, Integer, Float, Short, Byte or BigDecimal.
         */
        public RangeSeekBar(T absoluteMinValue, T absoluteMaxValue, Context context) throws IllegalArgumentException {
                super(context);
                this.absoluteMinValue = absoluteMinValue;
                this.absoluteMaxValue = absoluteMaxValue;
                absoluteMinValuePrim = absoluteMinValue.doubleValue();
                absoluteMaxValuePrim = absoluteMaxValue.doubleValue();
                numberType = NumberType.fromNumber(absoluteMinValue);

                // make RangeSeekBar focusable. This solves focus handling issues in case EditText widgets are being used along with the RangeSeekBar within ScollViews.
                setFocusable(true);
                setFocusableInTouchMode(true);
                init();
        }

