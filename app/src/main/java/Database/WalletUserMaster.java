package Database;

import android.provider.BaseColumns;

public final class WalletUserMaster {

    private WalletUserMaster(){ }

    /*------------------------------------Gayani---------------------------------------------------------------*/
    protected static class Addexpences implements BaseColumns{
        protected static final String TABLE_NAME_ADDEXPENCES = "addexpences";

        protected  static final String COLUMN_NAME_ID = "id";
        protected static final String COLUMN_NAME_EXPENCE = "expences";
        protected static final String COLUMN_NAME_CATEGORI = "category";
        protected static final String COLUMN_NAME_NOTE = "note";
        protected static final String COLUMN_NAME_DATE = "date";


    }
    protected static class Addincome implements BaseColumns{
        protected static final String TABLE_NAME_ADDINCOME = "addincome";

        protected  static final String COLUMN_NAME_ID = "id";
        protected static final String COLUMN_NAME_INCOME = "income";
        protected static final String COLUMN_NAME_CATEGORI = "category";
        protected static final String COLUMN_NAME_NOTE = "note";
        protected static final String COLUMN_NAME_DATE = "date";


    }

    //prabhashi's methods=========================================================================

    protected static  class IncomeCategory implements  BaseColumns{
        protected  static  final String TABLE_NAME_INCOME = "income";
        protected  static  final String COLUMN_NAME_INCOMENAME = "name";
    }



    /*----------------------------Thenuak-----------------------*/

    protected static class AddAcountCategory implements BaseColumns {
        protected static final String TABLE_NAME_ACCOUNT = "account";
        protected static final String COLUME_NAME_ACOUNT_TYPE = "acounttype";
        protected static final String COLUME_NAME_AMOUNT = "amount";
    }

    protected static class AddIncomeAcountCategory implements BaseColumns{
        protected static final String TABLE_NAME_INCOME_ACCOUNT = "incomeacount";
        protected static final String COLUME_NAME_INCOME_ACOUNT_TYPE = "incomeacount";
        protected static final String COLUME_NAME_INCOME_AMOUNT = "incomeamount";



    }

    /*----------------------------end Thenuak-----------------------*/
    protected static  class ExpensesCategory implements  BaseColumns{
        protected  static  final String TABLE_NAME_Expenses = "income";
        protected  static  final String COLUMN_NAME_EXPENSESNAME = "name";
    }

}
