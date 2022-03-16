    @Subscribe(threadMode = ThreadMode.MAIN)
    public void storeMessage(MessageEvent me) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).macAddress.equals(me.macAddress_other))
            {
                cAdapter.notifyItemChanged(i);
            }
        }
    }

