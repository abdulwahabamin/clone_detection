    void setFilterButtonListener(){
        sort.setOnClickListener((View view) -> {
            Dialog sortDialog=new Dialog(this);
            sortDialog.getWindow().setBackgroundDrawableResource(R.drawable.curved_back);
            sortDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            sortDialog.setContentView(R.layout.sort_dialog_view);

            RadioButton name=sortDialog.findViewById(R.id.name);
            RadioButton size=sortDialog.findViewById(R.id.size);
            RadioButton date=sortDialog.findViewById(R.id.date);

            switch (currentSortOrder){

                case  R.id.name:
                    name.setChecked(true);
                    break;
                case R.id.size:
                    size.setChecked(true);
                    break;
                case R.id.date:
                    date.setChecked(true);
            }

            RadioGroup group=sortDialog.findViewById(R.id.group);
            group.setOnCheckedChangeListener((radioGroup, i) -> {
                switch (radioGroup.getCheckedRadioButtonId()){

                    case R.id.name:
                        mediaAdapter.setFileDirectoryList(Util.sortBy(fileList,Util.NAME));

                        break;

                    case R.id.size:
                        mediaAdapter.setFileDirectoryList(Util.sortBy(fileList,Util.SIZE));
                        break;

                    case R.id.date:
                        mediaAdapter.setFileDirectoryList(Util.sortBy(fileList,Util.DATE));
                        break;
                }
                currentSortOrder=group.getCheckedRadioButtonId();
                sortDialog.dismiss();
            });
            Button cancel=sortDialog.findViewById(R.id.cancel);
            cancel.setOnClickListener(view1 -> sortDialog.dismiss());
            sortDialog.show();
        });
    }

