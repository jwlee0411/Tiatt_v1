package tiatt.jw.ui.wordmix;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WordMixViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WordMixViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}