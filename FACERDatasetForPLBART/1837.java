    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (current_name.equals(s.toString()) || s.length()==0)
        {
            save.setEnabled(false);
        }else {
            save.setEnabled(true);
        }
    }

