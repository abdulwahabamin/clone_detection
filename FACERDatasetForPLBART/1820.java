    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
        list.addAll(RealmManager.getAllStoredContacts().findAll());
        if (list.size()>0)
        {
            ll_empty.setVisibility(View.GONE);
        }else
        {
            ll_empty.setVisibility(View.VISIBLE);
        }

        cAdapter.notifyDataSetChanged();
        EventBus.getDefault().register(this);
    }

