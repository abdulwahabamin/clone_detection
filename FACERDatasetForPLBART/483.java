    @Override
    protected void initEvent() {
        mAddFriendLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mBluetoothDevices.get(position).getBondState() != BluetoothDevice.BOND_BONDED){
                    startPair();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        mBluetoothDevices.get(position).createBond();
                    } else{
                        //利用�??射方法调用BluetoothDevice.createBond(BluetoothDevice remoteDevice);
                        Method createBondMethod = null;
                        try {
                            createBondMethod =BluetoothDevice.class.getMethod("createBond");
                            createBondMethod.invoke(mBluetoothDevices.get(position));
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                    mProgressDialog.setMessage(getString(R.string.add_friend_loading));
                    mProgressDialog.show();
                } else{
                    ToastUtil.showToast(mContext, getString(R.string.already_is_friend));
                }
            }
        });
    }

