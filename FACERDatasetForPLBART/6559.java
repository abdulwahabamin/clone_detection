        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (mIgnoreNextEdit) {
                mIgnoreNextEdit = false;
            } else {
                mReplaceTarget = null;
            }
        }

