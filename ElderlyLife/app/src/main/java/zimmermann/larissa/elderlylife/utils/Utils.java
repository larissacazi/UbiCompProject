package zimmermann.larissa.elderlylife.utils;

import android.text.TextUtils;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by laris on 27/11/2017.
 */

public class Utils {

    public static final int OWNER_USER = 1;
    public static final int APP_USER = 2;

    public static boolean isEditTextEmpty(EditText editText) {
        String text = editText.getText().toString();
        if(TextUtils.isEmpty(text)) return true;
        return false;
    }

    public static boolean checkPassword(EditText passwordText, EditText confirmPasswordText) {
        String pwd = passwordText.getText().toString();
        String confirmPwd = confirmPasswordText.getText().toString();

        if(pwd.matches(confirmPwd)) return true;

        return false;
    }

    public static String getDatePrintableFormat(String date) throws ParseException {
        Date dateVerify = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);

        String newDate = dateVerify.getDay() + "/" + dateVerify.getMonth() + "/" + dateVerify.getYear();

        return newDate;
    }
}
