        public void setValue(Object value) {
            if (value != null && value.getClass() == Integer.class) {
                mValue = ((Integer)value).intValue();
                mHasValue = true;
            }
        }

