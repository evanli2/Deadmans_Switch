package com.evan.deadmansswitch.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.evan.deadmansswitch.data.model.Contract;
import com.evan.deadmansswitch.data.model.Withdrawal;


@Database(entities = {Contract.class, Withdrawal.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ContractDao contractDao();

    public abstract WithdrawalDao withdrawalDao();
}
