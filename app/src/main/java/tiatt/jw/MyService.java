package tiatt.jw;

import android.app.Service;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MyService extends Service {

    ServiceThread serviceThread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public void onCreate()
    {
        super.onCreate();
        System.out.println("서비스의 onCreate");

        ClipboardManager clipboard = (ClipboardManager) this.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.addPrimaryClipChangedListener(mPrimaryChangeListener);



    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        // 서비스가 호출될 때마다 실행
        Log.d("test", "서비스의 onStartCommand");
        System.out.println("★★★★★★ Start됨 ★★★★★★★★");






        return super.onStartCommand(intent, flags, startId);
    }

    public class myServiceHandler extends Handler {

        @Override
        public void publish(LogRecord logRecord) {

        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {


        }
    }





    ClipboardManager.OnPrimaryClipChangedListener mPrimaryChangeListener = new ClipboardManager.OnPrimaryClipChangedListener() {
        public void onPrimaryClipChanged() {
            System.out.println("★★★★★★ 복사됨 ★★★★★★★★");

            // this will be called whenever you copy something to the clipboard

        }
    };



    public void onDestory()
    {
        super.onDestroy();
        System.out.println("서비스의 onDestroy");
    }
}
