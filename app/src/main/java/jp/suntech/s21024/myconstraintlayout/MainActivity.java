package jp.suntech.s21024.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloListener listener = new HelloListener();

        Button btConfirm = findViewById(R.id.btConfirm);
        btConfirm.setOnClickListener(listener);

        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);

        Button btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(listener);

    }
    private class HelloListener implements View.OnClickListener{

        boolean flag = false;
        @Override
        public void onClick(View view) {
//            EditText input = findViewById(R.id.etName);
//            EditText input2 = findViewById(R.id.etAddress);
//            TextView output = findViewById(R.id.tvOutput);
            EditText name = findViewById(R.id.etName);
            EditText mail = findViewById(R.id.etMail);
            EditText mailtitle = findViewById(R.id.etMailtitle);
            EditText comment = findViewById(R.id.etComment);
            String namestr = name.getText().toString();
            String mailstr = mail.getText().toString();
            String mailtitlestr= mailtitle.getText().toString();
            String commentstr = comment.getText().toString();
            String show = "名前：" + namestr + "\nメールアドレス：" + mailstr + "\nタイトル：" + mailtitlestr + "\n質問内容：" + commentstr;

            int id = view.getId();
            switch (id){
                case R.id.btConfirm:
//                    String inputStr = input.getText().toString();
//                    String inputStr2 = input2.getText().toString();
//                    output.setText(inputStr2+ "にお住まいの" + inputStr + "さん、こんにちは！");
                    ConfirmDialogFragment dialogFragment = new ConfirmDialogFragment(show);
                    dialogFragment.show(getSupportFragmentManager(),"ConfirmDialogFragment");
                    break;
                case R.id.btClear:
//                    input.setText("");
                    name.setText("");
                    mail.setText("");
                    mailtitle.setText("");
                    comment.setText("");
                    break;
                case R.id.btSend:
//                    input2.setText("");
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}