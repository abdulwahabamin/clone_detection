        public void setValue(Object value) {
            if (value != null && value.getClass() == Float.class) {
                mValue = ((Float)value).floatValue();
                mHasValue = true;
            }
        }

