    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK) {
                    int i = Integer.parseInt(wnl_spf.getString("selectedCountyCount", "0"));
                    ffc_flag = new String[i];
                    for (int j = 0; j < i; j++) {
                        ffc_flag[j] = "false";
                    }
                    resetAdapterDataAndCurrentItem();
                }
                break;
            case 2:
                if(resultCode==RESULT_OK) {
                    resetAdapterDataAndCurrentItem();
                }
            default:
                break;
        }
    }

