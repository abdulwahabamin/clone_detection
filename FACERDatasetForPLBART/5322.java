    public void showOrHideOptions(int select) {
        switch (select) {

            case View.GONE:
                scrollView.setVisibility(View.GONE);
                break;

            case View.VISIBLE:

                scrollView.setVisibility(View.VISIBLE);
                cut.setVisibility(View.VISIBLE);
                copy.setVisibility(View.VISIBLE);
                details.setVisibility(View.VISIBLE);
                rename.setVisibility(View.VISIBLE);
                delete.setVisibility(View.VISIBLE);
                share.setVisibility(View.VISIBLE);
                create.setVisibility(View.VISIBLE);

                cut_t.setVisibility(View.VISIBLE);
                copy_t.setVisibility(View.VISIBLE);
                details_t.setVisibility(View.VISIBLE);
                rename_t.setVisibility(View.VISIBLE);
                delete_t.setVisibility(View.VISIBLE);
                create_t.setVisibility(View.VISIBLE);
                share_t.setVisibility(View.VISIBLE);
        }

    }

