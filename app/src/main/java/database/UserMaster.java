package database;

import android.provider.BaseColumns;

public final class UserMaster {
    private UserMaster() {

    }
    protected static class User implements BaseColumns {

        protected static final String TABLE_NAME = "users";
        protected static final String COLUMN_NAME_USERNAME = "username";
        protected static final String COLUMN_NAME_PASSWORD = "password";
    }
}
