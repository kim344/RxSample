package com.kim344.rxsample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;

public class JavaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);

        Observable<String> source = Observable.just("RED","GREEN","YELLOW");
        Disposable disposable = source.subscribe(
                v -> Log.e("Confirm just",v),
                error -> Log.e("Confirm just", Objects.requireNonNull(error.getMessage())),
                () -> Log.e("Confirm just","OnComplete()")
        );
        Log.e("Confirm just",disposable.isDisposed()+"");



        Observable<Integer> createSource = Observable.create(
                (ObservableEmitter<Integer> emitter) -> {
                    emitter.onNext(100);
                    emitter.onNext(200);
                    emitter.onNext(300);
                    emitter.onNext(400);
                    emitter.onComplete();
                }
        );
        createSource.subscribe(data -> Log.e("Confirm create",data+""));



        String[] arr = {"A","B","C"};
        Observable<String> arrSource = Observable.fromArray(arr);
        arrSource.subscribe(arrData -> Log.e("Confirm fromArray",arrData));
    }

}
