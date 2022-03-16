    @Override
    public void onItemLongClick(final int position) {
        final PopupMenu popup = new PopupMenu(this, recyclerView.getChildAt(position));
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.user_actions, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId()==R.id.action_delete)
                {
                    recyclerView.post(new Runnable() {
                        @Override
                        public void run() {
                            final int m_id=list.get(position).message_id;
                            final String mac=list.get(position).macAddress;
                            list.remove(position);
                            cAdapter.notifyItemRemoved(position);
                            try {
                                MyApplication.closeBluetoothService(mac);
                            }catch (Exception e)
                            {
                                e.printStackTrace();
                            }

                            RealmManager.getRealm().executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {
                                    realm.where(User.class).equalTo("macAddress",mac).findFirst().deleteFromRealm();
                                    realm.where(Message.class).equalTo("id", m_id).findAll().deleteAllFromRealm();
                                }
                            });
                        }
                    });

                }
                return true;
            }
        });
        popup.show();
    }

