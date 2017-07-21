package kobe.com.loadingdialog;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by KOBE on 2017/7/21.
 * Dialog 对话框
 */

public class LoadingDialog extends Dialog{
    public LoadingDialog(Context context) {
        super(context);
    }

    public LoadingDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected LoadingDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
