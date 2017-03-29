package com.kongdy.hasee.myinputapplication;

import android.inputmethodservice.InputMethodService;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

/**
 * @author kongdy
 * @date 2017-03-27 22:06
 * @TIME 22:06
 **/

public class MySoftInputService extends InputMethodService implements View.OnClickListener {


    @Override
    public View onCreateInputView() {
        View view = getLayoutInflater().inflate(R.layout.key_board, null);
        ViewGroup viewGroup = (ViewGroup) view;
        LinearLayout linearLayout = (LinearLayout) viewGroup.getChildAt(0);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            LinearLayout linearLayout1 = (LinearLayout) linearLayout.getChildAt(i);
            for(int j = 0; j < linearLayout1.getChildCount();j++) {
                View view1 = linearLayout1.getChildAt(j);
                view1.setOnClickListener(this);
            }

        }
        return view;
    }

    @Override
    public void onClick(View v) {

        if (v instanceof Button) {
            Button button = (Button) v;
            InputConnection inputConnection = getCurrentInputConnection();
            if(v.getId() == R.id.back) {
                inputConnection.deleteSurroundingText(1,0);
                inputConnection.commitText("",1);
            } else {
                // 获得InputConnection对象

                // 设置预输入文本
                // setComposingText方法的第2个参数值为1，表示在当前位置预输入文本
                inputConnection.setComposingText(button.getText(), 1);
                inputConnection.commitText(button.getText(), 1);
            }

        }
//        if (button.getId() == R.id.btn1) {
//            // 设置预输入文本
//            // setComposingText方法的第2个参数值为1，表示在当前位置预输入文本
//            inputConnection.setComposingText(button.getText(), 1);
//        } else {
//            // 向当前获得焦点的EditText控件输出文本
//            // commitText方法第2个参数值为1，表示在当前位置插入文本
//            inputConnection.commitText(button.getText(), 1);
//        }
    }
}
