    private void saveData() {
        if (list.size()>0)
        {
            RealmManager.getRealm().beginTransaction();
            RealmManager.getAllStoredContacts().equalTo("macAddress",macAddress_other).findFirst().last_read_time=System.currentTimeMillis();
            RealmManager.getAllStoredContacts().equalTo("macAddress",macAddress_other).findFirst().name=name_other;
            RealmManager.getRealm().commitTransaction();
        }
    }

