    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_edit:
                editData();
                break;

            case R.id.btn_save:
                saveData();
                break;
        }
    }

