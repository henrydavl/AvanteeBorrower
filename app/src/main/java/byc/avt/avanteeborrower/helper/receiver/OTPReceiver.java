package byc.avt.avanteeborrower.helper.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;

import byc.avt.avanteeborrower.helper.widget.PinViewEditText;

public class OTPReceiver extends BroadcastReceiver {

    private static PinViewEditText otpView;

    public void setEditText(PinViewEditText editText)
    {
        OTPReceiver.otpView = editText;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

        for (SmsMessage sms : messages)
        {
            String message = sms.getMessageBody();
            String otp = message.split(": ")[1];
            otpView.setValue(otp);
        }
    }
}
